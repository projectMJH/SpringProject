package com.sist.spring1;
/*
 * 		HelloMains �� Hello�� �����Ѵ� => ���ռ��� ���� ���α׷�
 * 									   ----------------
 * 									   | ���������� ��ƴ�
 * 									   | ���� �ÿ� �ٸ� Ŭ������ ������ ���� ���
 * 		�������̸� => new�� ������� �ʴ´�
 * 				  ---- ���ռ��� ���� ���α׷�
 */
public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello();
		String msg=hello.sayHello("ȫ�浿");
		System.out.println(msg);
	}

}
