package cn.sjxy.book.domain;


import java.util.List;

public class Item{

	private Integer iid;
	private String name;
	private String note;
	private List<Books> books;
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", name=" + name + ", note=" + note + ", books=" + books + "]";
	}
	
	
	
}
