<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
p{
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
.nav-link:hover{
	cursor: pointer;
}
</style>
<script src="../js/page-card.js"></script>
</head>
<body>
  <div class="container-fluid">
   <div class="row">
     <div class="col-sm-8">
     	<%-- 목록 출력 --%>
		  <div class="col-md-3" v-for="vo in list">
		    <div class="thumbnail">
		      <a class="nav-link" @click="detailData(vo.fno)">
		        <img :src="'http://www.menupan.com'+vo.poster" style="width:230px; height:130px">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
   		<div style="height: 10px"></div>
     	<%-- 페이지 출력 --%>
   		<div class="text-center">
   			<page-card></page-card>
   		</div>
     </div>
     <div class="col-sm-4" v-show="isShow">
     <%-- 상세보기: component --%>
       <food-detail v-bind:detail="detail"></food-detail>
     </div>
   </div>
  </div>
  <script>
    // <template></template>
  	const food_detail={
  		// 태그의 속성 =>  props / state(data(){}) 
  		props:['detail'],
  		template:
		`
		<table class="table">
  		  <tbody>
  		    <tr>
	  	      <td width=40% class="text-center" rowspan="8">
	  	        <img :src="'https://www.menupan.com'+detail.poster"
	  	         style="width:380px;height: 300px" class="img-rounded">
	  	      </td>
	  	      <td width="60%" colspan="2">
	  	        <h3>{{detail.name}}&nbsp;
	  	        <span style="color:orange;">{{detail.score}}</span></h3>
	  	      </td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">음식종류</td>
	  	       <td width=45%>{{detail.type}}</td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">주소</td>
	  	       <td width=45%>{{detail.address}}</td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">전화</td>
	  	       <td width=45%>{{detail.phone}}</td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">가격대</td>
	  	       <td width=45%>{{detail.price}}</td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">주차</td>
	  	       <td width=45%>{{detail.parking}}</td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">영업시간</td>
	  	       <td width=45%>{{detail.time}}</td>
	  	     </tr>
	  	     <tr>
	  	       <td width=15% style="color: gray">테마</td>
	  	       <td width=45%>{{detail.theme}}</td>
	  	     </tr>
	  	  </tbody>
		</table>
		`
  	}
  	
  	let foodApp=Vue.createApp({
  		data(){
  			return {
  				list:[],
  				curpage:1,
  				totalpage:0,
  				startPage:0,
  				endPage:0,
  				detail:{},
  				isShow:false
  			}
  		},
  		mounted(){
  			this.dataRecv()
  		},
  		methods:{
  			// 상세보기
  			detailData(fno){
  				this.isShow=true
  				axios.get('../food/detail_vue.do',{
  					params:{
  						fno:fno
  					}
  				}).then(res=>{
  					console.log(res.data)
  					this.detail=res.data
  				}).catch(err=>{
  					console.log(err.response)
  				})
  			},
  			// 이전
  			prev(){
  				this.curpage=this.startPage-1
  				this.dataRecv()
  			},
  			// 다음
  			next(){
  				this.curpage=this.endPage+1
  				this.dataRecv()
  			},
  			// 1 2 3 4 => 페이지 클릭
  			pageChange(page){
  				this.curpage=page
  				this.dataRecv()
  			},
  			// 블럭별 페이지 나누기
  			range(start,end){
  				let arr=[]
  				let len=end-start
  				for(let i=0;i<=len;i++)
  				{
  					arr[i]=start
  					start++;
  				}
  				return arr
  			},
  			// 공통사용
  			dataRecv(){
  				axios.get('../food/list_vue.do',{
  					params:{
  						page:this.curpage
  					}
  				}).then(res=>{
  					//console.log(res.data)
  					this.list=res.data.list
  					this.curpage=res.data.curpage
  					this.totalpage=res.data.totalpage
  					this.startPage=res.data.startPage
  					this.endPage=res.data.endPage
  				}).catch(err=>{
  					console.log(err.response)
  				})
  			}
  		},
  		components:{
  			'page-card':page_card,
  			'food-detail':food_detail
  		}
  	}).mount(".container-fluid")
  </script>

</body>
</html>