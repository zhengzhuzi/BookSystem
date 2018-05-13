<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath %>">
<title>选择你喜欢的头像</title>

</head>
<body>
   <tr>
   <td><a  onClick="selectImage('one')">
   <img src="assets/img/one.jpg" width="60" height="60">
   
   </a>
   </td>
   </tr>
    <script >
    function selectImage(num) {
    	//alert(num);
    	//var txt=num;
    	 window.returnValue=num; 
    	 window.close();
    }
    
    </script>
</body>
</html>