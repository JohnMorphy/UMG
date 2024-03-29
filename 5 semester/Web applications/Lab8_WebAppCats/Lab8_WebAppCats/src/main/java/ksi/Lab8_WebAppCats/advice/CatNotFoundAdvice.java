package ksi.Lab8_WebAppCats.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ksi.Lab8_WebAppCats.exceptions.CatNotFoundException;

@ControllerAdvice
public class CatNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(CatNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler (CatNotFoundException ex) {
		return ex.getMessage();
	}
	
}
