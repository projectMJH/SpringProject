package com.sist.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 		���������� XML�� �о 
 * 			1) �޸� �Ҵ�
 * 			2) Map�� ����
 * 			3) ���
 * 			4) ��ü �Ҹ�
 * 			
 * 			�����̳� => ��ü�� ���� �ֱ� ����
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		Sawon sa=(Sawon)app.getBean("sawon");
		// ����� (����) Ŭ���� ã�� => DL => getBean()
		sa.display();
	}

}
