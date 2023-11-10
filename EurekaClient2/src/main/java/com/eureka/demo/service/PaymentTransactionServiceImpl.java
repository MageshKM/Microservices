package com.eureka.demo.service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.eureka.demo.config.Employee;
import com.eureka.demo.config.EmployeeCallable;

@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

	//@Value(value = "${spring.kafka.group-id}")
	private String groupId="foo";

	@Override
	@Async(value = "AyncCom")
	public void customerBills() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Customer Bill Processed");
	}

	@Override
	@Async(value = "AyncCom")
	public Future<Employee> getPaidAmount() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		return executor.submit(new EmployeeCallable());

	}

	@KafkaListener(topics = "customer-topic", groupId = "foo")
	public void consume(String message) throws IOException {
		System.out.println(String.format("#### -> Consumed message -> %s", message));
	}

}
