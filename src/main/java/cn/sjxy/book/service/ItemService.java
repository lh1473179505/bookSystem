package cn.sjxy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.book.dao.ItemMapper;
import cn.sjxy.book.domain.Item;


@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class ItemService {

	@Autowired
	private ItemMapper iMapper;

	
	
	public ItemMapper getiMapper() {
		return iMapper;
	}



	public void setiMapper(ItemMapper iMapper) {
		this.iMapper = iMapper;
	}



	public void addItem(Item item) {
		iMapper.saveItem(item);
	}
	
	@Transactional(readOnly=true)
	public List<Item> selectAll(){
		return iMapper.findAll();
	}
	
	public void delete(Integer iid) {
		iMapper.deleteItem(iid);
	}
	
	
}
