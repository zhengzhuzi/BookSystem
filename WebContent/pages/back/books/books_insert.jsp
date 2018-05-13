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
<title>优乐图书管理系统</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/basic.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
	 <link href='assets/css/div5.css' rel='stylesheet' />
</head>
<body>
	<div id="wrapper">
     <jsp:include page="/pages/back/header.jsp"></jsp:include>
		<!-- 此处编写内容  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="col-md-12">
					
					<div class="col-md-6 col-md-offset-4">
						<h1 class="h1">增加图书操作</h1>
					</div>
					<div class="col-md-12">
						<hr>
					</div>
				</div>
				<%--编写数据增加表单--%>
				<form action="<%=basePath%>pages/back/books/IBookServlet/insert"
					enctype="multipart/form-data" method="post" class="form-horizontal" id="insertForm">
					<%--图书名称--%>
					<div class="form-group">
						<label for="name" class="col-md-3 control-label">图书名称</label>
						<div class="col-md-6">
							<input type="text" name="name" id="name"
								class="form-control input-sm" >
						</div>
					</div>

					<c:if test="${allAdmins != null}">
						<%--aid--%>
						<div class="form-group">
							<label for="aid" class="col-md-3 control-label">管理员ID</label>
							<div class="col-md-6">
								<%-- <select class="form-control"id="aid" name="aid">
                                          <c:forEach items="${allAdmins}" var="admin" >
                                          <option value="${admin.aid }">${admin.aid}</option>
                                          </c:forEach>
                                    </select> --%>
								${aid}
							</div>
						</div>
					</c:if>

					<c:if test="${allItems != null}">
						<%--aid--%>
						<div class="form-group">
							<label for="iid" class="col-md-3 control-label">图书种类</label>
							<div class="col-md-6">
								<select class="form-control" id="iid" name="iid">

									<c:forEach items="${allItems}" var="item">
										<!--Book中的iid参数取item的iid的值，通过value  -->
										<option value="${item.iid}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</c:if>

					<!--内容简介-->
					<div class="form-group">
						<label for="note" class="col-md-3 control-label">内容简介</label>
						<div class="col-md-6">
							<textarea name="note" id="note" class="form-control" ></textarea>
						</div>
					</div>
					<!--图书图片-->
					<div class="form-group">
						<label for="note" class="col-md-3 control-label">图书图片</label>
						<div class="col-md-6">
							<input type="file" name="uploadFile "> 
							 <c:if test="${image_path != null}">
							    <img src="${image_path}" width="200" height="200"> 
							 </c:if>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-5 col-md-offset-3">
							<button type="submit" class="btn btn-success c" onclick="formSubmit()">提交</button>
							<button type="reset" class="btn btn-success">重置</button>
						</div>
					</div>
				</form>
				 <!-- <div class="mouse">
                        <iframe src="http://cdn.abowman.com/widgets/newtonscradle/newtonsCradle.swf" width="300" height="225" scrolling="NO" frameborder="0"></iframe>
                 </div> -->
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
	<%-- <script type="text/javascript">
	function formSubmit(){
    var action="<%=basePath%>pages/back/books/IBookServlet/insert";  
    alert("11");
    action+="?name="+"1";
    alert(action);
    alert("11");
    document.insertForm.action=action;      
    document.insertForm.submit(); 
   
      }
	</script> --%>
</body>
</html>
