package cn.sjxy.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.book.dao.BooksMapper;
import cn.sjxy.book.domain.Books;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class BooksService {

	@Autowired
	
	private BooksMapper bMapper;

	public BooksMapper getbMapper() {
		return bMapper;
	}

	public void setbMapper(BooksMapper bMapper) {
		this.bMapper = bMapper;
	}
	
	public void saveBook(Books books) {
		bMapper.insertBook(books);
	}
	
	
	public List<Books> selectB(){
		return bMapper.findAll();
	}
	
	
	public void deleteB(Integer bid) {
		bMapper.deleteBooks(bid);
	}
	
	
}
