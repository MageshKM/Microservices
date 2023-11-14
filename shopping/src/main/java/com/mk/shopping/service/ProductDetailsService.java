package com.mk.shopping.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.mk.shopping.model.Product;
import com.mk.shopping.model.SupplierContact;

@Component
public class ProductDetailsService {

	public List<Product> getList() {

		List<String> productName = Arrays.asList("Saree", "Soft Silk", "Kanchivaram Silk","Salem Sarees");
		List<Product> listProduct = Stream.iterate(0, (c -> c + 1)).limit(4)
				.map(c -> new Product(c, productName.get(c), "SDS" + c,
						new SupplierContact("User" + c, "999956111" + c, "Address" + c), true))
				.collect(Collectors.toList());
		return listProduct;

	}
	public List<Product> getList(Integer id) {

		List<String> productName = Arrays.asList("Saree", "Soft Silk", "Kanchivaram Silk","Salem Sarees");
		List<Product> listProduct = Stream.iterate(0, (c -> c + 1)).limit(4)
				.map(c -> new Product(c, productName.get(c), "SDS" + c,
						new SupplierContact("User" + c, "999956111" + c, "Address" + c), true)).filter(c -> c.getProductId() == id)
				.collect(Collectors.toList());
		return listProduct;

	}

}
