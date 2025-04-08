<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
h3{
  text-align: center;
}
</style>
</head>
<body>
	<div  class="container">
		<div class="row">
			<h3>사원 목록</h3>
			<table class="table">
			<tr>
				<th>사원</th>
				<th>이름</th>
				<th>입사일</th>
				<th>직위</th>
				<th>급여</th>
			</tr>
			<tr v-for="vo in ld.emp">
				<td>{{vo.empno}}</td>
				<td>{{vo.ename}}</td>
				<td>{{vo.dbday}}</td>
				<td>{{vo.job}}</td>
				<td>{{vo.sal}}</td>
			</tr>
     </table>
    </div>
  	<div class="row">
  		<h3>부서정보</h3>
  		<table class="table">
  			<tr>
  				<th>부서번호</th>
  				<th>부서명</th>
  				<th>근무지</th>
  			</tr>
  			<tr v-for="vo in ld.dept">
  				<td>{{vo.deptno}}</td>
  				<td>{{vo.dname}}</td>
  				<td>{{vo.loc}}</td>
  			</tr>
  		</table>
  	</div>
  </div>
  <script>
  let app=Vue.createApp({
	  // Model => 데이터 관리
	  data(){
		  return {
			  ld:{} // ld.emp, ld.dept
		  }
	  },
	  // ViewModel => 데이터 처리 => 서버에서 데이터 읽기, 사용자 이벤트 처리
	  // DAO
	  mounted(){
		  // => main메서드 => 서버에서 데이터 읽기
		  axios.get('http://localhost:8080/web/emp/list_vue.do')
		  .then(response=>{
			  console.log(response)
			  this.ld=response.data
			  // 실행된 데이터 읽기 => then
			  /*
			  		axios.get (post) : 요청
			  		then : 응답
			  */
		  })
	  }
  }).mount(".container")
  </script>

</body>
</html>