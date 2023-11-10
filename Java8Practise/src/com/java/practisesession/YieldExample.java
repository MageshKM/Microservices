package com.java.practisesession;


public class YieldExample  extends Thread {
	
	public void run()
	{
		for(int i=1;i<=4;i++)
		{
			try {
				Thread.sleep(500);
			}catch(Exception e) {System.out.println();}
			System.out.println(i);
		}
	}
	
	public static void main(String args[]) {

		YieldExample t1= new YieldExample();
		YieldExample t2= new YieldExample();
		YieldExample t3= new YieldExample();
		
		t1.start();
		
		try {
			YieldExample.yield();
			
		}catch(Exception e) {
			System.out.println("Yield Block :"+e.getMessage());
		}
		
		t2.start();
		t3.start();
	}

}
