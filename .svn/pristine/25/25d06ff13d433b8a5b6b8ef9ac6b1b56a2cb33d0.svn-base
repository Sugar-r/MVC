package service.impl;

import java.util.List;

import dao.impl.EmpDao;
import dao.impl.ProductDao;
import dao.impl.UserDao;
import entity.Emp;
import entity.Product;
import entity.User;

public class ProductService {
	ProductDao productDao=new ProductDao();
	
	public List<Product> findAll() {
		try {
			return productDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	public static void main(String[] args) throws Exception {
		new ProductDao().findAll().stream().forEach(System.out::print);
	}
}
