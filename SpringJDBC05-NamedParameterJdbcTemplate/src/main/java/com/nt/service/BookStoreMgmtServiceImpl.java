package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IBookInfoDAO;
import com.nt.model.BookInfo;

@Service("bookService")
public class BookStoreMgmtServiceImpl implements IBookStoreMgmtService {
	@Autowired
	private IBookInfoDAO dao;

	@Override
	public BookInfo fetchBookById(int bookId) {
        //use DAO
		BookInfo info=dao.getBookById(bookId);
		return info;
	}

	@Override
	public List<BookInfo> fetchBooksByCategories(String category1, String category2, String category3) {
		//use DAO
		List<BookInfo> list=dao.getBooksByCategory(category1, category2, category3);
		return list;
	}
	
	@Override
	public String addBook(BookInfo info) {
		//use DAO
		int count=dao.insert(info);
		return count==0?"Registration failed":"Registration succeded";
	}
	
	

}
