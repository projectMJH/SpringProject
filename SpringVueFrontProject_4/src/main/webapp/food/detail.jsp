<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3/dist/vue.global.js" ></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"	></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	width: 800px;
	margin: 0px auto;
}
</style>
</head>
<body>
<div class="container">
  <div class="row">
    <table class="table">
     <tr>
      <td width=40% class="text-center" rowspan="8">
        <img :src="'https://www.menupan.com'+food_vo.poster"
         style="width:380px;height: 300px" class="img-rounded">
      </td>
      <td width="60%" colspan="2">
        <h3>
        <span id="food_name">{{food_vo.name}}</span>&nbsp;
        <span style="color:orange;">{{food_vo.score}}</span>
        </h3>
      </td>
     </tr>
     <tr>
       <td width=15% style="color: gray">음식종류</td>
       <td width=45%>{{food_vo.type}}</td>
     </tr>
     <tr>
       <td width=15% style="color: gray">주소</td>
       <td width=45%>{{food_vo.address}}</td>
     </tr>
     <tr>
       <td width=15% style="color: gray">전화</td>
       <td width=45%>{{food_vo.phone}}</td>
     </tr>
     <tr>
       <td width=15% style="color: gray">가격대</td>
       <td width=45%>{{food_vo.price}}</td>
     </tr>
     <tr>
       <td width=15% style="color: gray">주차</td>
       <td width=45%>{{food_vo.parking}}</td>
     </tr>
     <tr>
       <td width=15% style="color: gray">영업시간</td>
       <td width=45%>{{food_vo.time}}</td>
     </tr>
     <tr>
       <td width=15% style="color: gray">테마</td>
       <td width=45%>{{food_vo.theme}}</td>
     </tr>
    </table>
    <table class="table">
      <tr>
       <td>{{food_vo.content}}</td>
      </tr>
    </table>
	<div id="map" style="width:100%;height:350px;"></div>
  </div>  
</div>  
<script>
let foodDetailApp=Vue.createApp({
	data(){
		return {
			fno:${param.fno},
			food_vo:{}
		}
	},
	mounted(){
		axios.get("http://localhost:8080/web/food/detail_vue.do",{
			params:{
				fno:this.fno
			}
		}).then(response=>{
			console.log(response.data)
			this.food_vo=response.data
			if(window.kakao && window.kakao.maps)
			{
				this.initMap()
			}	
			else
			{
				this.addScript()
			}
			this.addScript()
		}).catch(error=>{
			console.log(error.response)
		})
	},
	methods: {
		addScript(){
			const script=document.createElement("script")
			/* global kakao */
			script.onload=()=>kakao.maps.load(this.initMap)
			script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=3b23ac7a514b4ffeb31b92fb00565fcb&libraries=services"
			document.head.appendChild(script)
		},
		initMap(){
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption); 
	
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
	
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(this.food_vo.address, function(result, status) {
	
			    // 정상적으로 검색이 완료됐으면 
			    if (status === kakao.maps.services.Status.OK) {
	
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
	
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#food_name').text()+'</div>'
			        });
			        infowindow.open(map, marker);
	
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			     } 
			});   			
		}
	}
}).mount(".container")
</script>
</body>
</html>
