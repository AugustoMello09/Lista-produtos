package io.gitHub.AugustoMello09.oak.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.gitHub.AugustoMello09.oak.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	@Query("SELECT a FROM Product a ORDER BY a.price ASC")
	List<Product> findAllOrderByPrice();

}
