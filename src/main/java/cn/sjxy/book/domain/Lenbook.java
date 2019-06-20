package cn.sjxy.book.domain;


import java.util.Date;

public class Lenbook{

	private Integer leid;
	private Integer bid;
	private String mid;
	private Date credate;
	private Date retdate;
	public Integer getLeid() {
		return leid;
	}
	public void setLeid(Integer leid) {
		this.leid = leid;
	}
	
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	public Date getRetdate() {
		return retdate;
	}
	public void setRetdate(Date retdate) {
		this.retdate = retdate;
	}
	@Override
	public String toString() {
		return "Lenbook [leid=" + leid + ", bid=" + bid + ", mid=" + mid + ", credate=" + credate + ", retdate="
				+ retdate + "]";
	}
	
	
	
}
