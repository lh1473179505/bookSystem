package cn.sjxy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.book.dao.LenbookMapper;
import cn.sjxy.book.domain.Lenbook;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class LenbookService {

	@Autowired
	private LenbookMapper lenbookMapper;
	


	
	public LenbookMapper getLenbookMapper() {
		return lenbookMapper;
	}




	public void setLenbookMapper(LenbookMapper lenbookMapper) {
		this.lenbookMapper = lenbookMapper;
	}




	public void addLenbook(Lenbook lenbook) {
		lenbookMapper.save(lenbook);
	}
	
	
	@Transactional(readOnly=true)
	public List<Lenbook> select(){
		return lenbookMapper.findAll();
	}
	
	
	public void updateL(Integer leid) {
		lenbookMapper.updateByRetdate(leid);
	}
	
	
}
