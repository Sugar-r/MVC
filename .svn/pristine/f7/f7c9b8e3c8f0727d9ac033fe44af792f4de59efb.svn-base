package dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import service.impl.UserService;

class EmpDaoTest {

	@Test
	void test() throws Exception {
		new EmpDao().findAll().stream().forEachOrdered(System.out::print);
	}
	@Test
	void test1() throws Exception {
		System.out.println(new EmpDao().findById(1));
	}
	@Test
	void test2() throws Exception {
		System.out.println(new UserDao().checkName("1111"));
		System.out.println(new UserService().exist("1111"));
	}
}
