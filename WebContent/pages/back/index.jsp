<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
    <meta charset="GBK" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath %>">
    <title>图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='assets/css/work.css' rel='stylesheet' type='text/css' />
    <link href="assets/css/div5.css" rel="stylesheet" />
  
</head>
 
<body>
    <div id="wrapper">
       
<jsp:include page="/pages/back/header.jsp"></jsp:include>

        <!-- 此处编写内容  -->
        <div id="page-wrapper" >
            <div id="page-inner"  >
            <div class="divcss5">
            <canvas id="canvas" style="height: 100%;">
                            当前浏览器不支持Canvas, 请更换浏览器后再试。
                </canvas>
            </div> 
              <script src="validate/digit.js"></script>
              <script src="validate/countdown.js"></script>
              <script src="validate/font/plug-in.js"></script>
             
              <div class="text">你好， ${sessionScope.aid}同学，<br><br><br>
                                欢迎来到本系统，<br><br><br>
                                可以对左边导航进行图书管理</div>
              </div>
            
        </div>
    </div>

 <jsp:include page="/pages/back/footer.jsp"></jsp:include>
 
    
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom.js"></script>
    <script type="text/javascript" src="validate/text.js"></script>
   
</body>
</html>
