package com.tsys.retail.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tsys.retail.entity.Product;
import com.tsys.retail.model.ProductInfo;
import com.tsys.retail.service.ProductService;


@RestController
public class ProductController {

  final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(
		 @Valid @RequestBody ProductInfo productInfo) {
		logger.info("Input recieved to create product = " + productInfo);
		Product product = productService.createProduct(productInfo);
		logger.info("Created product with id = " + product.getId());

		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(
			 @PathVariable Long id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}



}
