package cn.sjxy.book.dao;

import java.util.List;

import cn.sjxy.book.domain.Item;

public interface ItemMapper{

	public void saveItem(Item item);
	
	public List<Item> findAll();
	
	public Item findByName();
	
	public void deleteItem(Integer iid) ;
}
