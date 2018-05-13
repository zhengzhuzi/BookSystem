<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <%--   <c:if test="${allBooks != null}"> --%>
        <table class="table table-border">
           <tr>
                    <th>编号</th>
                    <th>分类名称</th>
                    <th>管理员</th>
                    <th>图书名称</th>
                    <th>创建日期</th> 
                    <th>图书图片</th>
                    <th>状态</th>
           </tr>
            <tr>
            <c:forEach items="${allBooks}" var="books">
            <tr>
                      <td>${books.bid}        </td>
                      <td>${books.item.name}  </td>
                      <td>${books.admin.aid}  </td>
                      <td>${books.name}       </td>
                      <td>${books.creadate}   </td> 
                       <td> <img src="${books.imagepath}" class="img" width="100" height="100"></td>
                        <td>
                           <c:if test="${books.status ==1}">
                                                          上架
                           </c:if>
                           <c:if test="${books.status ==2}">
                                                          下架
                           </c:if>
                       </td>
             </tr>
            
           </c:forEach>
            </tr>
        </table>
            <div>
              <button type="button" class="btn btn-success" id="makelist">全部列出</button>
            </div>
             <div>
              <button type="button" class="btn btn-success" id="closelist" style="display:none;">分类列出</button>
            </div>
               <div class="col-md-5 col-md-offset-3" id="split">
                    <jsp:include page="/pages/back/split_bar.jsp"></jsp:include>
                </div> 
             <%-- </c:if>  --%>
              
             		 <!--  <div class="mouse">
                         <iframe src="http://cdn.abowman.com/widgets/penguins/penguins.swf" width="400" height="225" scrolling="NO" frameborder="0"></iframe>
                   sss
                 </div>  -->
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
<script type="text/javascript">
$(document).ready(function(){
	 var x=10;
	 var y=20;
	 $(".img").mouseover(function(e){
		 //alert("1");
		 // this.myTitle=this.title;
		// this.title="";
		 //var imgTitle=this.myTitle?"<br/>"+this.myTitle:"";
	     var tooltip="<div class='mouse'><img src='"+this.src+"' style='width:300px;height:300px;'></div>";
	     $("body").append(tooltip);//将它追加到文档中
	      $("#tooltip").css({
	    	   "top":(e.pageY+y)+"px",
	    	   "left":(e.pageX+x)+"px"
	            
	      }).show("fast"); //设置x坐标和y坐标，并且显示 */
		 
	 }).mouseout(function(){
		 // this.title=this.myTitle;
		 //$(".mouse").animate({right:'250px'});
		 $(".mouse").remove(); //移除 
		 //alert("2")
	 }).mousemove(function(e){
		  $(".mouse")
		 .css({
			 "top":(e.pageY+y)+"px",
			 "left":(e.pageX+x)+"px"
		 }); 
		// alert("3")
	 });

	})
	
 $("#makelist").click(function () {
	//alert("test");
	location.href = "<%=basePath%>pages/back/books/IBookServlet/list";
    
});
 
 
	

 $(document).ready(function () {
	$("#closelist").click(function () {
		 location.href ="<%=basePath%>pages/back/books/IBookServlet/listSplit";
		 if($("makelist").is(":hidden"))
		    $("#closelist").show();
		    $("#makelist").hide();
		   
		
	})
})
</script>

</body>
</html>
