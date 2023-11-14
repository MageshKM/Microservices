package com.mk.ecom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.ecom.model.BatchDetail;
import com.mk.ecom.model.ProductDetail;
import com.mk.ecom.service.BatchDetailService;

@RestController
@RequestMapping("/v1/ecom")
public class BatchController {
	private static Logger logger = LoggerFactory.getLogger(BatchController.class);
	@Autowired
	BatchDetailService batchDetailService;

	@SuppressWarnings("rawtypes")
	@GetMapping("/batch")
	public ResponseEntity<List<BatchDetail>> fetchBatchList() {
		logger.info("Controller Class GET API Called:");
		return new ResponseEntity(batchDetailService.fetchBatchDetails(), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/batch/{id}")
	public ResponseEntity<BatchDetail> findBatchDetail(@PathVariable("id") Integer id) {
		logger.info("Controller Class DELETE API Called: {}", id);
		BatchDetail batchObj = batchDetailService.findbyId(id).get();
		return new ResponseEntity(batchObj, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/batch/{id}")
	public ResponseEntity<String> deleteBatchDetail(@PathVariable("id") Integer id) {
		logger.info("Controller Class DELETE API Called: {}", id);
		batchDetailService.deleteProduct(id);
		return new ResponseEntity("DELETED", HttpStatus.OK);
	}
}
