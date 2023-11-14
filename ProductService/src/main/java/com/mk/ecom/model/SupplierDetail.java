package com.mk.ecom.model;

import java.math.BigInteger;

import jakarta.annotation.Generated;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Supplier_Detail")
public class SupplierDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger supplier_id;

	@Column
	String supplier_name;

	@Column 
	String supplier_address;

	@Column 
	String supplier_city;

	@Column 
	String supplier_state;

	@Column 
	String supplier_zipcode;

	@Column 
	int supplier_contact;

	public BigInteger getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(BigInteger supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

	public String getSupplier_city() {
		return supplier_city;
	}

	public void setSupplier_city(String supplier_city) {
		this.supplier_city = supplier_city;
	}

	public String getSupplier_state() {
		return supplier_state;
	}

	public void setSupplier_state(String supplier_state) {
		this.supplier_state = supplier_state;
	}

	public String getSupplier_zipcode() {
		return supplier_zipcode;
	}

	public void setSupplier_zipcode(String supplier_zipcode) {
		this.supplier_zipcode = supplier_zipcode;
	}

	public int getSupplier_contact() {
		return supplier_contact;
	}

	public void setSupplier_contact(int supplier_contact) {
		this.supplier_contact = supplier_contact;
	}

}
