package com.mk.shopping.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mk.shopping.config.CatalogConfig;
import com.mk.shopping.model.ListComp;

@RestController
@RequestMapping("/scope")
public class CatalogScopeController {

	@Autowired
	CatalogConfig catalogConfig;

	@RequestMapping(value ="/v1/prototype", method = RequestMethod.GET)
	public ResponseEntity<Object> getType()
	{
		ListComp freshList  = catalogConfig.getList2();
		freshList.add("Test");
		return new ResponseEntity<Object>( freshList.getListInstance(),HttpStatus.OK);
	}

}
