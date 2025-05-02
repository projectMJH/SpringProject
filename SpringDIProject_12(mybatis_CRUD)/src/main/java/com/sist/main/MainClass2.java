package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.vo.*;
import com.sist.dao.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app2=new ClassPathXmlApplicationContext("app2.xml");
		StudentDAO2 dao=(StudentDAO2)app2.getBean("dao2");
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("========= �޴� ==========");
			System.out.println("1. ���");
			System.out.println("2. �󼼺���");
			System.out.println("3. �л� ���");
			System.out.println("4. �л� ����");
			System.out.println("5. �л� ����");
			System.out.println("6. ���α׷� ����");
			System.out.println("=========================");
			System.out.print("�޴� ����: ");
			int menu=scan.nextInt();
			switch (menu) 
			{
				case 6:
					System.out.println("���α׷� ����");
					System.exit(0);
				case 1:
				{
					List<StudentVO> list=dao.studentListData();
					if(list.size()==0)
					{
						System.out.println("��ϵ� �л��� �����ϴ�");
					}
					else
					{
						for(StudentVO vo:list)
						{
							System.out.println(vo.getHakbun()+" "
									+vo.getName()+" "
									+vo.getKor()+" "
									+vo.getEng()+" "
									+vo.getMath());
						}
					}
				}
				break;
				case 3:
				{
					System.out.print("�̸� �Է�: ");
					String name=scan.next();
					System.out.print("���� �Է�: ");
					int kor=scan.nextInt();
					System.out.print("���� �Է�: ");
					int eng=scan.nextInt();
					System.out.print("���� �Է�: ");
					int math=scan.nextInt();
					StudentVO vo=new StudentVO();
					vo.setName(name);
					vo.setKor(kor);
					vo.setEng(eng);
					vo.setMath(math);
					dao.studentInsert(vo);
					System.out.println("�л� ��� �Ϸ�");
				}
				break;
				case 2:
				{
					System.out.print("�󼼺��� �й� �Է�: ");
					int hakbun=scan.nextInt();
					StudentVO vo=dao.studentDetailData(hakbun);
					System.out.println("====== �л� ���� ====== ");
					System.out.println("�̸� :"+vo.getName());
					System.out.println("���� :"+vo.getKor());
					System.out.println("���� :"+vo.getEng());
					System.out.println("���� :"+vo.getMath());
				}
				break;
				case 5:
				{
					System.out.println("������ �й� ����: ");
					int hakbun=scan.nextInt();
					dao.studentDelete(hakbun);
					System.out.println("���� �Ϸ�");
				}
				break;
				case 4:
				{
					System.out.println("������ �й� ����: ");
					int hakbun=scan.nextInt();
					System.out.print("�̸� �Է�: ");
					String name=scan.next();
					System.out.print("���� �Է�: ");
					int kor=scan.nextInt();
					System.out.print("���� �Է�: ");
					int eng=scan.nextInt();
					System.out.print("���� �Է�: ");
					int math=scan.nextInt();
					StudentVO vo=new StudentVO();
					vo.setHakbun(hakbun);
					vo.setName(name);
					vo.setKor(kor);
					vo.setEng(eng);
					vo.setMath(math);
					dao.studentUpdate(vo);
					System.out.println("�л� ���� �Ϸ�");				}
				break;
			}
		}
	}

}
