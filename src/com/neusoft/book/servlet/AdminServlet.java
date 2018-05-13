package com.neusoft.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.book.entity.Admin;
import com.neusoft.book.factory.ServiceFactory;
import com.neusoft.util.MD5Code;
import com.neusoft.util.ValidataUtils;

/**@WebServlet(name ="Admin", urlPatterns = {"/pages/back/AdminServlet/*" })
 * Servlet implementation class AdminServlet
 */

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // TODO Auto-generated method stub
		 //response.sendRedirect("login.jsp");
		 /*PrintWriter out=response.getWriter();
		  out.println("hello");*/
		 String path="/pages/errors.jsp";
		 String status=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);	
		 if(status!=null)
		 {
			 if ("login".equals(status)){
	               try {
					path = this.login(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }else if("reg".equals(status)){
	                path  =this.reg(request);
	            }

			 
		 }
		 request.getRequestDispatcher(path).forward(request,response);
	}
	
	public String reg(HttpServletRequest request) {
        String msg = "";
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");
        if (ValidataUtils.validataEmpty(aid) && ValidataUtils.validataEmpty(password)){
            Admin vo = new Admin();
            vo.setAid(aid);
            vo.setPassword(new MD5Code().getMD5ofStr(password+aid)); // 需要加盐处理
            vo.setLastdate(new Date());
            vo.setStatus(1); // 默认激活
            try {
                if (ServiceFactory.getAdminServiceInstance().insert(vo)){
                    msg = "管理员注册成功！";
                }else{
                    msg = "管理员注册失败！";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            msg = "数据不能为空！";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url","/pages/back/admin/admin_insert.jsp");
        return "/pages/forward.jsp";
    }

	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception
      {
    	 
    	  String msg="";
    	  String url="";
    	  String aid=request.getParameter("aid");
    	  String password=request.getParameter("password");
    	  
    	  int timeout = new Integer(request.getParameter("timeout"));
    	  if(new ValidataUtils().validataEmpty(aid)||new ValidataUtils().validataEmpty(password))
    	  {
    		  Admin vo=new Admin();
    		  vo.setAid(aid);
    		  String ssid=new MD5Code().getMD5ofStr(password+aid);
    		  vo.setPassword(ssid);
    		  if(new ServiceFactory().getAdminServiceInstance().Login(vo))
    		  {
    			  request.getSession().setAttribute("aid", aid);
    			  request.getSession().setAttribute("lastdate", vo.getLastdate());
    			  request.getSession().setAttribute("flag",vo.getFlag());
    			  System.out.println(vo.getFlag()); 
    			  Cookie cookie=new Cookie("loginInfo",aid+"=="+ssid);
    			  cookie.setMaxAge(timeout);

    			  cookie.setPath(request.getContextPath());
    			  response.addCookie(cookie);
    			  msg="登录成功";
    			  url="/pages/back/index.jsp";
    			  System.out.println(new MD5Code().getMD5ofStr(1234+"liu"));
    		  }
    		     else{
    		    	 
    			     msg="错误的ID或密码";
    			     url="/login.jsp";
    		  }
    	    } else{
    			  msg="数据不能为空";
    			  url="/login.jsp";
    		  }
    		 request.setAttribute("msg", msg); 
    		 request.setAttribute("url",url);
    	     return "/pages/forward.jsp";
    	  }	  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
