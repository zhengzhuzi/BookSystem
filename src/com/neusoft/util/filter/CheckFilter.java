package com.neusoft.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.neusoft.book.entity.Admin;
import com.neusoft.book.factory.ServiceFactory;
import com.neusoft.util.MD5Code;

/**
 * Servlet Filter implementation class CheckFilter
 */
public class CheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest requ, ServletResponse respo, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request=(HttpServletRequest) requ;
		HttpServletResponse response=(HttpServletResponse) respo;
        String aid="";
        String ssid="";
        Cookie[] cookies=request.getCookies();
      
        if(cookies!=null)
        {
        	for(Cookie coo:cookies){  
        		//System.out.println(coo.getName());
                if(coo.getName().equals("loginInfo")){  
                    String[] info=coo.getValue().split("=="); 
                    aid=info[0];  
                    ssid=info[1];  
                    //System.out.println(aid+ssid);
                }  
        	
        }		// pass the request along the filter chain
        	System.out.println(aid+ssid);
        	 Admin vo=new Admin();
     		  vo.setAid(aid);
     		  vo.setPassword(ssid);
     		  try {
				if(new ServiceFactory().getAdminServiceInstance().Login(vo))
				  {
					System.out.println("保存cookie中");
					request.getSession().setAttribute("aid", aid);
					response.sendRedirect("pages/back/index.jsp");  
				  }
				else{
					
					System.out.println("没有保存cookie中");
					//response.sendRedirect("login.jsp");  
					chain.doFilter(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
