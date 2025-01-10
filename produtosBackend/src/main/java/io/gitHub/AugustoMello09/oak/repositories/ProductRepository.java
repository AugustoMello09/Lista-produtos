package io.gitHub.AugustoMello09.oak.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gitHub.AugustoMello09.oak.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
