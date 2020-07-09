package entity;

import java.math.BigDecimal;

public class AnnualSalVo {
private int empno;
private String ename;
private String dname;
private BigDecimal annual_sal;
public AnnualSalVo(int empno, String ename, String dname, BigDecimal annual_sal) {
	super();
	this.empno = empno;
	this.ename = ename;
	this.dname = dname;
	this.annual_sal = annual_sal;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public BigDecimal getAnnual_sal() {
	return annual_sal;
}
public void setAnnual_sal(BigDecimal annual_sal) {
	this.annual_sal = annual_sal;
}
@Override
public String toString() {
	return "AnnualSalVo [empno=" + empno + ", ename=" + ename + ", dname=" + dname + ", annual_sal=" + annual_sal + "]";
}
}
