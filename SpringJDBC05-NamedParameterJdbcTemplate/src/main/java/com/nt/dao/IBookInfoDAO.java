package com.nt.dao;

import java.util.List;

import com.nt.model.BookInfo;

public interface IBookInfoDAO {
    public  BookInfo  getBookById(int bookId);
    public  List<BookInfo> getBooksByCategory(String category1,String category2,String category3);
    public  int  insert(BookInfo info);
}
