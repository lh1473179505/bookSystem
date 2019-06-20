package cn.sjxy.book.dao;


import java.util.Date;
import java.util.List;

import cn.sjxy.book.domain.Lenbook;

public interface LenbookMapper {

	public void save(Lenbook lenbook);
	
	public List<Lenbook> findAll();
	
	public void updateByRetdate(Integer leid);
	
	
}
