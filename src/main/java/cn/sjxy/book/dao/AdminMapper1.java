package cn.sjxy.book.dao;



import cn.sjxy.book.domain.Admin;

public interface AdminMapper1 {

	
	
	
	
	public void updateStatus(Admin admin);
	
	public Admin login(Admin admin);
	
	public void updateTime(String aid);
	
	public void logoutStatus(String aid);
}
