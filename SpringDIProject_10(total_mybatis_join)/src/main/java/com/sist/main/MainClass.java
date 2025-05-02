package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.DatabaseConfig;
import com.sist.config.EmpConfig;
import com.sist.service.*;
import com.sist.vo.*;
@Component
public class MainClass {
	@Autowired
	private EmpDeptService service;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// XML => ���� => ����
		//ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		Class[] cls= {EmpConfig.class,DatabaseConfig.class};
		AnnotationConfigApplicationContext app=
											new AnnotationConfigApplicationContext(cls);
		
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<EmpVO> eList=mc.service.empListData();
		System.out.println("=========== ��� ��� ============");
		for(EmpVO vo : eList)
		{
			System.out.println(vo.getEmpno()+" "
							+vo.getEname()+" "
							+vo.getJob()+" "
							+vo.getDbday()+" "
							+vo.getSal());
		}
		System.out.println("=========== �μ� ���� =========");
		List<DeptVO> dList=mc.service.deptListData();
		for(DeptVO vo:dList)
		{
			System.out.println(vo.getDeptno()+" "
					+vo.getDname()+" "
					+vo.getLoc());
		}
		System.out.println("=========== Join Data =======");
		List<EmpVO> jList=mc.service.empJoinData();
		for(EmpVO vo:jList)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDvo().getDname()+" "
					+vo.getDvo().getLoc()+" "
					+vo.getSal());
		}
		System.out.println("======== ��� ���� ���� ========");
		Scanner scan=new Scanner(System.in);
		System.out.print("��� �Է�:");
		int empno=scan.nextInt();
		EmpVO vo=mc.service.empDetailData(empno);
		System.out.println("���:"+vo.getEmpno());
		System.out.println("�̸�:"+vo.getEname());
		System.out.println("����:"+vo.getJob());
		
		

	}

}
