package com.sist.main;
/*
 * 		������ �����ӿ�ũ
 * 		------------
 * 		1. Container : Ŭ������ ��Ƽ� ����
 * 		   BeanFactory : core (��ü ���� / DI)
 * 				|
 * 		ApplicationContext : default core (��ü ���� / DI / AOP)
 * 				|
 * 	  WebApplicationContext : core (��ü ���� / DI / AOP / MVC)
 * 
 * 		=> GenericApplicationContext => �ݱ� (��ü �Ҹ�)
 * 		=> AnnotationConfigApplicationContext
 * 			=> 5���� �ַ� ���
 * 			   ---- ���ȿ� �ַ�
 * 				��� : XML => �����ڹ� ������ ����
 * 							------ Boot
 * 			���
 * 				= ��ü �����ֱ� ����(���� ~ �Ҹ�) => ��� Ŭ���� (VO => ��������)
 * 				= ��ü ã�� (getBean())
 * 				= DL(��ü ã��) / DI(������ �ʱ�ȭ)
 * 							   --------------
 * 								1. setter
 * 								2. constructor 
 * 								3. method ȣ���� ����
 * 			------------------------------------------------------------------
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		Sawon sa=(Sawon)app.getBean("sa1");
		sa.print();
		
		Sawon sa1=(Sawon)app.getBean("sa2");
		sa1.print();
		
		Sawon sa2=(Sawon)app.getBean("sa3");
		sa2.print();
		
		Sawon sa3=(Sawon)app.getBean("sa4");
		sa3.print();
		
		Sawon sa4=(Sawon)app.getBean("sa5");
		sa4.print();
	}

}
