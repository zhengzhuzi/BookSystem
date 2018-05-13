<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
 <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">图书管理系统</span> 
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">图书管理系统</a>
            </div>
            <!--顶部-->
            <div class="header-right">
                <a href="login.jsp" class="btn btn-danger"style="text-shadow: red 5px 3px 3px; title="Logout"> 退出系统</a>
            </div>
        </nav>
        <!-- 导航 -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="assets/img/user.png" name="img" class="img-thumbnail" width="60" height="60" />
                        <div class="image"><a  onClick="deal()">更换头像</a> </div>
                            <div class="inner-text">
                                                        管理员:<%-- <%=session.getAttribute("aid") %> --%>
                                    <c:if test="${aid!=null}">
                                     ${aid} 
                                    </c:if>                    
                                                      
                            <br />
                                <small>上次登录日期:<%=session.getAttribute("lastdate") %></small>
                            </div>
                        </div>
                    </li>

                    <li>
                        <a class="active-menu" href="pages/back/index.jsp"><i class="fa fa-dashboard "></i>导航</a>
                    </li>
                    <!--用户信息-->
                    <li>
                        <a href="#"><i class="fa fa-desktop "></i>用户管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/back/member/member_insert.jsp"><i id="anima" class="fa fa-toggle-on"></i>用户录入</a>
                            </li>
                             <li>
                                <a href="<%=basePath%>pages/back/member/MemberServlet/list"><i class="fa fa-flash "></i>分类列表</a>
                            </li>
                        </ul>
                    </li>
                    <!--超级用户信息-->
                    <c:if test="${flag==1}">
                         <li>           
                        <a href="#"><i class="fa fa-desktop "></i>超级管理员 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/back/admin/admin_insert.jsp"><i id="anima" class="fa fa-toggle-on"></i>用户录入</a>
                            </li>
                           
                        </ul>
                    </li>        
                    </c:if> 
                    
                    <!--分类信息-->
                     <li>
                        <a href="#"><i class="fa fa-yelp "></i>分类管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="pages/back/Item/item_insert.jsp"><i class="fa fa-coffee"></i>增加分类</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/Item/ItemServlet/list"><i class="fa fa-flash "></i>分类列表</a>
                            </li>
                        </ul>
                    </li>
                    <!--图书信息-->
                     <li>
                        <a href="#"><i class="fa fa-yelp "></i>图书管理 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/books/IBookServlet/insertPro"><i class="fa fa-coffee"></i>增加图书</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/books/IBookServlet/listSplit"><i class="fa fa-flash "></i>图书列表</a>
                            </li>
                        </ul>
                    </li>
                   <!--借书登记-->
                     <li>
                        <a href="#"><i class="fa fa-bicycle "></i>借书登记 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                             <li>
                                <a href="<%=basePath%>pages/back/lenbook/LenbookServlet/insertPro"><i class="fa fa-desktop "></i>借书信息录入 </a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/lenbook/LenbookServlet/listSplit"><i class="fa fa-flash "></i>借书列表</a>
                            </li>
                        </ul>
                    </li>
                     <!--借书登记-->
                    
                </ul>
            </div>
        </nav>