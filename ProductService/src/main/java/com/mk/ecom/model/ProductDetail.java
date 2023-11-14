package com.mk.ecom.model;

import java.math.BigInteger;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_Detail")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger product_id;
	
	@Column
	String product_name; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
	BatchDetail batch_id;

	public BigInteger getProduct_id() {
		return product_id;
	}

	public void setProduct_id(BigInteger product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public BatchDetail getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(BatchDetail batch_id) {
		this.batch_id = batch_id;
	}

}
