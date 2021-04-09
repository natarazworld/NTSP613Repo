package com.nt.service;

import java.util.List;

import com.nt.model.BookInfo;

public interface IBookStoreMgmtService {
    public BookInfo  fetchBookById(int bookId);
    public List<BookInfo> fetchBooksByCategories(String category1,String category2,String category3);
    public String   addBook(BookInfo info);
}
