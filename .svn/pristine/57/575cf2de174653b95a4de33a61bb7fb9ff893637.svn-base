package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.idao.IDeptDao;
import entity.Dept;
import util.DBUtils;

public class DeptDao implements IDeptDao{
	public List<Dept> findAll() throws Exception{
	Connection con = DBUtils.getConnection();
		String sql = "select deptno,ename,job,mgr,hiredate,sal,comm,deptno from dept";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Dept> depts = new ArrayList<Dept>();
		while(rs.next()) {
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
			
			depts.add(dept);
		}
		DBUtils.close(rs, ps, con);
		return depts;
	}
	public  List<Dept> findByPage(int page,int size) throws Exception{
	Connection con = DBUtils.getConnection();
		String sql = "select deptno,dname,loc from dept limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		//设置入参
		ps.setInt(1, (page-1)*size);
		ps.setInt(2, size);
		ResultSet rs = ps.executeQuery();
		List<Dept> depts = new ArrayList<Dept>();
		while(rs.next()) {
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
			
			depts.add(dept);
		}
		DBUtils.close(rs, ps, con);
		return depts;
	}
	public List<Dept> findByName(String name) throws Exception{
		Connection con = DBUtils.getConnection();
			String sql = "select deptno,ename,job,mgr,hiredate,sal,comm,deptno from dept where ename like concat('%',name,'%')";
			PreparedStatement ps = con.prepareStatement(sql);
			//设置入参
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			List<Dept> depts = new ArrayList<Dept>();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setLoc(rs.getString(3));
				
				depts.add(dept);
			}
			DBUtils.close(rs, ps, con);
			return depts;
		}


	
	public int insert(Dept dept) throws Exception {
		Connection con = DBUtils.getConnection();
		String sql = "insert into dept(dname,loc,deptno) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dept.getDname());
		ps.setString(2, dept.getLoc());
		ps.setInt(3, dept.getDeptno());
		int result = ps.executeUpdate();
		DBUtils.close(null, ps, con);
		return result;
	}
	public  void addBatch(List<Dept> depts) throws Exception {
		long start=System.currentTimeMillis();
		Connection con=DBUtils.getConnection();
		Statement s=con.createStatement();
		for(Dept dept:depts) {
			String sql="insert into dept(deptno,dname,loc)values ("+dept.getDeptno()+",'"+dept.getDname()+"','"+dept.getLoc()+"')";
		s.addBatch(sql);
		}
		int[]rows=s.executeBatch();
		System.out.println(rows.toString());
		System.out.println(System.currentTimeMillis()-start);
	
}
	
	public int delete(Dept dept) throws Exception {
		Connection con = DBUtils.getConnection();
		String sql = "delete from dept where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dept.getDeptno());
		int result = ps.executeUpdate();
		DBUtils.close(null, ps, con);
		return result;
	}
	
	public int update(Dept dept) throws Exception {
		Connection con = DBUtils.getConnection();
		String sql = "update dept set dname=?,loc=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dept.getDname());
		ps.setString(2, dept.getLoc());
		
		int result = ps.executeUpdate();
		DBUtils.close(null, ps, con);
		return result;
	}
	
	public Dept findById(Integer id) throws Exception {
		Dept dept = null;
		Connection con = DBUtils.getConnection();
		String sql = "select deptno,dname,loc from dept where deptno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			dept = new Dept();
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
			
		}
		DBUtils.close(rs, ps, con);	
		return dept;
	}
	
	

	
	
}
