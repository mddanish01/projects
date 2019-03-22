package com.tsys.retail;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.tsys.retail.entity.Bill;
import com.tsys.retail.model.BillUpdateInfo;
import com.tsys.retail.model.ProductInfo;
import com.tsys.retail.model.ProductInfoForBill;
import com.tsys.retail.service.BillService;
import com.tsys.retail.service.ProductService;
import com.tsys.retail.util.BillStatus;
import com.tsys.retail.util.ProductCategory;

@Component
public class SampleDataSetupRunner implements CommandLineRunner {

	@Autowired
	private BillService billService;

    final Logger logger = LoggerFactory.getLogger(SampleDataSetupRunner.class);

	@Autowired
	private ProductService productService;

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("setting Runner..");
		setUpProductData();
		setupBillData();
		logger.info("Exiting Runner.. ");
	}

	public void setupBillData() {

		// create a new Bill to update information.
		Bill o1 = billService.createBill(new Bill(0.0, 0, BillStatus.IN_PROGRESS));

		Long billId = o1.getId();
		BillUpdateInfo billUpdateInfo = new BillUpdateInfo();
		List<ProductInfoForBill> productsToBeAdded = new ArrayList<>();

		productsToBeAdded.add(new ProductInfoForBill("abc-0001", 2));
		productsToBeAdded.add(new ProductInfoForBill("abc-0002", 1));
		productsToBeAdded.add(new ProductInfoForBill("abc-0003", 2));
		productsToBeAdded.add(new ProductInfoForBill("abc-0004", 3));
		productsToBeAdded.add(new ProductInfoForBill("abc-0005", 2));
		billUpdateInfo.setProductsToBeAdded(productsToBeAdded);
		billUpdateInfo.setStatus(BillStatus.RELEASED);

		logger.info("billUpdateInfo = " + billUpdateInfo);
		billService.updateBill(billUpdateInfo, billId);
		Bill retrieveUpdatedbill = billService.getBillById(o1.getId());
		logger.info("retrieveUpdatedbill = " + retrieveUpdatedbill.getNoOfItems() + "  value ="
				+ retrieveUpdatedbill.getTotalValue());

	}

	private void setUpProductData() {
		productService.createProduct(new ProductInfo("abc-0001", 20.0, "product1", ProductCategory.A));
		productService.createProduct(new ProductInfo("abc-0002", 30.0, "product2", ProductCategory.B));
		productService.createProduct(new ProductInfo("abc-0003", 40.0, "product3", ProductCategory.C));
		productService.createProduct(new ProductInfo("abc-0004", 50.0, "product4", ProductCategory.A));
		productService.createProduct(new ProductInfo("abc-0005", 60.0, "product5", ProductCategory.B));
	}
}
