package com.store.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.store.entity.OrderDetail;
import com.store.entity.RevenueReport;
import com.store.entity.TopProduct;






public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

//	@Query("SELECT o FROM OrderDetail o WHERE o.order.id = ?1")
//	Page<OrderDetail> findByOrder(Long id, Pageable pageable);
	
	
	@Query("SELECT new TopProduct(o.product, sum(o.quantity)) FROM OrderDetail o GROUP BY o.product ORDER BY sum(o.quantity) DESC")
	List<TopProduct> getTop10();
////
	@Query("SELECT o FROM OrderDetail o WHERE o.order.id = ?1")
	List<OrderDetail> findByOrderID(Long orderid);
	@Query("Select new RevenueReport(d.product.category, sum(d.price*d.quantity), sum(d.quantity))"
			+ " from OrderDetail d Group By d.product.category")
	List<RevenueReport> getRevenueByCategory();
}