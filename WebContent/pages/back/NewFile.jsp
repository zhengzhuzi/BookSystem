<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>CSS3制作炫酷搜索框动画特效</title>
<style type="text/css">
.black_overlay {
display: none;
position: absolute;
top: 0%;
left: 0%;
width: 100%;
height: 100%;
background-color: black;
z-index: 1001;
-moz-opacity: 0.8;
opacity: .80;
filter: alpha(opacity = 88);
}


.white_content {
display: none;
position: absolute;
top: 5%;
left: 5%;
width: 200px;
height: 200px;
padding: 20px;
border: 10px solid orange;
background-color: white;
z-index: 1002;
overflow: auto;
}
</style>


<!--[if IE]>
		<script src="http://libs.baidu.com/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	<a href="javascript:void(0)"
		onclick="document.getElementById('light').style.display='block';
  document.getElementById('fade').style.display='block'">

		<input type="button" value="创建新物品" id="creat_new">

	</a>
	<div id="light" class="white_content">
		创建资产 <a href="javascript:void(0)"
			onclick="document.getElementById('light').style.display='none'; 
document.getElementById('fade').style.display='none'">
			创建完毕点击这里 </a> <br> <input type="text" placeholder="资产名"
			id="insert_name"><br> <input type="text"
			placeholder="资产数量" id="insert_num"><br> <input
			type="text" placeholder="资产价格" id="insert_price"><br> <br>
		<br> <input type="button" value="添加资产" id="insert"><br>
		<br>
	</div>
	//周边变暗
	<!-- <div id="fade" class="black_overlay"></div> -->
	JS

    <script src="assets/js/jquery-1.10.2.js"></script>
	<script type="text/javascript">
		//创建资产
		$(document).on('click', '#insert', function(e) {
			var name = $("#insert_name").val();
			var num = $("#insert_num").val();
			var price = $("#insert_price").val();
			alert("name=" + name + "num=" + num + "=price=" + price);
			$.ajax({
				url : "action_zcgl_creatgdzc",
				type : "POST",
				data : {
					"zcgl.gdzc_name" : name,
					"zcgl.gdzc_num" : num,
					"zcgl.gdzc_price" : price

				},
				success : function(data) {
					alert("资产创建成功");
					$("#insert_name").val("");
					$("#insert_num").val("");
					$("#insert_price").val("");
				}
			});
		});
	</script>
</body>
</html>