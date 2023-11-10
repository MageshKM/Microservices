package com.mk.shopping.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import com.mk.shopping.model.ListComp;

@Configuration
public class CatalogConfig {
	
	@Bean
	@RequestScope
	public List<String> mimeTypes() {
	    return new ArrayList<String>(); //Arrays.<String>asList("text/html", "application/json");
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ListComp getList(){
		return new ListComp();
	}
	
	@Bean
	@Scope("request")
	//@RequestScope
	//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ListComp getList2() {
		return new ListComp();
	}

}
