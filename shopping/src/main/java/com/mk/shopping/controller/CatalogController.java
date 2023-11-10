package com.mk.shopping.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mk.shopping.Exception.InputException;
import com.mk.shopping.config.CatalogConfig;
import com.mk.shopping.model.CalculateComp;
import com.mk.shopping.model.ListComp;
import com.mk.shopping.service.CatalogConfiguration;
import com.mk.shopping.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	CatalogConfiguration catalogConfiguration;
	@Autowired
	CatalogService catalogService;
	@Autowired
	CalculateComp calculateComp;
	@Autowired
	ListComp getList;

	@RequestMapping("/v1/singleton")
	public ResponseEntity<String> getSingleton() {
		return new ResponseEntity<String>(
				"Singleton = " + catalogConfiguration.getBeanSingleScope().getInstancesCreated(), HttpStatus.OK);
	}

	@RequestMapping("/v1/{data}")
	public ResponseEntity<Object> getReq(@PathVariable("data") String data) {
		System.out.println("endpoint:" + data);

		if (data.equals("error"))
			throw new InputException("Error", "Reason");

		return new ResponseEntity<Object>(catalogService.getCatalog(), HttpStatus.OK);
	}

	@RequestMapping(value = "/v1/add", method = RequestMethod.POST)
	public ResponseEntity<Object> getReqPost(@RequestParam("data") String data) {
		System.out.println("endpoint:add, Param=" + data);
		return new ResponseEntity<Object>(catalogService.addCatalog(data), HttpStatus.OK);
	}

	@RequestMapping(value = "/v3/prototype", method = RequestMethod.GET)
	public ResponseEntity<Object> getReqPrototype(@RequestParam("data") String data) {
		System.out.println("endpoint:add, Param=" + data);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CatalogConfig.class);
		CatalogConfig messageService = context.getBean(CatalogConfig.class);
		ListComp list = messageService.getList2();
		list.add(data);
		return new ResponseEntity<Object>(list.getListInstance(), HttpStatus.OK);
	}

	@RequestMapping(value = "/v2/add", method = RequestMethod.POST)
	public ResponseEntity<Object> getReqDynamicList(@RequestParam("data") String data) {
		System.out.println("endpoint:add, Param=" + data);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CatalogConfig.class);
		CatalogConfig messageService = context.getBean(CatalogConfig.class);
		ListComp list = messageService.getList2();
		list.add(data);
		return new ResponseEntity<Object>(list.getListInstance(), HttpStatus.OK);
	}

	@RequestMapping(value = "/v1/calcul/{type}", method = RequestMethod.GET)
	public ResponseEntity<Object> getReqCalcul(@PathVariable("type") String type, @RequestParam("i") int i,
			@RequestParam("j") int j) {
		System.out.println("endpoint: " + type + "--" + i + ":" + j);

		if (type.equals("add"))
			return new ResponseEntity<Object>(calculateComp.add(i, j), HttpStatus.OK);
		else if (type.equals("mul"))
			return new ResponseEntity<Object>(calculateComp.mul(i, j), HttpStatus.OK);
		else if (type.equals("div"))
			return new ResponseEntity<Object>(calculateComp.div(i, j), HttpStatus.OK);
		else if (type.equals("sub"))
			return new ResponseEntity<Object>(calculateComp.sub(i, j), HttpStatus.OK);
		else
			throw new InputException("Error", "Reason");
	}

	@RequestMapping("/v1/protype")
	public ResponseEntity<String> getProtype() {
		return new ResponseEntity<String>(
				"Protype = " + catalogConfiguration.getBeanPrototypeScope().getInstancesCreated(), HttpStatus.OK);
	}

}
