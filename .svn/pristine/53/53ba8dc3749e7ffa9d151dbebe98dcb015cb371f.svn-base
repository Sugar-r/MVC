package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import common.Res;
import common.ResEnum;
import service.impl.UserService;


/**
 * Servlet implementation class ExistServlet
 */
@WebServlet("/user/existServlet")
public class ExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1-取值
//		String username = request.getParameter("username");
//		//2-处理
//		UserService userService = new UserService();
//		int flag = userService.exist(username);
//		Res resultRes = (flag == 1)?Res.success(ResEnum.USER_EXIST):Res.error(ResEnum.USER_NOT_EXIST);
//		//3-反馈 向前端返回json数据
//		String result = JSON.toJSONString(resultRes);
//		PrintWriter out = response.getWriter();
//		out.println(result);
//		out.close();
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-取值
		String username=request.getParameter("username");
		System.out.println(username);
		//2-处理
		UserService userService = new UserService();
		
		Res resultRes = userService.exist(username);
		//3-反馈 向前端返回json数据
		String result = JSON.toJSONString(resultRes);
//		System.out.println(resultRes);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
	}



}
