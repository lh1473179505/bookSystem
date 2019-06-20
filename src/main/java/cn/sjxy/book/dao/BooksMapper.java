package cn.sjxy.book.dao;

import java.util.List;

import cn.sjxy.book.domain.Books;

public interface BooksMapper {

	public void insertBook(Books books);
	
	public List<Books> findAll();
	
	public Books findById(Integer bid);
	
	public void deleteBooks(Integer bid);
}