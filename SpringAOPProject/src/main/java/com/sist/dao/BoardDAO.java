package com.sist.dao;
/*
 * 		���ռ��� ���� ���α׷� => �������� �����ڰ� ���� ����
 * 		--------------- Container / POJO / DI
 * 											| Ŭ���� �޸� �Ҵ�� 
 * 											  �ʿ��� ��쿡 ��� ���� �ʱ�ȭ
 * 									| �ٸ� Ŭ������ ������ ���� ���� Ŭ����
 * 									  => �������̽� / ����� ������� �ʴ� Ŭ����
 * 							| Ŭ������ ������ ��Ƽ� ����
 * 		=> ���� �ҽ��� ���� �߻� => �������� ���Ǵ� �ҽ��� ��Ƽ� ����
 * 							  ==========================
 * 								| ������ => AOP (Ⱦ������ ���α׷�)
 * 								  => �ݺ� �ڵ��� ���� �ʴ´�
 * 								| OOP VS AOP
 * 								  => AOP�� OOP�� ������ ����
 * 								  => CallBack => �ڵ� ȣ��
 * 								  => � �޼�������
 * 								  => ��� ����
 * 		try
 * 		{
 * 			getConnection() ==> BEFORE
 * 			..
 * 			..
 * 			..
 * 		}catch(Exception ex)
 * 		{
 * 			ex.printStackTrace()
 * 		}
 *		finally 
 * 		{
 * 			disConnection() ==> AFTER
 * 		}
 * 
 * 		@== Before
 * 		try
 * 		{
 * 			------------------ Around setAutoCommit(false)
 * 			...
 * 			...
 * 			------------------ commit() => Ʈ����� / �α�����
 * 		}catch(Exception ex)			   -------------- ���������� ���̺귯�� ó��	
 * 		{
 * 			@==	After-Throwing
 * 		}
 *		finally 
 * 		{
 * 			@==	After
 * 		}
 * 		return ... @== After-Returning
 * 
 * 		�⺻
 * 		=> �ڵ� �ҽ�
 * 		   -------
 * 			���� ���Ǵ� �ҽ�
 * 			�ٽ� ���Ǵ� �ҽ� ***
 * 								  =>
 * 								  =>
 * 								  =>
 * 								|
 * 								|
 * 								|
 */
public class BoardDAO {
	public void getConnection()
	{
		System.out.println("����Ŭ ����!!");
	}
	public void disConnection()
	{
		System.out.println("����Ŭ �ݱ�!!");
	}
	public void boardListData(int page)
	{
//		getConnection();
		System.out.println(page+"������ ��� ���");
//		disConnection();
	}
	/*
	 * 	public void display()
	 *  {
	 *  	=> Before
	 *  	try
	 *  	{
	 *  	}catch(Exception e)
	 *  	{
	 *  		=> After-Throwing
	 *  	}
	 *  	finally
	 *  	{
	 *  		=> After
	 *  	}
	 *  	return; => After-Returning
	 *  }
	 *  DI / AOP => MVC (���̺귯��)
	 */
	public String boardDetailData(String name)
	{
//		getConnection();
		System.out.println(name+"�� ���� �󼼺���");
//		disConnection();
		return name;
	}
	public void boardInsert()
	{
//		getConnection();
		System.out.println("�Խù� �߰� �Ϸ�");
//		disConnection();
	}
	public void boardUpdate()
	{
//		getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
//		disConnection();
	}
	public void boardDelete()
	{
//		getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
//		disConnection();
	}
	public void print()
	{
		System.out.println("���α׷� ����");
	}

}
