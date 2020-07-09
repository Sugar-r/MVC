package dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.User;
import service.impl.UserService;

class UserDaoTest {

	@Test
	void testFindAll() {
		new UserService().findAll().stream().forEach(System.out::println);
	}
	@Test
	void testFindLike() throws Exception {
		new UserService().findLike(null,"1").stream().forEach(System.out::println);
		//new UserService().findLike("1","1").stream().forEach(System.out::println);
		//new UserService().findLike(null,null).stream().forEach(System.out::println);
		//new UserService().findLike("2",null).stream().forEach(System.out::println);
	}
@Test
	void testInsert() {
	User u=new User("qqq","qqq",111);
	System.out.println(u);
		System.out.println(new UserService().insert(u));;
	}
@Test
	void testDelete() throws Exception {
			System.out.println(new UserDao().delete("29"));
	}
}