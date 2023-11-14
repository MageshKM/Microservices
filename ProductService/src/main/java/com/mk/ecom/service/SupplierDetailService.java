package com.mk.ecom.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mk.ecom.model.SupplierDetail;
import com.mk.ecom.repo.SupplierDetailRepo;

@Service
public class SupplierDetailService {

	@Autowired
	SupplierDetailRepo supplierDetailRepo;

	public List<SupplierDetail> fetchProdcts() {
		List<SupplierDetail> supplierList = new ArrayList<SupplierDetail>();
		supplierDetailRepo.findAll().forEach(supplier -> supplierList.add(supplier));
		return supplierList;
	}

	public SupplierDetail findById(int id) {
		return supplierDetailRepo.findById(id).get();
	}

	public BigInteger saveToDB(SupplierDetail product) {
		return supplierDetailRepo.save(product).getSupplier_id();
	}

	public void deleteProduct(int id) {
		supplierDetailRepo.deleteById(id);

	}
}
