package entity.vo;

import java.math.BigDecimal;

public class AccountsReceivableMgVo {
	private String channel;
	private String sales;
	private BigDecimal accountsReceivable;
	private BigDecimal actualReceivable;
	private String status;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	public AccountsReceivableMgVo(String channel, String sales, BigDecimal accountsReceivable,
			BigDecimal actualReceivable, String status, String id) {
		this.channel = channel;
		this.sales = sales;
		this.accountsReceivable = accountsReceivable;
		this.actualReceivable = actualReceivable;
		this.status = status;
		this.id = id;
	}
	public AccountsReceivableMgVo(String channel, String sales, BigDecimal accountsReceivable, BigDecimal actualReceivable,
			String status) {
		this.channel = channel;
		this.sales = sales;
		this.accountsReceivable = accountsReceivable;
		this.actualReceivable = actualReceivable;
		this.status = status;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public BigDecimal getAccountsReceivable() {
		return accountsReceivable;
	}
	public void setAccountsReceivable(BigDecimal accountsReceivable) {
		this.accountsReceivable = accountsReceivable;
	}
	public BigDecimal getActualReceivable() {
		return actualReceivable;
	}
	public void setActualReceivable(BigDecimal actualReceivable) {
		this.actualReceivable = actualReceivable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AccountsReceivableMgVo() {
	}
	@Override
	public String toString() {
		return "MainVo [channel=" + channel + ", sales=" + sales + ", accountsReceivable=" + accountsReceivable
				+ ", actualReceivable=" + actualReceivable + ", status=" + status + "]";
	}
	
}
