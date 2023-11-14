package com.mk.ecom.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.mk.ecom.model.ProductDetail;
import com.mk.ecom.repo.ProductDetailRepo; 

@Service
public class ProductDetailService {

	@Autowired
	ProductDetailRepo productDetailRepo;

	public List<ProductDetail> fetchProdcts() {
		List<ProductDetail> productList = new ArrayList<ProductDetail>();
		productDetailRepo.findAll().forEach(product -> productList.add(product));
		return productList;
	}
	public BigInteger saveToDB(ProductDetail product) {
		return productDetailRepo.save(product).getProduct_id();
	}
	public void deleteProduct(int id) {
		 productDetailRepo.deleteById(id);
		
	}

}
