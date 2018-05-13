package com.neusoft.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.book.entity.Item;
import com.neusoft.book.factory.ServiceFactory;
import com.neusoft.util.ValidataUtils;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(name ="itemServlet", urlPatterns = {"/pages/back/Item/ItemServlet/*" })
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flag ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
        String path = "/pages/errors.jsp"; // 定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        String DeleteId = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        if(status != null){
        	 System.out.println(status);
            if ("insert".equals(status)){
               path = this.insert(request);
              // PrintWriter out=response.getWriter();
     		  // out.println("hello");
            }else if("list".equals(status)){
                path = this.list(request); 
            }
            else if("delete".equals(status))
            //else if(status.indexOf("delete")!=-1)
            {
            	path = this.delete(request); 
            	//System.out.println("asd");
            }
            else if("select".equals(status))
            {   
            	path = this.select(request); 
            }
            else if("update".equals(status))
           {   
               flag=this.update(request); 
               out.print(flag);
               out.close();
               out.flush();
               return;
           	
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    	//PrintWriter out=response.getWriter();
		//  out.println("hello");
    }

    private boolean update(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//System.out.println("test");
    	int iid=Integer.parseInt(request.getParameter("id"));
    	 String name=request.getParameter("name");
    	 String note=request.getParameter("note");
    	 Item vo=new Item();
    	 vo.setIid(iid);
    	 vo.setName(name);
    	 vo.setNote(note);
    	 
    	try {
    		
			if(new ServiceFactory().getItemServiceInstance().update(vo))
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	private String select(HttpServletRequest request) {
		// TODO Auto-generated method stub
    	//System.out.println("99");
    	 int id=Integer.parseInt(request.getParameter("id"));
    	
    	 
    	 try {
			request.setAttribute("itemData", new ServiceFactory().getItemServiceInstance().FindById(id));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "1";
	}

	private String delete(HttpServletRequest request) {
    	  String url = "";
          String msg = "";
		// TODO Auto-generated method stub
    	    int id=Integer.parseInt(request.getParameter("id"));
    	    try {
				if(new ServiceFactory().getItemServiceInstance().delete(id))
				{  
					url="/pages/back/Item/ItemServlet/list";
					msg="数据删除成功";
				}
				else
				{
					url="/pages/back/Item/ItemServlet/list";
					msg="数据删除失败";
				}
    	    } catch (Exception e) {
				// TODO: handle exception
    	    	e.printStackTrace();
			}
    	    request.setAttribute("url",url);
            request.setAttribute("msg",msg);
            return "/pages/forward.jsp";
	}

	private String list(HttpServletRequest request) {
		// TODO Auto-generated method stub
    	 try {
             request.setAttribute("allItem",ServiceFactory.getItemServiceInstance().list());
         } catch (Exception e) {
             e.printStackTrace();
         }
         return "/pages/back/Item/item_list.jsp";
	}

	public String insert(HttpServletRequest request) {
        String url = "";
        String msg = "";
        //接收数据
        String name = request.getParameter("name");
        String note = request.getParameter("note");
      // System.out.println(name);
      // System.out.println(note);
        // 验证数据是否为空
        if(ValidataUtils.validataEmpty(name) &&
                ValidataUtils.validataEmpty(note) 
                 ){
            Item vo = new Item();
            vo.setName(name);
            vo.setNote(note);
            try {
                if (ServiceFactory.getItemServiceInstance().insert(vo)){
                    url = "/pages/back/Item/item_insert.jsp";
                    msg = "用户数据增加成功!";
                }else{
                    url = "/pages/back/Item/item_insert.jsp";
                    msg = "用户数据增加失败!";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            url = "/pages/back/Item/item_insert.jsp";
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
