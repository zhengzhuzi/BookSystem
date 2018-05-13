<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
						<h1 class="h1">借书列表</h1>
					</div>

					<div class="col-md-12">
						<hr>
					</div>
				</div>
            <table class="table table-border">
                <tr>
                    <th>编号</th>
                    <th>图书名称</th>
                    <th>真实姓名</th>
                    <th>创建日期</th>
                    <th>是否归还</th>
                    <th>借书天数</th>
                    <th>归还日期</th>
                    <th>操作</th>
                    <!-- <th>信誉度分值</th> -->
                </tr>
                <c:forEach items="${allLenbooks}" var="len">
                 <%-- //${fn:substring(len.credate,8,10)+len.retday} --%>
                      
                      <tr>
                       <td>${len.leid}</td>
                       <td>${len.books.name}</td>
                       <td>${len.member.name}</td>
                       <td>${len.credate}</td>
                       <td>
                           <%-- <c:if test="${len.retdate != null}">
                                   <c:if test="${fn:substring(len.credate,8,10)+len.retday<fn:substring(len.retdate,8,10)}">
                                                                           逾期还
                                   </c:if>                                                     
                                   <c:if test="${fn:substring(len.credate,8,10)+len.retday>=fn:substring(len.retdate,8,10)}">
                                                                           正常还
                                   </c:if>     
                                                       
                           </c:if>--%>
                          <c:if test="${len.retdate == null}" >                                 
                                                                    还未归还                                     
                           </c:if>  
                            <c:if test="${len.retdate != null}" >                                 
                                     ${len.retstatus}                                 
                           </c:if> 
                       </td>
                       <td>${len.retday}</td>
                       
                       <td>${len.retdate}</td>
                       <td>
                           <c:if test="${len.retdate == null}">
                               <a href="<%=basePath%>pages/back/lenbook/LenbookServlet/updateRetdate?leid=${len.leid}&credate=${len.credate}&retday=${len.retday}&mid=${len.member.mid}&creditno=${len.member.creditno}&num=${len.member.num}">归还图书</a>
                           </c:if>
                       </td>
                       <%-- <td>${len.creditno}</td> --%>
                   </tr>
                </c:forEach>
            </table>
                <div class="col-md-5 col-md-offset-5">
                    <jsp:include page="/pages/back/split_bar.jsp"></jsp:include>
                </div>
          <%--   </c:if> --%>
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
<script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/member_insert.js"></script>
</body>
</html>
