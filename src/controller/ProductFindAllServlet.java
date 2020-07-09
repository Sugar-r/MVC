package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Product;
import entity.User;
import service.impl.ProductService;
import service.impl.UserService;

/**
 * Servlet implementation class ProductsFindAll
 */
@WebServlet("/ProductFindAllServlet")
public class ProductFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ProductService productService =new ProductService();
	List<Product> productList =productService.findAll();
	productList.stream().forEach(System.out::print);
	if(productList != null && productList.size()>0) {
		String result= JSON.toJSONString(productList);
		PrintWriter out= response.getWriter();
		out.write(result);
		out.close();
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
