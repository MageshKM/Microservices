package com.mk.ecom.repo;

import org.springframework.data.repository.CrudRepository;

import com.mk.ecom.model.BatchDetail;
import com.mk.ecom.model.ProductDetail;

public interface BatchDetailRepo  extends CrudRepository<BatchDetail, Integer>  {

}
