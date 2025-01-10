package io.gitHub.AugustoMello09.oak.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gitHub.AugustoMello09.oak.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/v1/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;

}
