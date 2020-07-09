package dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtils;


import dao.idao.IReportDao;
import entity.AnnualSalVo;
import entity.ReportVo;

public class ReportDao implements IReportDao{

	public List<AnnualSalVo> selectAnnualSal(String... orderByCons) throws Exception {
		Connection con=DBUtils.getConnection();
		StringBuffer sq=new StringBuffer("select e.empno,e.ename,d.dname,(sal+IFNULL(comm,0))*12 annual_sal   from emp e left join dept d on e.deptno=d.deptno");
		if(orderByCons != null && orderByCons.length >0) {
			sq.append(" order by ");
			for(String s:orderByCons) sq.append(s+",");
		}
		String sql=sq.substring(0,sq.length()-1);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<AnnualSalVo> result = new ArrayList<AnnualSalVo>();
		while(rs.next()) {
			AnnualSalVo asv = new AnnualSalVo(rs.getInt(1),rs.getString(2), rs.getString(3),new BigDecimal( rs.getDouble(4)));
			result.add(asv);
		}
		DBUtils.close(rs, ps, con);
		return result;
		
	}

	public List<ReportVo> selectReport(String yearMonth) throws Exception {
		Connection con=DBUtils.getConnection();
		String sql="select d.dname,avg(e.sal) avgsal,sum(e.sal) sumsal,count(*) num from emp e join dept d on e.deptno=d.deptno where e.hiredate<LAST_DAY(STR_TO_DATE(?,'%Y-%m')) group by e.deptno order by d.dname";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, yearMonth);
		ResultSet rs=ps.executeQuery();
		List<ReportVo> results = new ArrayList<ReportVo>();
		while(rs.next()) {
			ReportVo report = new ReportVo(rs.getString(1), new BigDecimal( rs.getDouble(2)),new BigDecimal( rs.getDouble(3)),rs.getInt(4));
			results.add(report);
		}
		DBUtils.close(rs, ps, con);
		return results;
	}

}
