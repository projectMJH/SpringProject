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
p{
	overflow: hidden;
	white-space:nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
		  <div class="text-center">
		  	<input type="button" value="한식" class="btn-lg btn-success">
		  	<input type="button" value="중식" class="btn-lg btn-info">
		  	<input type="button" value="일식" class="btn-lg btn-warning">
		  	<input type="button" value="양식" class="btn-lg btn-danger">
		  	<input type="button" value="기타" class="btn-lg btn-danger">
		  </div>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			<h3 class="text-center">{{title}}</h3>
		</div>
		<div style="height: 10px"></div>
		<div class="row">
			
		</div>
	</div>
	<script>
	let app=Vue.createApp({
		data(){
			return {
			}
		},
		mounted(){
		},
		methods:{
			dataRecv(){
				
			}
		}
	}).mount(".container")
	</script>
</body>
</html>