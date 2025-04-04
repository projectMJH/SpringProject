package com.sist.main;
// Proxy => 대리자 => AOP
/*
 * 		프로그램 => 핵심 코드
 * 				 -------
 * 				 부가적인 코드 => 모아서 관리 => 공통모듈 / AOP
 * 					| 데이터베이스 연결 / 데이터베이스 해제
 * 					| 보안 (인가 => 인증)
 * 					| 트랜젝션 => commit / rollback
 * 					| 로깅
 * 					----------------------------- AOP 라이브러리
 * 					| 사용자 정의 AOP(한두번)
 * 					----------------------------- 
 * 
 * 		중복 제거 => 메서드화 처리
 * 		------------------- CallBack
 * 		AOP의 개념
 * 		1. Aspect : 공통으로 적용되는 기능을 모아둔 장소 => 공통 모듈
 * 		2. Target : 적용하는 곳 => 모아주는 역할 (위빙)
 * 		3. Advice : 어디에 어떤 기능을 추가할 지
 * 				    JoinPoint + PointCut
 * 		4. JoinPoint : 시점 => 어디서 호출
 * 					   Before
 * 					   After
 * 					   After-Returning
 * 					   After-Throwing
 * 					   Around
 * 					   
 * 					   public void display()
 * 					   {
 * 							=> try 진입전 => Before
 * 							try
 * 							{		
 * 					   			------------ Arround start
 * 								=> 로깅
 * 								=> 어떤 메서드 요청
 * 								=> setAutoCommit(false)
 * 
 * 					   			핵심 코드 => 메서드 호출
 * 					   			------------ Around end
 * 					   			=> 걸린 시간 확인
 * 					   			=> commit
 * 					   		} catch(Exception ex) 
 * 					   		{
 * 					   			After-Throwing => 오류발생시 처리
 * 							}
 * 							finally
 * 							{
 * 								=> 무조건 수행 : After
 * 							}
 * 							return => After-Returning 정상 수행시
 * 		5. PointCut : 어떤 메서드 => execution("리턴형 패키지.클래스명.메서드명(..)")
 * 											  *						----
 * 											  					| 매개변수가 0개 이상
 * 			=> 메서드에 공통 적용하는 소스를 모아둔다	: Aspect
 * 			-------------------------------------------------
 * 			=> 메서드가 호출될때			==> PointCut
 * 			=> 메서드 어떤 위치에 적용할 지를 설정	==> JoinPoint
 * 			------------------------------------------------- Advice
 * 								---------- Weaving
 * 			=> include와 동일 : 실행 시마다 자동 호출
 * 			   ------- 공통 적용
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
