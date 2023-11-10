package com.mk.shopping.model;

import java.util.*;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class ListComp {

	private List<String> list;

	public ListComp() {
		list = new ArrayList<String>();
	}

	public void add(String str) {
		list.add(str);
	}

	public List<String> getListInstance() {
		return list;
	}

}
