package com.neusoft.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.book.entity.Member;
import com.neusoft.book.factory.ServiceFactory;
import com.neusoft.util.ValidataUtils;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name ="MemberServlet", urlPatterns = {"/pages/back/member/MemberServlet/*" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        if(status != null){
            if ("insert".equals(status)){
               path = this.insert(request);
            }
            if ("list".equals(status)){
                path = this.list(request);
             }
            if ("tlist".equals(status)){
            	        try {
            	        	PrintWriter out=response.getWriter();
							List<Member> list=this.tlist(request);
							System.out.println(list.get(0).getNum());
							 out.print(list.get(0).getNum());
				             out.close();
				             out.flush();
				             return;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
             }
        }
        request.getRequestDispatcher(path).forward(request,response);
    	//PrintWriter out=response.getWriter();
		//  out.println("hello");
    }

    private List<Member> tlist(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
    	
    	String mid=request.getParameter("mid");
    	System.out.println(mid+"...");
    	 try {
    		 List<Member> list=ServiceFactory.getMemberServiceInstance().findById(mid);
    		 System.out.println(list);
    		
             return list;
             
         } catch (Exception e) {
            throw e;
         }
	}

	private String list(HttpServletRequest request) {
		// TODO Auto-generated method stub
    	 try {
             request.setAttribute("allMember",ServiceFactory.getMemberServiceInstance().list());
         } catch (Exception e) {
             e.printStackTrace();
         }
         return "/pages/back/member/member_list.jsp";
		
	}

	public String insert(HttpServletRequest request) {
        String url = "";
        String msg = "";
        //接收数据
        String mid = request.getParameter("mid");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int sex = Integer.parseInt(request.getParameter("sex"));
        String phone = request.getParameter("phone");
        int creditno=0;
        int num=3;
        // 验证数据是否为空
        if(ValidataUtils.validataEmpty(mid) &&
                ValidataUtils.validataEmpty(name) &&
                ValidataUtils.validataEmpty(phone) ){
            Member vo = new Member();
            vo.setMid(mid);
            vo.setName(name);
            vo.setAge(age);
            vo.setSex(sex);
            vo.setPhone(phone);
            vo.setCreditno(90);
            vo.setNum(3);
            try {
                if (ServiceFactory.getMemberServiceInstance().insert(vo)){
                    url = "/pages/back/member/member_insert.jsp";
                    msg = "用户数据增加成功!";
                }else{
                    url = "/pages/back/member/member_insert.jsp";
                    msg = "该用户可以增加过导致增加失败!";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            url = "/pages/back/member/member_insert.jsp";
            msg = "数据不能为空!";
        }
        request.setAttribute("url",url);
        request.setAttribute("msg",msg);
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
