<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p{
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div>
     <c:forEach var="vo" items="${list }">
       <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="../food/detail.do?fno=${vo.fno }">
	        <img src="https://www.menupan.com${vo.poster}" style="width:230px;height: 200px">
	      </a>
	        <div class="caption">
	          <p>${vo.name }</p>
	        </div>
	    </div>
	  </div>
     </c:forEach>
	</div>
    <div style="height: 10px"></div>
    <div class="text-center">
      <ul class="pagination">
       <c:if test="${startPage>1 }">
        <li><a href="../main/main.do?page=${startPage-1 }">&laquo;</a></li>
       </c:if>
       
       <c:forEach var="i" begin="${startPage }" 
                     end="${endPage }">
        <li ${i==curpage?"class=active":"" }><a href="../main/main.do?page=${i }">${i }</a></li>
        
       </c:forEach>
       
       <c:if test="${endPage<totalpage }"> 
        <li><a href="../main/main.do?page=${endPage+1 }">&raquo;</a></li>
       </c:if>
      </ul>
    </div>

</body>
</html>