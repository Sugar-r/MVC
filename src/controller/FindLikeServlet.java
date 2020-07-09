package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.impl.UserService;
import service.iservice.IUserService;

@WebServlet("/FindLikeServlet")
public class FindLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// 1-取值
		String id = request.getParameter("id");
		 String username = request.getParameter("username");
		 System.out.println(username);
		// 2-处理
		IUserService userService = new UserService();
		List<User> userList = userService.findLike(id,username);
				
		// 3-反馈 -- 跳转页面
		request.setAttribute("userListFromServer", userList);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 3-反馈
		PrintWriter out = response.getWriter();
		out.println("<h1>错误提示：请求方式请选择POST方式</h1>");
		out.close();
	}
}
