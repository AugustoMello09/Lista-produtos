package io.gitHub.AugustoMello09.oak.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import io.gitHub.AugustoMello09.oak.dtos.ProductDTO;
import io.gitHub.AugustoMello09.oak.entities.Product;
import io.gitHub.AugustoMello09.oak.providers.ProductProvider;
import io.gitHub.AugustoMello09.oak.providers.ProductProviderDTO;
import io.gitHub.AugustoMello09.oak.repositories.ProductRepository;
import io.gitHub.AugustoMello09.oak.services.exceptions.ObjectNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	private static final UUID ID = UUID.fromString("148cf4fc-b379-4e25-8bf4-f73feb06befa");

	@InjectMocks
	private ProductService service;

	@Mock
	private ProductRepository repository;

	@Mock
	private ModelMapper modelMapper;

	private ProductProvider productProvider;
	private ProductProviderDTO productProviderDTO;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		productProvider = new ProductProvider();
		productProviderDTO = new ProductProviderDTO();
		service = new ProductService(repository, modelMapper);
	}

	@DisplayName("Deve retornar um Produto com sucesso.")
	@Test
	public void shouldReturnAProductWithSuccess() {
		Product product = productProvider.create();
		ProductDTO productDTO = productProviderDTO.create();

		when(repository.findById(productProvider.getId())).thenReturn(Optional.of(product));
		when(modelMapper.map(product, ProductDTO.class)).thenReturn(productDTO);

		var response = service.findById(productProvider.getId());

		assertNotNull(response);
		assertEquals(ProductDTO.class, response.getClass());
		assertEquals(productProvider.getId(), response.getId());
	}

	@DisplayName("Deve retornar um produto não encontrado.")
	@Test
	public void shouldReturnProductNotFound() {
		when(repository.findById(ID)).thenReturn(Optional.empty());
		assertThrows(ObjectNotFoundException.class, () -> service.findById(ID));
	}

	@DisplayName("Deve criar um produto com sucesso.")
	@Test
	public void whenCreateThenReturnProductDTO() {

		Product product = productProvider.create();
		ProductDTO productDTO = productProviderDTO.create();

		when(repository.save(any(Product.class))).thenReturn(product);
		when(modelMapper.map(any(Product.class), eq(ProductDTO.class))).thenReturn(productDTO);

		service.create(productDTO);

		verify(repository, times(1)).save(any(Product.class));
	}

	@DisplayName("Atualização Deve retornar sucesso.")
	@Test
	public void shouldUpdateReturnSuccess() {
		Product product = productProvider.create();
		ProductDTO productDTO = productProviderDTO.create();

		when(repository.findById(ID)).thenReturn(Optional.of(product));
		when(repository.save(any(Product.class))).thenReturn(product);
		when(modelMapper.map(product, ProductDTO.class)).thenReturn(productDTO);

		service.update(productDTO, ID);

		verify(repository, times(1)).findById(ID);
		verify(repository, times(1)).save(any(Product.class));
	}

	@DisplayName("Atualização Deve retornar produto não encontrado.")
	@Test
	public void shouldUpdateReturnProductNotFound() {
		ProductDTO productDTO = productProviderDTO.create();
		when(repository.findById(ID)).thenReturn(Optional.empty());
		assertThrows(ObjectNotFoundException.class, () -> service.update(productDTO, ID));
	}

	@DisplayName("Deve deletar um produto com sucesso.")
	@Test
	public void shouldDeleteWithSuccess() {
		Product product = productProvider.create();
		when(repository.findById(ID)).thenReturn(Optional.of(product));
		service.delete(ID);
	}

	@DisplayName("Deve não encontrar um produto ao deletar.")
	@Test
	public void shouldReturnProductNotFoundWhenDelete() {
		when(repository.findById(ID)).thenReturn(Optional.empty());
		assertThrows(ObjectNotFoundException.class, () -> service.delete(ID));
	}

	@DisplayName("Deve retornar uma lista de Produtos com sucesso.") 
	@Test 
	public void shouldReturnAListOfProductsWithSuccess() { 
		 Product product = productProvider.create();
		 ProductDTO productDTO = productProviderDTO.create(); 
		 
		 List<Product> products = Collections.singletonList(product); 
		 
		 when(repository.findAllOrderByPrice()).thenReturn(products); 
		 when(modelMapper.map(product, ProductDTO.class)).thenReturn(productDTO);  
		 
		 List<ProductDTO> result = service.findAll();
		 
		 assertNotNull(result); 
		 assertEquals(1, result.size());
		 assertEquals(productDTO.getId(), result.get(0).getId());
		 assertEquals(productDTO.getName(), result.get(0).getName()); 
		 
		 verify(repository, Mockito.times(1)).findAllOrderByPrice(); 
		 verify(modelMapper, Mockito.times(1)).map(product, ProductDTO.class);
		 
	}
	
	

}
