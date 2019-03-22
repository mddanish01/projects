package com.tsys.retail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tsys.retail.entity.Bill;
import com.tsys.retail.service.BillService;
import com.tsys.retail.util.BillStatus;

@RestController
public class BillController {
	@Autowired
	private BillService billService;

	final Logger logger = LoggerFactory.getLogger(BillController.class);

	@RequestMapping(value = "/bills", method = RequestMethod.POST)
	public ResponseEntity<Bill> createBill() {
		logger.info("Request recieved to create Bill = ");
		Bill bill = billService.createBill(new Bill(0.0, 0, BillStatus.IN_PROGRESS));
		logger.info("Created Bill with id = " + bill.getId());
		return new ResponseEntity<>(bill, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Bill>> getAllBills() {
		return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
	}

	@RequestMapping(value = "/bills/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
		return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
	}


}
