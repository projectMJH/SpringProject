package com.sist.main;

public class MyTarget {
	private My my;
	public MyTarget(My my)
	{
		this.my=my;
	}
	public void execute()
	{
		// Target�� ��Ƽ� ó�� => ���� (�������� �޼��带 ��Ƽ� ó��)
		System.out.println("my������");	// Before
		my.execute();
		System.out.println("my������");	// After
	}
}
