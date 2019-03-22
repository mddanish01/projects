package com.tsys.retail.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsys.retail.entity.Product;
import com.tsys.retail.exception.ApplicationException;
import com.tsys.retail.model.ProductInfo;
import com.tsys.retail.repository.LineItemRepository;
import com.tsys.retail.repository.ProductRepository;

@Service
public class ProductService {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private LineItemRepository lineItemRepo;

	public Product createProduct(ProductInfo productInfo) {
		logger.info("Input recieved to create product = " + productInfo);
		verifyIfProductExists(productInfo.getBarCodeId());
		Product product = new Product();
		product.setBarCodeId(productInfo.getBarCodeId());
		product.setName(productInfo.getName());
		product.setProductCategory(productInfo.getProductCategory());
		product.setRate(productInfo.getRate());

		product = productRepo.save(product);
		logger.info("Created product with id = " + product.getId());
		return product;

	}


		


	public Iterable<Product> getAllProducts() {
		Iterable<Product> products = productRepo.findAll();
		logger.info("returning all products");
		return products;
	}

	public Product getProductById(Long id) {
		verifyProductExists(id);
		return productRepo.findById(id).get();
	}


	private void verifyIfProductExists(String barCodeId) {
		List<Product> productsByBarCodeID = productRepo.findByBarCodeId(barCodeId);
		if (null != productsByBarCodeID && !productsByBarCodeID.isEmpty()) {
			logger.info("Problem with input data: BarCode ID  " + barCodeId + " already exists in Product Master");
			throw new ApplicationException(
					"Problem with input data: BarCode ID  " + barCodeId + " already exists in Product Master");
		}
	}

	private void verifyProductExists(Long id) {
		logger.info("Verifying if the product exists with an id = " + id);
		Product product = productRepo.findById(id).get();
		if (product == null) {
			throw new ApplicationException("Product with id " + id + " not found");
		}
	}

}
