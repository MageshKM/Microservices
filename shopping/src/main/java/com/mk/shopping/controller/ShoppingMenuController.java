package com.mk.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.shopping.model.Product;
import com.mk.shopping.service.ProductDetailsService;

@RestController
@RequestMapping("/shop")
public class ShoppingMenuController {

	@Autowired
	ProductDetailsService productDetailsService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> fetchProductList() {

		return new ResponseEntity<List<Product>>(productDetailsService.getList(), HttpStatus.OK);

	}
	@GetMapping("/products/{id}")
	public ResponseEntity<List<Product>> fetchProductList(@PathVariable("id") Integer id) {

		return new ResponseEntity<List<Product>>(productDetailsService.getList(id), HttpStatus.OK);

	}
}
