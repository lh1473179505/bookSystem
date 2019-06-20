package cn.sjxy.book.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Books implements Serializable{

	private Integer bid;
	private String name;
	private Date credate;
	private Integer status;
	private String note;
	private Integer iid;
	private String aid;
	private List<Lenbook> Lenbook;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public List<Lenbook> getLenbook() {
		return Lenbook;
	}
	public void setLenbook(List<Lenbook> lenbook) {
		Lenbook = lenbook;
	}
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", name=" + name + ", credate=" + credate + ", status=" + status + ", note=" + note
				+ ", iid=" + iid + ", aid=" + aid + ", Lenbook=" + Lenbook + "]";
	}
	
	
}
