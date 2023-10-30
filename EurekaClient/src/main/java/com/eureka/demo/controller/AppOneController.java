package com.eureka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/customer")
public class AppOneController {
	
	@Autowired
	LoadBalancerClient  loadBalancerClient;
	 
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/data")
	@CircuitBreaker(name="circuitbreaker", fallbackMethod="getFallBack")
	public String getStatus()
	{
		return "Customer Service";
	}

	public String  getAPIFallBack(String topicPage, Exception e){
	   System.out.println("getAPIFallBack::{}" + e);
	    return "";
	}
	
	@GetMapping("/getData")
	public String getResponse() { 
		ServiceInstance serviceInstance = loadBalancerClient.choose("client-service2");
		
		String uri = serviceInstance.getUri()+"/view/data";
		String response = restTemplate.getForObject(uri,String.class);
		return response;
	}
}
