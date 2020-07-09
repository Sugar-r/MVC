package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.impl.UserService;
import service.iservice.IUserService;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//取值
		String id=request.getParameter("id");
		//处理
		IUserService userService =new UserService();
		String msg=userService.delete(id);
		
		//反馈

		if(msg.indexOf("success")!= -1) {
			
			response.sendRedirect(request.getContextPath()+"/SelectUserServlet");
		}
		else {	
			HttpSession session=request.getSession();
			session.setAttribute("error",msg);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
