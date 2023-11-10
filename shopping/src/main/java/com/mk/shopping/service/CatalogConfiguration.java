package com.mk.shopping.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mk.shopping.model.PrototypeServiceBean;
import com.mk.shopping.model.SingletonServiceBean;

@Configuration 
public class CatalogConfiguration{
	
	@Bean
	@Scope(value = "prototype")
	public PrototypeServiceBean getBeanPrototypeScope() {
		return new PrototypeServiceBean();
	}
	
	@Bean
	@Scope(value = "singleton")
	public SingletonServiceBean getBeanSingleScope() {
		return new SingletonServiceBean();
	}
	
	

}
