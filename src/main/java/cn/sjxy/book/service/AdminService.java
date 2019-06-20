package cn.sjxy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.book.dao.AdminMapper;
import cn.sjxy.book.domain.Admin;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class AdminService {

	@Autowired
	private AdminMapper aMapper;
	
	public AdminMapper getaMapper() {
		return aMapper;
	}

	public void setaMapper(AdminMapper aMapper) {
		this.aMapper = aMapper;
	}

	public void insertAdmin(Admin admin) {
		aMapper.saveAdmin(admin);
	}
	
	public Admin findA(String aid) {
		return aMapper.findById(aid);
	}
	
	public List<Admin> selectAll(){
		return aMapper.findAll();
	}
	
	
}
