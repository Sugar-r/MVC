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
 * Servlet implementation class FindByIdServlet
 */
@WebServlet("/FindByIdServlet")
public class FindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取值
		String id=request.getParameter("id");
		//处理
		IUserService userService =new UserService();
		User user=userService.findById(Integer.parseInt(id));
		
		//反馈
		request.setAttribute("userFormServer", user);
		request.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
