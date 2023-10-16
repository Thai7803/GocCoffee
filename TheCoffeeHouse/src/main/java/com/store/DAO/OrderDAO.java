package com.store.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.entity.Order;






public interface OrderDAO extends JpaRepository<Order, Long>{
	
	@Query("Select o from Order o where o.createDate between ?1 and ?2")
	Page<Order> findOrderByDate(Date firstDate, Date lastDate, Pageable pageable);

	@Query("SELECT o FROM Order o WHERE o.account.username = ?1")
	List<Order> findByUsername(String username);
	
	@Query(value = "select * from Orders order by Id DESC;", nativeQuery = true)
	List<Order> findAllDESC();
}
