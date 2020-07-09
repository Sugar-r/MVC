package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

				// 1-取值
				
				 String username = request.getParameter("user");
				 String pwd = request.getParameter("pwd");
				 String repwd = request.getParameter("repwd");
				 int balance = Integer.parseInt(request.getParameter("balan"));
				 String msg="";
				// 2-处理
				 if(pwd.equals(repwd)) {
				IUserService userService = new UserService();
				User user=new User(username,pwd,balance);
				 msg=userService.insert(user);
				 }
				 else {
					 msg="error:两次输入不一致";
				 }
				// 3-反馈 -- 跳转页面
				 if(msg.indexOf("success")!= -1) {
					 String cz=request.getParameter("cz");
					 System.out.println(cz);
						if("xz".equals(cz))
						response.sendRedirect(request.getContextPath()+"/SelectUserServlet");
						else response.sendRedirect(request.getContextPath()+"/login.jsp");
					}
					else {	
						HttpSession session=request.getSession();
						session.setAttribute("error",msg);
						response.sendRedirect(request.getContextPath()+"/error.jsp");
						
					}

	}}
