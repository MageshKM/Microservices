package com.eureka.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.demo.config.Employee;
import com.eureka.demo.service.PaymentTransactionService;

@RestController
@RequestMapping("/payment")
@EnableAsync
public class AppOneController {

	@Autowired
	private PaymentTransactionService paymentTransactionService;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/data")
	public String getStatus() throws InterruptedException, ExecutionException {
		paymentTransactionService.customerBills();
		Future<Employee> futureEmp = paymentTransactionService.getPaidAmount();
		return futureEmp.get().toString();
	}

	@PostMapping("/send")
	public String sendMsg(@RequestBody String message) {
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("customer-topic", message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}
		});
		return "Message Sent!!";
	}

}
