package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	public static ComboPooledDataSource dataSource;
	public static ComboPooledDataSource dataSource1;
	static{
		dataSource = new ComboPooledDataSource("test_c3p0");
	}
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}
	static{
		dataSource1 = new ComboPooledDataSource("test");
	}
	public static Connection getConnection1() throws Exception {
		return dataSource1.getConnection();
	}
	public static Connection getConnection(String url,String user,String pw) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


	public static void close(ResultSet rs, Statement ps, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
