package com.mk.ecom.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.ecom.model.ProductDetail;
import com.mk.ecom.model.SupplierDetail;
import com.mk.ecom.service.BatchDetailService;
import com.mk.ecom.service.ProductDetailService;
import com.mk.ecom.service.SupplierDetailService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/ecom")
public class SupplierController {

	private static Logger logger = LoggerFactory.getLogger(SupplierController.class);

	 
	@Autowired
	SupplierDetailService supplierDetailService;

	@SuppressWarnings("rawtypes")
	@GetMapping("/supplier")
	public ResponseEntity<List<SupplierDetail>> fetchProductList() {
		logger.info("Controller Class GET API Called:");
		return new ResponseEntity(supplierDetailService.fetchProdcts(), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/supplier/{id}")
	public ResponseEntity<SupplierDetail> findById(@PathVariable("id") int id) {
		logger.info("Controller Class GET API Called:");
		return new ResponseEntity(supplierDetailService.findById(id), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/supplier")
	public ResponseEntity<String> saveToDB(@RequestBody SupplierDetail product) {
		logger.info("Controller Class Save API Called: {}", product.toString());
		BigInteger id = supplierDetailService.saveToDB(product);
		return new ResponseEntity(id.toString(), HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("/supplier/{id}")
	public ResponseEntity<String> deleteFromDB(@PathVariable("id") Integer id) {
		logger.info("Controller Class DELETE API Called: {}", id);
		supplierDetailService.deleteProduct(id);
		return new ResponseEntity("DELETED", HttpStatus.OK);
	}
	
	
	
	

}
