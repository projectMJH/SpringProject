package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.dao.*;
@Aspect // �޸� �Ҵ��� �� �� ����
@Component
public class EmpAspect {
	@Autowired
	private EmpDAO dao;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void before()
	{
		dao.getConnection();
	}
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void after()
	{
		dao.disConnection();
	}
	@Around("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("����ڰ� ȣ���� �޼��� : "+jp.getSignature().getName());
		Object obj=null;
		long start=System.currentTimeMillis();
		obj=jp.proceed();	// invoke()
		long end=System.currentTimeMillis();
		System.out.println("���� �ð� Ȯ�� : "+(end-start));
		return obj;
	}
	  @AfterReturning(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",returning = "obj")
	  public void afterReturning(Object obj)
	  {
	  	System.out.println("===== ����� �ڵ� ó�� =====");
	  	// => ���������� �ʿ��� request�� ���� => Ǫ�� 
	  	List<EmpVO> list=(List<EmpVO>)obj;
	  	for(EmpVO vo:list)
	  	{
	  		System.out.println(vo.getEmpno()+" "
	  				+vo.getEname()+" "
	  				+vo.getDbday()+" "
	  				+vo.getJob()+" "
	  				+vo.getSal());
	  	}
	  }
	  @AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp*(..))",throwing = "ex")
	  public void afterThrowing(Throwable ex)
	  {
	  	System.out.println("======= ���� �߻� ======");
	  	ex.printStackTrace();
	  	// ���� ���� ó�� 
	  	// => @ControllerAdvice
	  }
}
