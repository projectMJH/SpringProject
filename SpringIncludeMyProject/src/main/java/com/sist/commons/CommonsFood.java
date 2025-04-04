package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsFood {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex)
	{
		System.out.println("= SpringIncludeMyProject ============== 오류 발생 =================");
		ex.printStackTrace();
	}
}
