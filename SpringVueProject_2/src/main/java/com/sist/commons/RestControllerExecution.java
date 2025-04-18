package com.sist.commons;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class RestControllerExecution {
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception ex)
	{
		System.out.println("*** RestController 오류 발생");
		ex.printStackTrace();
	}
}
