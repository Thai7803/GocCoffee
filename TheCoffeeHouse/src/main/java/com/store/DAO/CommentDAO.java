package com.store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.store.entity.Comment;
import com.store.entity.Order;
import com.store.entity.OrderDetail;
import com.store.entity.Product;


public interface CommentDAO extends JpaRepository<Comment, Integer>{

	@Query(value = "select * from Comments where ProductId = ?1", nativeQuery = true)
	List<Comment> findByProductId(Integer id);

	
	
	
	@Query("SELECT o FROM Comment o WHERE o.account.username = ?1")
	Comment findByUsername(String username);



}
