package service.impl;

import java.util.List;

import dao.impl.EmpDao;
import dao.impl.EmpDao;
import dao.impl.UserDao;
import entity.Emp;
import entity.Emp;
import entity.User;

public class EmpService {
	EmpDao empDao=new EmpDao();
	
	public List<Emp> findAll() {
		try {
			return empDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}
	public Emp findById(int id) {
		try {
			return empDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		new EmpService().findAll().stream().forEach(System.out::print);
	}
	
}
