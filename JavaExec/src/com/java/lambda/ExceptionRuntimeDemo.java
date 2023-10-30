package com.java.lambda;

public class ExceptionRuntimeDemo extends RuntimeException {
	ExceptionRuntimeDemo(String errMsg, Throwable err){
		super(errMsg, err);
	}

}
