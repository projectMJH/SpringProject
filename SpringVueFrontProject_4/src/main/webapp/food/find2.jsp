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
		<div class="row" style="margin-bottom: 10px;">
		  <div class="col-xs-2" style="padding-right: 5px;">
		    <select class="form-control input-sm" name="gubun" v-model="gubun">
		      <option value="name">이름</option>
		      <option value="type">음식종류</option>
		      <option value="address">주소</option>
		      <option value="theme">테마</option>
		    </select>
		  </div>
		  <div class="col-xs-3" style="padding-left: 0; padding-right: 5px;">
		    <input type="text" class="form-control input-sm"
		           ref="fd" v-model="fd"
		           @keydown.enter="find()">
		  </div>
		  <div class="col-xs-1" style="padding-left: 0;">
		    <button class="btn btn-sm btn-primary btn-block" @click="find()">검색</button>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a :href="'../food/detail.do?fno='+vo.fno">
		        <img :src="'https://www.menupan.com'+vo.poster" style="width:230px; height:150px">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
		</div>
		<div style="height: 10px;"></div>
		<div class="row">
	 		<div class="row">
	 			<div class="text-center">
	 				<ul class="pagination">
	 					<li v-if="startPage>1"><a class="page-btn" @click="prev()">&lt;</a></li>
	 					<li v-for="i in range(startPage,endPage)" :class="curpage===i?'active':''"><a class="page-btn" @click="pageChange(i)">{{i}}</a></li>
	 					<li v-if="endPage<totalpage"><a class="page-btn" v-on:click="next()">&gt;</a></li>
	 				</ul>
	 			</div>
	 		</div>
		</div>
	</div>
	<script>
	let findApp=Vue.createApp({
		data(){
			return {
				food_list:[],
				curpage:1,
				totalpage:0,
				startPage:0,
				endPage:0,
				gubun:'name',
				fd:'마'
			}
		},
		mounted(){
			this.dataRecv()
		},
		methods:{
			find:function(){
				this.curpage=1
				if(this.fd=="")
				{
					this.$refs.fd.focus()
					return
				}
				this.dataRecv()
			},
			range(start,end){
	 			arr=[]
	 			len=end-start
	 			for(i=0;i<=len;i++)
	 			{
	 				arr[i]=start+i
	 			}
	 			return arr
	 		},
	 		prev:function(){
				this.curpage=this.startPage-1
				this.dataRecv()
			},
			next(){
				this.curpage=this.endPage+1
				this.dataRecv()
			},
			pageChange(page){
				this.curpage=page
				this.dataRecv()
			},
			dataRecv(){
				axios.get('../food/find_vue.do',{
					params:{
						page:this.curpage,
						gubun:this.gubun,
						fd:this.fd
					}
				}).then(res=>{
					console.log(res.data)
					this.food_list=res.data.list
					this.curpage=res.data.curpage
					this.totalpage=res.data.totalpage
					this.startPage=res.data.startPage
					this.endPage=res.data.endPage
					this.gubun=res.data.gubun
					this.fd=res.data.fd
				}).catch(error=>{
					console.log(error.response)
				})
				
			}
		}
	}).mount(".container")
	</script>


</body>
</html>