package com.sist.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 * 		POJO����� �ַ� ���
 * 		---- �Ϲ��ڹ� => �������̽�/����� ���� ������ Ŭ����
 */
@Component
public class MainClass {
	// �ǹ� => @Autowired+@Qualifier = @Resource
	@Autowired
	// �ݵ�� ���������� �޸𸮰� �Ҵ��� �Ǵ� ��쿡�� ����� ����
	@Qualifier(value="mySQL")
	// ���� ������ Ŭ������ �������� ��쿡 Ư�� ��ü�� ����
	private DAO dao;
	// DAO dao=new Oracle() / dao=new MySQL()
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		//MainClass mc=new MainClass(); => ���� �߻� (���������� �����ϴ� ��ü�� �ƴϴ�)
		mc.dao.connection();
	}

}
