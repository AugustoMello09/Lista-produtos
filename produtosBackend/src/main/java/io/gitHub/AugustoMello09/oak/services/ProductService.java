package io.gitHub.AugustoMello09.oak.services;

import org.springframework.stereotype.Service;

import io.gitHub.AugustoMello09.oak.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository repository;

}
