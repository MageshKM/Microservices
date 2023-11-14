package com.mk.ecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.ecom.model.BatchDetail;
import com.mk.ecom.model.ProductDetail;
import com.mk.ecom.repo.BatchDetailRepo;

@Service
public class BatchDetailService {
	
	@Autowired
	BatchDetailRepo batchDetailRepo;
	
	public List<BatchDetail> fetchBatchDetails() {
		List<BatchDetail> batchdetaillist = new ArrayList<BatchDetail>();
		batchDetailRepo.findAll().forEach(product -> batchdetaillist.add(product));
		return batchdetaillist;
	}

	public void deleteProduct(Integer id) {
		batchDetailRepo.deleteById(id);
	}

	public Optional<BatchDetail> findbyId(Integer id) {
		// TODO Auto-generated method stub
		return batchDetailRepo.findById(id);
	}

}
