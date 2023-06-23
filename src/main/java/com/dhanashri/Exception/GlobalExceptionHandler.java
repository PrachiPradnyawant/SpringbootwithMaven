package com.dhanashri.Exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String,String> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		HashMap<String,String> hashMap=new HashMap<>();
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> errors = bindingResult.getFieldErrors();
		for (FieldError fieldError : errors) {
			hashMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		} 
		return hashMap;
	}
	@ExceptionHandler(ProductAlreadyExistisException.class)
	public ResponseEntity<String> productAlreadyExistisException(ProductAlreadyExistisException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
		
	}
}
