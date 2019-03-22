package com.tsys.retail.integration.test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tsys.retail.entity.Product;
import com.tsys.retail.model.ProductInfo;
import com.tsys.retail.service.ProductService;
import com.tsys.retail.util.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testProductCreate(){
		Product p1 = productService.createProduct(new ProductInfo("abc-0007", 20.0, "product7", ProductCategory.A));
		Product p2 = productService.getProductById(p1.getId());
		assertThat(p1.getId()).isEqualTo(p2.getId());
	}


}
