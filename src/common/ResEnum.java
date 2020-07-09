package common;

public enum ResEnum {
	SUCCESS(200,"运行成功"),
	ERROR(500,"服务器内部错误"),
	USER_NOT_EXIST(201,"用户名不存在"),
	USER_EXIST(202,"用户名已存在");
	private int status;
	private String msg;
	private ResEnum(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public String getMsg() {
		return msg;
	}

}
