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
import com.mk.ecom.service.BatchDetailService;
import com.mk.ecom.service.ProductDetailService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/ecom")
public class ProductController {

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductDetailService productDetailService;
	
	@Autowired
	BatchDetailService batchDetailService;

	@SuppressWarnings("rawtypes")
	@GetMapping("/product")
	public ResponseEntity<List<ProductDetail>> fetchProductList() {
		logger.info("Controller Class GET API Called:");
		return new ResponseEntity(productDetailService.fetchProdcts(), HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/product")
	public ResponseEntity<String> saveToDB(@RequestBody ProductDetail product) {
		logger.info("Controller Class Save API Called: {}", product.toString());
		BigInteger id = productDetailService.saveToDB(product);
		return new ResponseEntity(id.toString(), HttpStatus.OK);

	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteFromDB(@PathVariable("id") Integer id) {
		logger.info("Controller Class DELETE API Called: {}", id);
		productDetailService.deleteProduct(id);
		return new ResponseEntity("DELETED", HttpStatus.OK);
	}
	
	
	
	

}
