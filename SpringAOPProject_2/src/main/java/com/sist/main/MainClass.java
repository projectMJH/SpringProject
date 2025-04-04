package com.sist.main;
// Proxy => �븮�� => AOP
/*
 * 		���α׷� => �ٽ� �ڵ�
 * 				 -------
 * 				 �ΰ����� �ڵ� => ��Ƽ� ���� => ������ / AOP
 * 					| �����ͺ��̽� ���� / �����ͺ��̽� ����
 * 					| ���� (�ΰ� => ����)
 * 					| Ʈ������ => commit / rollback
 * 					| �α�
 * 					----------------------------- AOP ���̺귯��
 * 					| ����� ���� AOP(�ѵι�)
 * 					----------------------------- 
 * 
 * 		�ߺ� ���� => �޼���ȭ ó��
 * 		------------------- CallBack
 * 		AOP�� ����
 * 		1. Aspect : �������� ����Ǵ� ����� ��Ƶ� ��� => ���� ���
 * 		2. Target : �����ϴ� �� => ����ִ� ���� (����)
 * 		3. Advice : ��� � ����� �߰��� ��
 * 				    JoinPoint + PointCut
 * 		4. JoinPoint : ���� => ��� ȣ��
 * 					   Before
 * 					   After
 * 					   After-Returning
 * 					   After-Throwing
 * 					   Around
 * 					   
 * 					   public void display()
 * 					   {
 * 							=> try ������ => Before
 * 							try
 * 							{		
 * 					   			------------ Arround start
 * 								=> �α�
 * 								=> � �޼��� ��û
 * 								=> setAutoCommit(false)
 * 
 * 					   			�ٽ� �ڵ� => �޼��� ȣ��
 * 					   			------------ Around end
 * 					   			=> �ɸ� �ð� Ȯ��
 * 					   			=> commit
 * 					   		} catch(Exception ex) 
 * 					   		{
 * 					   			After-Throwing => �����߻��� ó��
 * 							}
 * 							finally
 * 							{
 * 								=> ������ ���� : After
 * 							}
 * 							return => After-Returning ���� �����
 * 		5. PointCut : � �޼��� => execution("������ ��Ű��.Ŭ������.�޼����(..)")
 * 											  *						----
 * 											  					| �Ű������� 0�� �̻�
 * 			=> �޼��忡 ���� �����ϴ� �ҽ��� ��Ƶд�	: Aspect
 * 			-------------------------------------------------
 * 			=> �޼��尡 ȣ��ɶ�			==> PointCut
 * 			=> �޼��� � ��ġ�� ������ ���� ����	==> JoinPoint
 * 			------------------------------------------------- Advice
 * 								---------- Weaving
 * 			=> include�� ���� : ���� �ø��� �ڵ� ȣ��
 * 			   ------- ���� ����
 * 						
 * 						
 * 						
 * 						
 * 		1.
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My m=new My();
		m.execute();
		
		MyTarget mt=new MyTarget(m);
		mt.execute();
	}

}
