package com.mk.shopping.model;

import java.util.List;

public class Product {
	
	int productId;
	String productName;
	String productCode;
	SupplierContact supplierContact;
	List<Item> itemList;
	boolean isActive;
	public Product(int productId, String productName, String productCode, SupplierContact supplierContact,
			boolean isActive) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.supplierContact = supplierContact;
		this.isActive = isActive;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public SupplierContact getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(SupplierContact supplierContact) {
		this.supplierContact = supplierContact;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
