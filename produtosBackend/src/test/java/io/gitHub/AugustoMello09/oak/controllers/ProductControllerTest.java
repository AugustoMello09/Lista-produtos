package io.gitHub.AugustoMello09.oak.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.gitHub.AugustoMello09.oak.dtos.ProductDTO;
import io.gitHub.AugustoMello09.oak.providers.ProductProviderDTO;
import io.gitHub.AugustoMello09.oak.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	private static final UUID ID = UUID.fromString("148cf4fc-b379-4e25-8bf4-f73feb06befa");
	
	@InjectMocks
	private ProductController controller;
	
	@Mock
	private ProductService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	private ProductProviderDTO productProviderDTO;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		productProviderDTO = new ProductProviderDTO();
		controller = new ProductController(service);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		objectMapper = new ObjectMapper();
	}
	
	@DisplayName("Deve retornar um produto. ")
	@Test
	public void shouldControllerReturnFindById() {
		ProductDTO productDTO = productProviderDTO.create();
		when(service.findById(ID)).thenReturn(productDTO);
		var response = controller.findById(ID);
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(ProductDTO.class, response.getBody().getClass());
	}

	@DisplayName("Deve criar um Protudo. ")
	@Test
	public void shouldReturnCreatedProductDTOOnController() throws Exception {
		ProductDTO productDTO = productProviderDTO.create();
		when(service.create(any(ProductDTO.class))).thenReturn(productDTO);
		mockMvc.perform(post("/v1/product/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productDTO))).andExpect(status().isCreated());
		
	}

	@DisplayName("Deve atualizar o produto. ")
	@Test
	public void shouldReturnUpdateProductDTOOnController() {
		ProductDTO productDTO = productProviderDTO.create();
		
		when(service.update(productDTO, ID)).thenReturn(productDTO);
		
		ResponseEntity<ProductDTO> response = controller.update(productDTO, ID);
		
		assertNotNull(response);
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(service, times(1)).update(productDTO, ID);
	}
	
	
	@DisplayName("Deve retornar uma paginação de produtos. ")
	@Test
	public void shouldReturnListProductDTO() {
		List<ProductDTO> products = new ArrayList<>();
		when(service.findAll()).thenReturn(products);
		ResponseEntity<List<ProductDTO>> response = controller.findAll();
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(service).findAll();
	}
	
	@DisplayName("Deve deletar um produto. ")
	@Test
	public void shouldDeleteProductWithSuccess() {
		doNothing().when(service).delete(ID);
		ResponseEntity<Void> response = controller.delete(ID);
		assertNotNull(response);
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		verify(service, times(1)).delete(ID);;
	}

}
