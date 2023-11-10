package com.java.practisesession;

public class ExceptionRuntimeDemo extends RuntimeException {
	ExceptionRuntimeDemo(String errMsg, Throwable err){
		super(errMsg, err);
	}

}
