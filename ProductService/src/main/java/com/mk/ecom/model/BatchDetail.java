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
@Table(name = "Batch_Detail")
public class BatchDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger batch_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
	SupplierDetail supplier_id;
	
	@Column
	int quanity;
	
	@Column
	int rate;
	
	@Column
	String payment_status;
 

	public SupplierDetail getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(SupplierDetail supplier_id) {
		this.supplier_id = supplier_id;
	}

	public BigInteger getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(BigInteger batch_id) {
		this.batch_id = batch_id;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

}
