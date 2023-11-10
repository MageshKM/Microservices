package com.mk.shopping.Exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InputException.class)
	public ResponseEntity<Object> handleInputException(InputException inputExcept, WebRequest wq) {
		HashMap<String, String> errorContent = new HashMap<String, String>();
		errorContent.put("error", "incorrect input");
		errorContent.put("reason", "PAGE_NOT_FOUND_LOG_CATEGORY");

		return new ResponseEntity<Object>(errorContent, HttpStatus.NOT_FOUND);
	}

}
