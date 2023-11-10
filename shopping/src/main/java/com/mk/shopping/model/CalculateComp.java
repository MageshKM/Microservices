package com.mk.shopping.model;

import org.springframework.stereotype.Component;

@Component
public class CalculateComp {
	private int i =0;
	private int j =0;
	
	public int add(int i, int j)
	{
		return i + j;
	}
	
	public int sub(int i, int j)
	{
		return i - j;
	}
	public int mul(int i, int j)
	{
		return i * j;
	}
	public int div(int i, int j)
	{
		return i / j;
	}
	
	

}
