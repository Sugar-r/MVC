package common;

public enum ResultEnum {
	ERROR_USER_IS_NULL(101,"error:用户名不能为空"),
	ERROR_PASSWORD_IS_NULL(102,"error:密码不能为空"),
	ERROR_PASSWORD_lENGTH_LIMIT(103,"error:密码必须大于等于5位"),
	ERROR_DAO_SQL_EXCEPTION(104,"error:数据库操作异常"),
	ERROR_LOGIN(105,"error:登录失败，检查用户名及密码"),
	ERROR_LOGIN_EXCEPTION(106,"error:登录异常"),
	RESULT_SUCCESS(200,"success:执行成功"),
	SUCCESS_LOGIN(201,"success:登录成功");
	
String msg; 
int code;
	
	private ResultEnum( int code,String msg) {
	this.msg = msg;
	this.code = code;
}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
