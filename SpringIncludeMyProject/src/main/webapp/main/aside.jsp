<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.title{
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
   display: block;
}
</style>
</head>
<body>
	<table class="table">
		<tr>
			<td class="text-center"><h3>음악 순위</h3></td>
		</tr>
	</table>
	<table class="table">
		<tr>
			<th class="text-center" width="20%">순위</th>
			<th class="text-center" width="30%"></th>
			<th class="text-center title" width="50%">음악명</th>
		</tr>
		<c:forEach var="mvo" items="${mList }">
		<tr>
			<td class="text-center" width="20%">${mvo.rank }</td>
			<td width="30%">
			 <img src="${mvo.poster }" style="width: 30px;height:30px">
			</td>
			<td class="text-center title" width="50%">${mvo.title }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>