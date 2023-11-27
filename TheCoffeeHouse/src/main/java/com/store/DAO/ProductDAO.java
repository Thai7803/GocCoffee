package com.store.DAO;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.entity.Product;


public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(String string);

	@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
	Page<Product> findByKeywords(String keywords, Pageable pageable);
	@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
	List<Product> findByKeywords(String string);

	
	@Query("select o from Product o where o.price between 1 and 2 order by price")
	List<Product> findByPriceBetween(double minPrice, double maxPrice);
	
	@Query("select o from Product o where o.price between 2 and 4 order by price")
	List<Product> findByPriceBetween2(double minPrice, double maxPrice);

	@Query("select o from Product o where o.price >= 4 order by price")
	List<Product> findByPrice4(double maxPrice);


}
