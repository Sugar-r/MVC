package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Emp;
import entity.User;
import service.impl.EmpService;
import service.impl.UserService;
import service.iservice.IUserService;

/**
 * Servlet implementation class FindByIdServlet
 */
@WebServlet("/FindByIdServlet1")
public class FindByIdServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取值
		String id=request.getParameter("id");
		//处理
		EmpService userService =new EmpService();
		Emp user=userService.findById(Integer.parseInt(id));
		
		//反馈
		request.setAttribute("userFormServer", user);
		request.getRequestDispatcher("/WEB-INF/emp.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
