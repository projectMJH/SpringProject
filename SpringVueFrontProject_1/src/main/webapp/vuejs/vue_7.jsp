<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		MVC
		사용자 (변경 요청)
			|
		Controller (DispatcherServlet)	
			|
		사용자 요청에 따라 변경
			(Model => @Controller, @RestController)	
			|
		Controller	
			|
		   JSP
		   
		MVVM => react
		사용자 (변경 요청)   
			|
		   View (HTML)	
			|
		사용자 요청에 따라 변경	
			|
		ViewModel : 변수값 변경	 => methods, mounted
			|
		  Model : 변경된 데이터를 View(HTML)	
			|
		   View	
		   
		=> Spring / Vue|React / MyBatis
		   ------   ---------   -------   
		   Java		JavaScript	Oracle
		
		=> 1. 순서
			Back-End
			pom.xml : 라이브러리 추가
			버전 변경 : 스프링 5 => 1.8이상
			web.xml : 서블릿 등록 (DispatcherServlet, 한글변환)
			-------------   
			
			=> model / vo / dao / service / mapper
			=> application-context.xml
			=> application-datasource.xml
			---------------------------------------------- 요구사항 (입문)
			=> application-security.xml
			=> application-websocket.xml
			
		react => webstorm : 자동 완성기	 => devops
		 => git actions	
		 =>	git actions+docker
		 =>	git actions+젠킨스
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js" ></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"	></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	width: 960px;
	margin: 0px auto;
}
</style>
</head>
<body>

</body>
</html>