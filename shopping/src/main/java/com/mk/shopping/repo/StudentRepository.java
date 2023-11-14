package com.mk.shopping.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mk.shopping.model.Student;
import com.mk.shopping.service.ProductDetailsService;
 
public interface StudentRepository extends CrudRepository<Student, Integer> {
}