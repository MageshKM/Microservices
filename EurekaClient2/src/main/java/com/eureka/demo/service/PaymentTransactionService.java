package com.eureka.demo.service;

import java.util.concurrent.Future;

import com.eureka.demo.config.Employee;

public interface PaymentTransactionService {
	
	void customerBills();
	Future<Employee> getPaidAmount();
	 

}
