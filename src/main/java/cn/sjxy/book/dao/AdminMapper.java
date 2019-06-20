package cn.sjxy.book.dao;


import java.util.List;

import cn.sjxy.book.domain.Admin;

public interface AdminMapper{
	

	
	public void saveAdmin(Admin admin);
	
	public Admin findById(String aid);
	
	public List<Admin> findAll();
}
