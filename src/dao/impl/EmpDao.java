package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import entity.User;

import dao.idao.IEmpDao;
import entity.Dept;
import entity.Emp;
import util.DBUtils;

public class EmpDao implements IEmpDao{
	public List<Emp> findAll() throws Exception{
	Connection con = DBUtils.getConnection1();
		String sql = "select empno,ename,job,mgr,hiredate,sal,deptno from emp1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Emp> emps = new ArrayList<Emp>();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));
			
			emp.setDeptno(rs.getInt(7));
			emps.add(emp);
		}
		DBUtils.close(rs, ps, con);
		return emps;
	}
	public Emp findById(Integer id) throws Exception {
		Emp emp = null;
		Connection con = DBUtils.getConnection1();
		String sql = "select empno,ename,job,mgr,hiredate,sal,deptno from emp1 where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));
		
			emp.setDeptno(rs.getInt(7));
		}
		DBUtils.close(rs, ps, con);	
		return emp;
	}
	public List<Emp> findByPage(int page,int size) throws Exception{
	Connection con = DBUtils.getConnection();
		String sql = "select empno,ename,job,mgr,hiredate,sal,deptno from emp limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		//设置入参
		ps.setInt(1, (page-1)*size);
		ps.setInt(2, size);
		ResultSet rs = ps.executeQuery();
		List<Emp> emps = new ArrayList<Emp>();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));

			emp.setDeptno(rs.getInt(8));
			emps.add(emp);
		}
		DBUtils.close(rs, ps, con);
		return emps;
	}
	public List<Emp> findByName(String name) throws Exception{
		Connection con = DBUtils.getConnection();
			String sql = "select empno,ename,job,mgr,hiredate,sal,deptno from emp where ename like concat('%',name,'%')";
			PreparedStatement ps = con.prepareStatement(sql);
			//设置入参
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			List<Emp> emps = new ArrayList<Emp>();
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(rs.getDate(5));
				emp.setSal(rs.getBigDecimal(6));
			
				emp.setDeptno(rs.getInt(8));
				emps.add(emp);
			}
			DBUtils.close(rs, ps, con);
			return emps;
		}


	
	public int insert(Emp emp) throws Exception {
		Connection con = DBUtils.getConnection();
		String sql = "insert into emp(ename,job,mgr,hiredate,sal,deptno) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getEname());
		ps.setString(2, emp.getJob());
		ps.setInt(3, emp.getMgr());
		long time = emp.getHiredate().getTime();
		ps.setDate(4,new java.sql.Date(time));
		ps.setBigDecimal(5, emp.getSal());
		
		ps.setInt(7, emp.getDeptno());
		int result = ps.executeUpdate();
		DBUtils.close(null, ps, con);
		return result;
	}

	
	public int delete(Emp emp) throws Exception {
		Connection con = DBUtils.getConnection();
		String sql = "delete from emp where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, emp.getEmpno());
		int result = ps.executeUpdate();
		DBUtils.close(null, ps, con);
		return result;
	}
	
	public int update(Emp emp) throws Exception {
		Connection con = DBUtils.getConnection();
		String sql = "update emp set ename=?,sal=?,hiredate=?,deptno=?,job=?,mgr=?,comm=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getEname());
		ps.setBigDecimal(2, emp.getSal());
		long time = emp.getHiredate().getTime();
		ps.setDate(3, new java.sql.Date(time));
		ps.setInt(4, emp.getDeptno());
		ps.setString(5, emp.getJob());
		ps.setInt(6, emp.getMgr());
		
		int result = ps.executeUpdate();
		DBUtils.close(null, ps, con);
		return result;
	}
	
	
	@Override
	public List<Integer> listNames() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Dept dynamicFindEmp(String s) throws Exception {
//		Connection con=DBUtils.getConnection();
//		Statement st=con.createStatement();
//		StringBuilder sql=new StringBuilder("select id from dept");
//		int str;
//		if(( str=s.indexOf("job"))>0) sql.append(str);
//		return new UserDao().findById(id);
//	}	

	
	
}
