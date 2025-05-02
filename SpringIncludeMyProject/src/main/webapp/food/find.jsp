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
	  <form method="post" action="../food/find.do">
		<input type="text" class="input-sm" size=15 name="fd" value="${fd }">
		<input type="submit" value="검색" class="btn-sm btn-primary">
	  </form>	
	</div>
    <div style="height: 10px"></div>
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
        <li><a href="../food/find.do?page=${startPage-1 }&fd=${fd }">&laquo;</a></li>
       </c:if>
       
       <c:forEach var="i" begin="${startPage }" 
                     end="${endPage }">
        <li ${i==curpage?"class=active":"" }><a href="../food/find.do?page=${i }&fd=${fd }">${i }</a></li>
        
       </c:forEach>
       
       <c:if test="${endPage<totalpage }"> 
        <li><a href="../food/find.do?page=${endPage+1 }&fd=${fd }">&raquo;</a></li>
       </c:if>
      </ul>
    </div>
</body>
</html>