package com.sist.commons;

import org.springframework.web.bind.annotation.*;
// 공통 예외처리
@ControllerAdvice
public class ControllerExecution {
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception ex)
	{
		System.out.println("*** Controller 오류 발생");
		ex.printStackTrace();
	}
}
