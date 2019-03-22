package com.tsys.retail.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import com.tsys.retail.util.BillStatus;

public class BillUpdateInfo {
	private List<ProductInfoForBill> productsToBeAdded;

	@NotNull
	private BillStatus status;

	public BillUpdateInfo() {
		super();

	}

	public List<ProductInfoForBill> getProductsToBeAdded() {
		return productsToBeAdded;
	}


	public BillStatus getStatus() {
		return status;
	}

	public void setProductsToBeAdded(List<ProductInfoForBill> productsToBeAdded) {
		this.productsToBeAdded = productsToBeAdded;
	}


	public void setStatus(BillStatus status) {
		this.status = status;
	}


}
