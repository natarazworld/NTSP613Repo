package com.nt.service;

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

}
