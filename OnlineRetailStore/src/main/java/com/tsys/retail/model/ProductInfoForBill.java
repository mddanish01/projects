package com.tsys.retail.model;

import javax.validation.constraints.NotNull;


public class ProductInfoForBill {

	@NotNull
	private String barCodeId;

	private int quantity;

	public ProductInfoForBill() {
		super();
	}
	public ProductInfoForBill(String barCodeId, int quantity) {
		super();
		this.barCodeId = barCodeId;
		this.quantity = quantity;
	}

	public String getBarCodeId() {
		return barCodeId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setBarCodeId(String barCodeId) {
		this.barCodeId = barCodeId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
