package io.gitHub.AugustoMello09.oak.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.oak.dtos.ProductDTO;
import io.gitHub.AugustoMello09.oak.entities.Product;
import io.gitHub.AugustoMello09.oak.repositories.ProductRepository;
import io.gitHub.AugustoMello09.oak.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository repository;
	private final ModelMapper mapper;

	@Transactional(readOnly = true)
	public ProductDTO findById(UUID id) {
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ObjectNotFoundException("Product not found."));
		return mapper.map(entity, ProductDTO.class);
	}

	@Transactional
	public ProductDTO create(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());
		product.setAvailable(productDTO.getAvailable());
		repository.save(product);
		return mapper.map(product, ProductDTO.class);
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> entities = repository.findAllOrderByPrice();
		return entities.stream().map(x -> mapper.map(x, ProductDTO.class)).collect(Collectors.toList());
	}

	public void delete(UUID id) {
		findById(id);
		repository.deleteById(id);
	}

	@Transactional
	public ProductDTO update(ProductDTO productDTO, UUID id) {
		Product entity = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Product not found."));
		entity.setName(productDTO.getName());
		entity.setDescription(productDTO.getDescription());
		entity.setPrice(productDTO.getPrice());
		entity.setAvailable(productDTO.getAvailable());
		repository.save(entity);
		return mapper.map(entity, ProductDTO.class);
	}

}
