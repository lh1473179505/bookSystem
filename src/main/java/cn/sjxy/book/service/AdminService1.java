package cn.sjxy.book.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.book.dao.AdminMapper1;
import cn.sjxy.book.domain.Admin;


@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class AdminService1 {

	@Autowired
	private AdminMapper1 adminMapper;
	
	
	public AdminMapper1 getAdminMapper() {
		return adminMapper;
	}


	public void setAdminMapper(AdminMapper1 adminMapper) {
		this.adminMapper = adminMapper;
	}


	
	
	
	
	public void findStatus(Admin admin) {
		adminMapper.updateStatus(admin);
	}
	
	public Admin getLogin(Admin admin) {
		return adminMapper.login(admin);
	}
	
	public void updateTime(String aid) {
		adminMapper.updateTime(aid);
	}
	
	public void logoutStatus(String aid) {
		adminMapper.logoutStatus(aid);
	}
}
