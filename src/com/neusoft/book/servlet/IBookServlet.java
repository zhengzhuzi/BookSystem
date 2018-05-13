package com.neusoft.book.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.neusoft.book.entity.Admin;
import com.neusoft.book.entity.Books;
import com.neusoft.book.entity.Item;
import com.neusoft.book.factory.ServiceFactory;
import com.neusoft.util.ValidataUtils;

/**
 * Servlet implementation class IBookServlet
 * 
 * 因为book中有aid,iid字段，分别和admin和item表有关系，所以
 * 要先从Admin,Item取出所有数据，然后再取出来，放给book的参数中，
 * 先跳转到insertPro，把admin和item的参数传过去，然后再insert执行插入
 */
@WebServlet(name ="iBookServlet", urlPatterns = {"/pages/back/books/IBookServlet/*" })
public class IBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String newFileName="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
      @Override
    protected void service(HttpServletRequest request, HttpServletResponse arg1)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(request, arg1);
    	 //String status = request.getRequestURI();
    	// System.out.println("66666666666666");
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String path = "/pages/errors.jsp"; // 定义错误页面
	        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
	        if(status != null){
	            if ("insert".equals(status)){
	               path = this.insert(request);
	              
	            }else if("insertPro".equals(status)){
	                path = this.insertPro(request);
	            }else if("list".equals(status))
	            {
	            	 path = this.list(request);
	            }
	            else if("listSplit".equals(status))
	            {
	            	 path = this.listSplit(request);
	            }
	            
	        }
	        request.getRequestDispatcher(path).forward(request,response);
	}

	private String listSplit(HttpServletRequest request) {
		  int currentPage = 1;
	        int lineSize = 3;
	        try {
	            currentPage = Integer.parseInt(request.getParameter("cp"));
	        }catch (Exception e){}
	        try {
	             lineSize = Integer.parseInt(request.getParameter("ls"));
	        }catch (Exception e){}
	        String keyWord = request.getParameter("kw");
	        String column = request.getParameter("col");
	        if(keyWord == null){
	            keyWord = "";
	        }
	        if (column == null){
	            column = "name";
	        }

	        try {
	            Map<String,Object> map = ServiceFactory.getBookServiceInstance().listBySplit(column,keyWord,currentPage,lineSize);
	            request.setAttribute("allBooks",map.get("allBooks"));
	            request.setAttribute("allRecorders",map.get("allCounts"));
	            System.out.println(map.get("allBooks"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        request.setAttribute("url","/pages/back/books/IBookServlet/listSplit");
	        request.setAttribute("currentPage",currentPage);
	        request.setAttribute("lineSize",lineSize);
	        return "/pages/back/books/books_list.jsp";
	}

	private String list(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setAttribute("allBooks", new ServiceFactory().getBookServiceInstance().list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/pages/back/books/books_list.jsp";
		/*http://localhost:8080/BookSystem/pages/back/books/IBookServlet/list
*/	}

	private String insertPro(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String,Object> map=null;
		try {
			map=new ServiceFactory().getBookServiceInstance().findByAdminAndItem();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.setAttribute("allItems", map.get("allItems"));
		request.setAttribute("allAdmins", map.get("allAdmins"));
		return "/pages/back/books/books_insert.jsp";
		
		
	}

	private String insert(HttpServletRequest request) {
		if (ServletFileUpload.isMultipartContent(request)) {

			// 1. 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹

			// 2. 创建ServletFileUpload对象，并设置上传文件的大小限制。
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setSizeMax(10 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte =
			// 1kb 1024kb=1M 1024M = 1G
			sfu.setHeaderEncoding("utf-8");

			// 3.
			// 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemList = null;
			try {
				fileItemList = sfu.parseRequest(request);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Iterator<FileItem> fileItems = fileItemList.iterator();

			// 4. 遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
			while (fileItems.hasNext()) {
				FileItem fileItem = fileItems.next();
				// 普通表单元素
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();// name属性值
					String value = null;
					System.out.println("name="+name);
					//String 
					try {
						value = fileItem.getString("utf-8");
						
						if(name.equals("name"))
						{
							System.out.println(2);
							//request.setAttribute("name", name);
							//System.out.println("name="+name);
							request.setAttribute("value", value);
						}
						else if(name.equals("note"))
						{
							System.out.println(1);
							request.setAttribute("value_note", value);
						}
						else if(name.equals("iid"))
						{
							System.out.println(4);
							request.setAttribute("value_iid", value);
						}
						//System.out.println(name+".."+value);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}// name对应的value值

					//System.out.println(name + " = " + value);
				}
				// <input type="file">的上传文件的元素
				else {
					String fileName = fileItem.getName();// 文件名称
					System.out.println("原文件名：" + fileName);// Koala.jpg
                       
					// String suffix =
					// fileName.substring(fileName.lastIndexOf('.'));
					String suffix = ".jpg";
					System.out.println("扩展名：" + suffix);// .jpg

					// 新文件名（唯一）
					String newFileName = new Date().getTime() + suffix;
					System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg

					// 5. 调用FileItem的write()方法，写入文件
//					File file = new File(
//							"D:/Tomcat/apache-tomcat-7.0.82-windows-x64/apache-tomcat-7.0.82/webapps/BookSystem/assets/img/"
//									+ newFileName);
					File file=new File("F:/WeGame/img/"+ newFileName);
					System.out.println(file.getAbsolutePath());
					try {
						fileItem.write(file);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 6. 调用FileItem的delete()方法，删除临时文件
					// fileItem.delete();

					// String
					// url=Thread.currentThread().getContextClassLoader().getResource("").getPath();
					// String
					// path=Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(1,url.indexOf("WEB-INF"))+"image/";
					// System.out.println(path+"...");
//					request.getSession().setAttribute("image_path",
//							"assets/img/" + newFileName);
					request.getSession().setAttribute("image_path",
							"/imagepath/" + newFileName);
					// response.sendRedirect("Uplond.jsp");

				}
			}
		}
		String url = "";
		String msg = "";
		// 接收数据
		//String name = request.getParameter("name");
		 String name1=(String) request.getAttribute("value");
		String note = (String) request.getAttribute("value_note");
		
		// String aid = request.getParameter("aid");
		String aid = (String) request.getSession().getAttribute("aid");
		// Integer iid = Integer.parseInt(request.getParameter("iid"));
		String iidStr = (String) request.getAttribute("value_iid");
		Integer iid=Integer.valueOf(iidStr);
		System.out.println(name1+"..."+note+"..."+iid);
		//System.out.println(aid);
		//System.out.println(iid);
		// 验证数据是否为空
		if (ValidataUtils.validataEmpty(name1)
				&& ValidataUtils.validataEmpty(note)) {
			Books vo = new Books();
			vo.setName(name1);
			vo.setNote(note);
			Admin admin = new Admin();
			admin.setAid(aid);
			vo.setAdmin(admin);
			Item item = new Item();
			item.setIid(iid);
			vo.setItem(item);
			vo.setStatus(1);// 1表示上架，2表示下架
			String imagepath=(String) request.getSession().getAttribute("image_path");
			System.out.println("newFileName="+imagepath);
			vo.setImagepath(imagepath);
			//vo.setImagepath("assets/img/" + "1519693043666.jpg");
			try {
				if (ServiceFactory.getBookServiceInstance().insert(vo)) {
					// request.getSession().setAttribute("imagepath","assets/img/"+newFileName);
					url = "/pages/back/books/IBookServlet/insertPro";
					msg = "用户数据增加成功!";
				} else {
					url = "/pages/back/books/IBookServlet/insertPro";
					msg = "用户数据增加失败!";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			url = "/pages/back/books/IBookServlet/insertPro";
			msg = "数据不能为空!";
		}
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		// return "/pages/forward.jsp";
// return "/pages/back/books/books_insert.jsp";
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


