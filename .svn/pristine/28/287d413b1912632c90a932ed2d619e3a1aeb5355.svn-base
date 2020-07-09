package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Product;
import entity.Product;
import util.DBUtils;

public class ProductDao  {

	

	
	public List<Product> findAll() throws Exception {
		QueryRunner qr = new QueryRunner(DBUtils.dataSource);
		String sql = "select id,name,img,power from image";
		Connection con = DBUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Product> products = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setImg(rs.getString(3));
			product.setPower(rs.getInt(4));
			
			products.add(product);
		}
		DBUtils.close(rs, ps, con);
		return products;
	}

	

}
