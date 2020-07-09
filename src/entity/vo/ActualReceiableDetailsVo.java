package entity.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ActualReceiableDetailsVo {//实收
	private String channelBn;
	private String salesName;
	private Date receivableDt;
	private String receivableDemo;//备注
	private String receivableCertificate;//凭证
	private BigDecimal receivableMoney;//实收金额
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ActualReceiableDetailsVo(String channelBn, String salesName, Date receivableDt, String receivableDemo,
			String receivableCertificate, BigDecimal receivableMoney, String id) {
		super();
		this.channelBn = channelBn;
		this.salesName = salesName;
		this.receivableDt = receivableDt;
		this.receivableDemo = receivableDemo;
		this.receivableCertificate = receivableCertificate;
		this.receivableMoney = receivableMoney;
		this.id = id;
	}
	public String getChannelBn() {
		return channelBn;
	}
	public void setChannelBn(String channelBn) {
		this.channelBn = channelBn;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	public Date getReceivableDt() {
		return receivableDt;
	}
	public void setReceivableDt(Date receivableDt) {
		this.receivableDt = receivableDt;
	}
	public String getReceivableDemo() {
		return receivableDemo;
	}
	public void setReceivableDemo(String receivableDemo) {
		this.receivableDemo = receivableDemo;
	}
	public String getReceivableCertificate() {
		return receivableCertificate;
	}
	public void setReceivableCertificate(String receivableCertificate) {
		this.receivableCertificate = receivableCertificate;
	}
	public BigDecimal getReceivableMoney() {
		return receivableMoney;
	}
	public void setReceivableMoney(BigDecimal receivableMoney) {
		this.receivableMoney = receivableMoney;
	}
	public ActualReceiableDetailsVo(String channelBn, String salesName, Date receivableDt, String receivableDemo,
			String receivableCertificate, BigDecimal receivableMoney) {
		this.channelBn = channelBn;
		this.salesName = salesName;
		this.receivableDt = receivableDt;
		this.receivableDemo = receivableDemo;
		this.receivableCertificate = receivableCertificate;
		this.receivableMoney = receivableMoney;
	}
	public ActualReceiableDetailsVo() {
	}
	@Override
	public String toString() {
		return "ActualReceiableDetailsVo [channelBn=" + channelBn + ", salesName=" + salesName + ", receivableDt="
				+ receivableDt + ", receivableDemo=" + receivableDemo + ", receivableCertificate="
				+ receivableCertificate + ", receivableMoney=" + receivableMoney + ", id=" + id + "]";
	}
	
	}
