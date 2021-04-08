package com.nt.service;

import com.nt.model.BookInfo;

public interface IBookStoreMgmtService {
    public BookInfo  fetchBookById(int bookId);
}
