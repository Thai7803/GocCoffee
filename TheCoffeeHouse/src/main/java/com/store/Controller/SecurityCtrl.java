package com.store.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.SecurityConfig;
import com.store.DAO.AccountDAO;
import com.store.entity.Account;
import com.store.entity.UserForm;
import com.store.service.AccountService;
import com.store.service.Impl.MailerServiceImpl;
import com.store.utils.ParamService;
import com.store.utils.SessionService;

import net.bytebuddy.utility.RandomString;



@Controller
public class SecurityCtrl {
	
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	SessionService session;
	@Autowired
	ParamService paramService;
	@Autowired
	MailerServiceImpl mailer;
	@Autowired
	ServletContext app;
	
	// OAuth2
	@Autowired
	SecurityConfig config;
	
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		config.loginFromOAuth2(oauth2);
		return "forward:/security/login/success";
	}
	
//	
	
	private static final Logger log = LoggerFactory.getLogger(SecurityCtrl.class);
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	@GetMapping("/security/register")
	public String getPage(Account account) {
		return "security/register";
	}
	@RequestMapping("/security/register")
	public String register(Model model) {
		Account item = new Account();
		model.addAttribute("item", item);
		return "security/register";
	}
	@RequestMapping("/register/create")
	public String create(@Valid @ModelAttribute("account") Account account, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("account", account);
			return "security/register";
		}
		accountDAO.save(account);
		model.addAttribute("message", "Insert successfully");
		return "security/login";
	}
	
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Không có quyền truy cập");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
	@CrossOrigin("*")
	@ResponseBody
	@RequestMapping("/rest/security/authentication")
	public Object getAuthentication(HttpSession session) {
		return session.getAttribute("authentication");
	}
	
	@RequestMapping("/security/forgot-password")
	public String index() {		
		return "security/forgot-password";
	}
	

	@SuppressWarnings("unused")
	@PostMapping("/security/forgot-password")
	public String forgot(Model model) {
		String email = paramService.getString("email", "");
		String username = paramService.getString("username", "");
		String subject = "Send your Password !";
		String body = "Your Password: ";
		String randomPassword = RandomString.make(6);
		
		try {
			Account user = accountDAO.findById(username).get();
				if(!user.getEmail().equals(email)) {
					model.addAttribute("message", " Email Wrong !");
				}
				else {
					user.setPassword(randomPassword);
					accountDAO.save(user);
					mailer.send(email, subject, body+randomPassword);
					mailer.send(email, subject, body+user.getPassword());
					model.addAttribute("message", "Please check your Email!" +randomPassword);
				}
		} catch (Exception e) {
			model.addAttribute("message", body+randomPassword);
			System.out.println(e);
		}
		return "security/forgot-password";
	}

	
	// Change Pass
		@GetMapping("/security/change-password")
		public String changepass() {
			return "security/change-password";
		}
		
		@PostMapping("/security/change-password")
		public String change(Model model) {
			String username = paramService.getString("username", "");
			String password = paramService.getString("password", "");
			String newpassword= paramService.getString("newpassword", "");
			String confirmpassword= paramService.getString("confirmpassword", "");
			try {
				Account user = accountDAO.findById(username).get();
					if(!user.getPassword().equals(password)) {
						model.addAttribute("message", "Wrong Password!");
					}else {
						if(newpassword.equals(confirmpassword)) {
							user.setPassword(confirmpassword);
							accountDAO.save(user);
							model.addAttribute("message", "Change Password Done !");
						}else {
							model.addAttribute("message", "Password not match !");
						}
					}
			} catch (Exception e) {
				model.addAttribute("message", "Account does not exist !");
			}
			return "security/change-password";
		}
	
}
