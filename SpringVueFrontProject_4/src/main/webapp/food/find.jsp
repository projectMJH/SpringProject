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
		<input type="text" class="input-sm" size=15 
			ref="fd" v-model="fd" v-on:keydown.enter="find()">
	</div>
    <div style="height: 10px"></div>
	<div class="row">
	  <div class="col-md-3" v-for="vo in food_list">
	    <div class="thumbnail">
	      <a :href="'../food/detail.do?no='+vo.fno">
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
					fd:this.fd
				}
			}).then(res=>{
				this.food_list=res.data.list
				this.curpage=res.data.curpage
				this.totalpage=res.data.totalpage
				this.startPage=res.data.startPage
				this.endPage=res.data.endPage
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