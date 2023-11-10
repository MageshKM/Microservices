package com.mk.shopping.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mk.shopping.Exception.InputException;

@Service
public class CatalogService {
	
	@Autowired  
	List<String> mimeTypes;
	
	
	public List<String> getCatalog(){
		String[] geeks = {"Magesh", "Kumar",
                "Dhanvith", "Gowthami"}; 
		return Arrays.asList(geeks);
		
	}
	
	public List<String> addCatalog(String item)
	{
		mimeTypes.add(item);
		
		return mimeTypes;
	}

}
