package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1-取值
			
		// 2-处理
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("user");
		String cz= request.getParameter("cz");
		
		if(user !=null ) {
			if(cz== null) {
		IUserService userService = new UserService();
		List<User> userList = userService.findAll();
		System.out.println("user...");
		// 3-反馈 -- 跳转页面
		request.setAttribute("userListFromServer", userList);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}else {
				System.out.println("emp...");
				EmpService userService=new EmpService()	;
				List<Emp> userList = userService.findAll();
				userList.stream().forEach(System.out::print);
				// 3-反馈 -- 跳转页面
				request.setAttribute("userListFromServer", userList);
				request.getRequestDispatcher("/WEB-INF/index1.jsp").forward(request, response);
			}
		
		}else {
		
			response.sendRedirect(request.getContextPath()+"/login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 3-反馈
		PrintWriter out = response.getWriter();
		out.println("<h1>错误提示：请求方式请选择GET方式</h1>");
		out.close();
	}


}
