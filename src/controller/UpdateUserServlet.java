package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.impl.UserService;
import service.iservice.IUserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// 1-取值
				
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				 String username = request.getParameter("user");
				 String pwd = request.getParameter("pwd");
				 int balance = Integer.parseInt(request.getParameter("balan"));
				 String msg="";
				// 2-处理
				
				IUserService userService = new UserService();
				User user=new User(id,username,pwd,balance);
				
				HttpSession session=request.getSession();
				String use=(String)session.getAttribute("user");
				
				if(use !=null) {

				 msg=userService.update(user);
				}
					
				// 3-反馈 -- 跳转页面
				 if(msg.indexOf("success")!= -1) {
						
						response.sendRedirect(request.getContextPath()+"/SelectUserServlet");
					}
					else {	
						
						session.setAttribute("error",msg);
						response.sendRedirect(request.getContextPath()+"/error.jsp");
						
					}

	}
}
