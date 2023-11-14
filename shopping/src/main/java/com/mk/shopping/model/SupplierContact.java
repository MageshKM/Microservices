package com.mk.shopping.model;

public class SupplierContact {

	String name;
	String contactnumber;
	String address;

	public SupplierContact(String name, String contactnumber, String address) {
		super();
		this.name = name;
		this.contactnumber = contactnumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
