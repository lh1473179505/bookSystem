package cn.sjxy.book.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Admin implements Serializable{

	private String aid;
	private String password;
	private Date lastdate;
	private Integer flag;
	private Integer status;
	private List<Books> books;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", password=" + password + ", lastdate=" + lastdate + ", flag=" + flag
				+ ", status=" + status + ", books=" + books + "]";
	}
	
	
}
