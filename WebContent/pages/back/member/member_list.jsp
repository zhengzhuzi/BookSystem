<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<base href="<%=basePath%>">
<title>图书管理系统</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link href='assets/css/work.css' rel='stylesheet' type='text/css' />
<link href='assets/css/div5.css' rel='stylesheet' />
<link href='assets/css/floatdiv.css' rel='stylesheet' />
<body>
	<div id="wrapper">
		<jsp:include page="/pages/back/header.jsp"></jsp:include>

		<!-- 此处编写内容  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="col-md-12">
					<div class="col-md-6 col-md-offset-4">
						<h1 class="h1">用户信息列表</h1>
					</div>
                        
					<div class="col-md-12">
						<hr>
					</div>
				</div>
				<%-- <c:if test="${allItem != null}"> --%>
				<table class="table" id="flush">
					<tr>
						<th>名字</th>
						<th>年龄</th>
						<th>性别</th>
						<th>电话</th>
						<th>信誉度</th>
						<th>剩余的借书的次数</th>
					</tr>
					<c:forEach items="${allMember}" var="member">
						<tr>
							
							<td>${member.name}</td>
							<td>${member.age}</td>
							<td>${member.sex}</td>
							<td>${member.phone}</td>
							<td>${member.creditno}</td>
							<td>${member.num}</td>
						</tr>
					</c:forEach>
				</table>
					</form>
				</div>
				<div id="fade" class="black_overlay"></div>
				<%--  </c:if> --%>
				<div class="mouse">
					<iframe src="http://cdn.abowman.com/widgets/fish/fish.swf"
						width="400" height="225" scrolling="NO" frameborder="0"></iframe>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/pages/back/footer.jsp"></jsp:include>
	<script src="assets/js/jquery-1.10.2.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/custom.js"></script>

	<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
	<script type="text/javascript"
		src="validate/js/additional-methods.min.js"></script>
	<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
	<script type="text/javascript" src="validate/member_insert.js"></script>
	<script type="text/javascript">
	$("#close").click(function () {
		document.getElementById('light').style.display='none';
		document.getElementById('fade').style.display='none';
	})
	function change(id,name,note)
	{
	
		  document.getElementById('light').style.display='block';
		  document.getElementById('fade').style.display='block';
		  document.getElementById('name').value=name;
		  document.getElementById('thing').value=note;
		  document.getElementById('iid').value=id;
	}
	function close()
	{
		//alert("121")
		document.getElementById('light').style.display='none';
		document.getElementById('fade').style.display='none';
	}
	$(document).on("click","#change",function(){
		
		var name=$("#name").val();
		var thing=$("#thing").val();
		var iid=$("#iid").val();
		//alert("name+thing="+name+".."+thing+".."+iid);
		$.ajax({
				url: "/BookSystem/pages/back/Item/ItemServlet/update",
				type:"POST",
				async: false,
				data: 
					{
					 id:iid,
					 name:name,
					 note:thing,
					},			
				success: function(data)
				{   
					if(data)
					{
				    	alert("修改成功")
					   // $("#name").val("");
					   // $("#thing").val("");
					 window.location.reload(true);
					  //$("#flush").load();
					    close();
					}
					
			       else
			     	{
						alert("修改失败");
				    }
				}
					
			}	
		)
			
	})
	
	</script>
</body>
</html>
