package dao.impl;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.idao.IUserDao;
import entity.Dept;
import entity.User;
import util.DBUtils;

public class UserDao implements IUserDao{
	
 public int login(String username,String password) throws Exception{
	
		Connection con =  DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
		String sql = "select userName,password from user where userName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		if(rs.getString(2).equals(password)) return 1;
		
		DBUtils.close(rs, ps, con);	
		return 0;
}
 
 public int regist(User user)throws Exception{
	 Connection con =  DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
			String sql="insert into user (userName,password,balance)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getBalance());
			int n=0;
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			 n = ps.executeUpdate();
		
		DBUtils.close(rs, ps, con);	
	 return n;
 }
 
 public User getUserInfo(int id) throws Exception{
	 Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
		String sql = "select userName,password from user where userID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		// 4-获取返回的结果，进行遍历
		User user = null;
			user = new User();
			if(rs.next());
			user.setUserName(rs.getString(1));
			user.setPassword(rs.getString(2));
			
		DBUtils.close(rs, ps, con);
		return user;
 }
public  List<User> findByName(String username)throws Exception{
	List<User> users = new ArrayList<User>();
	User user = null;
	Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
	String sql = "select userId,userName,password from user where userName like concat('%',?,'%')";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, username);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		user = new User();
		user.setUserId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setPassword(rs.getString(3));
		users.add(user);
	}
	DBUtils.close(rs, ps, con);	
//List<User> users=new ArrayList<User>();
//User user=new User();
//Connection con=DriverManager.getConnection("jdbc:mysql:127.0.0.1:3036//db", user, password)
//		
	return users;
 }
 public int checkName(String username)throws Exception{
	
	 Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
	 String sql = "select userName from user where userName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return 1;
		else return 0;
 }
 
 @Override
	public List<String> listUserName() throws Exception {
		Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
		// 2-封装SQL语句 select like %
		String sql = "select username from user";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		// 3-对结果集进行处理
		List<String> users = new ArrayList<String>();
		while (rs.next()) {
			
			users.add(rs.getString(1));
			
		}
		// 4-关闭数据库资源
		DBUtils.close(rs, ps, con);
		return users;
	}
 @Override
 	public int selectBalanceByName(String userF) throws Exception {
	 Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
	 String sql = "select balance from user where userName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userF);
		ResultSet rs = ps.executeQuery();
		int n=0;
		if(rs.next())
			n= rs.getInt(1);
		
		DBUtils.close(rs, ps, con);
		return n;
 }
 	

public int insert(User t) throws Exception {
	
	QueryRunner qr = new QueryRunner(DBUtils.dataSource);
	String sql = "insert into user(username,password,balance) values(?,?,?)";
	int result = qr.update(sql, t.getUserName(), t.getPassword(), t.getBalance());
	return result;
}


public int delete(String t) throws Exception {
	QueryRunner qr = new QueryRunner(DBUtils.dataSource);
	String sql = "delete from user where userid=?";
	int result = qr.update(sql, t);
	return result;
}


public int update(User t) throws Exception {
	QueryRunner qr = new QueryRunner(DBUtils.dataSource);
	String sql = "update user set username=?,password=?,balance=? where userid=?";
	int result = qr.update(sql, t.getUserName(), t.getPassword(), t.getBalance(), t.getUserId());
	return result;
}

@Override
public List findAll() throws Exception {
	
		 Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
		 String sql = "select username,password,balance,userID from user";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User u=new User();
				u.setUserName( rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setBalance(rs.getInt(3));
				u.setUserId(rs.getInt(4));
				users.add(u);
			}
			DBUtils.close(rs, ps, con);
			return users;
}




public User findById(int id) throws Exception {
	QueryRunner qr = new QueryRunner(DBUtils.dataSource);
	String sql = "select userId,userName,password,balance from user where userId=?";
	User user = qr.query(sql, new BeanHandler<User>(User.class), id);
	return user;
}

public void changeMoneyByName(String userF, int n) throws Exception {
	
	Connection con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
	String sql = "update user set balance=? where username=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(2, userF);
	ps.setInt(1,new UserDao().selectBalanceByName(userF)+n);
	ps.executeUpdate();
	DBUtils.close(null, ps, con);
	
	
}
@Override
public boolean transMoney(String accountFrom, String accountTo, int money) {
	Connection con = null;
	PreparedStatement ps1=null;
	PreparedStatement ps2=null;
	try {
		con = DBUtils.getConnection("jdbc:mysql:///db", "root", "root");
		con.setAutoCommit(false);// 关闭自动提交功能
		String sql1 = "update user set balance=balance-? where username=?";
		String sql2 = "update user set balance=balance+? where username=?";
		ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, money);
		ps1.setString(2, accountFrom);
		ps2 = con.prepareStatement(sql2);
		ps2.setInt(1, money);
		ps2.setString(2, accountTo);
		ps1.executeUpdate();
		ps2.executeUpdate();
		con.commit();// 手动提交SQL语句执行结果
		return true;
	} catch (Exception e) {
		try {
			con.rollback();// 回滚
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
		return false;
	}
	finally {
		DBUtils.close(null, ps1, null);
		DBUtils.close(null, ps2, con);
	}
}
public List<User> findLike(String id, String username) throws Exception {
	  QueryRunner qr = new QueryRunner(DBUtils.dataSource);
	  String buffer = "select userid,username,password,balance from user where 1=1";
	  List<User> users = null;
	  if(id.length()>0) {
	   buffer = buffer+" and userid="+id;
		  }
	  if(username != null ) {
	   buffer =buffer+" and username like "+"'%"+username+"%'";
	  
	    }

	   users = qr.query(buffer, new BeanListHandler<User>(User.class));
	  
	  return users;
	 }






}