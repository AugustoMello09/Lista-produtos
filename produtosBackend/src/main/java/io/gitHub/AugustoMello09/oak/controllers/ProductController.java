package io.gitHub.AugustoMello09.oak.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.gitHub.AugustoMello09.oak.dtos.ProductDTO;
import io.gitHub.AugustoMello09.oak.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/v1/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		var response = service.findById(id);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO objDto) {
		var newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newObj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		var response = service.findAll();
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO objDto, @PathVariable UUID id) {
		var response = service.update(objDto, id);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
