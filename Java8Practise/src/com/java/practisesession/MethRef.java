package com.java.practisesession;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface Printer
{
	String print(String str);
}

class PrinterImpl
{
	public void callPrint(String str,Printer p)
	{
		String val = p.print(str);		
		System.out.println("val:"+val);
	}
}
public class MethRef {
	public static void main(String args[])
	{
		List<String> list = Arrays.asList("Magesh","kumar","KAMER","Muniyappa","Apple");
		
		Collections.sort(list, String::compareToIgnoreCase);
		
		list.forEach(System.out::println);
		
		
		String str1 = "JAVA";
		String str2 = "java";
		
		System.out.println("CompareIgnoreCase--"+str1.compareToIgnoreCase(str2));
		
	}

}
