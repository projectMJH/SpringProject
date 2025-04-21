package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
/*
 * 	스프링 메모리 할당
 *  => 패키지 단위
 *  	<context:component-scan basepackage="com.sist.*"/> 
 * 		=> 선택적으로 메모리 할당
 * 		=> 어노테이션
 * 	 	@Component : 일반 객체
 * 					 ~Manager
 * 		@Repository : ~DAO (저장소)
 *  	@Service : ~Service = 의존성을 낮게
 * 				   DAO 여러개를 묶어서 사용
 *  	@Controller : Model => 화면 변경
 * 	 	@RestController : Model => RestFul
 * 						  자바스크립트 / 코틀린 / 장고
 * 	 	@ControllerAdvice : 공통 예외처리 => Controller
 *  	@RestControllerAdvice : 공통 예외처리 => RestController
 * 
 * 		@Bean	
 */
// model == service === dao == 오라클 연동
public class BusanInfoDAO {
	@Autowired
	// 스프링에서 메모리 할당을 한 클래스의 주소를 받는 경우 => 클래스 객체 주소
	private BusanInfoMapper mapper;
	
	// 구현
	/*
	 * 		MyBatis : XML, Annotation
	 * 				  => XML + Annotation
	 * 						   ========== 간단한 SQL
	 *  				 === 동적 쿼리 / SQL 문장이 긴 경우
	 *  			  => <select> @Select()
	 *  			  => id 	resultType parameterType
	 *  			  	  |			|			|
	 *  			   메서드명	  리턴형		  매개변수
	 *  						  =====
	 *  						  VO / List
	 *  						  |		|
	 *  							 selectList
	 *  						selectOne	
	 *  			  => getConnection / disConnection 처리
	 *  	=> ORM => 관계형 데이터베이스에 대한 라이브러리 (데이터베이스)
	 *  		| MyBatis (IBatis)
	 *  		| JPA (Hibernate) => DataSet => LinQ
	 */
	public List<BusanInfoVO> busanInfoListData(Map map)
	{
		return mapper.busanInfoListData(map);
	}
	public int busanInfoTotalPage(int cno)
	{
		return mapper.busanInfoTotalPage(cno);
	}
	
	public BusanInfoVO busanInfoDetailData(int no)
	{
		return mapper.busanInfoDetailData(no);
	}
	
	
}
