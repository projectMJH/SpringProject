package com.sist.spring2;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello = new HelloImpl();
		String msg=hello.sayHello2("��û��");
		System.out.println(msg);
	}

}
