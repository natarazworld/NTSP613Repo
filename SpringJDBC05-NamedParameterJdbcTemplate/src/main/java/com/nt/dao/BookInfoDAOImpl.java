package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.BookInfo;


@Repository("bookInfoDAO")
public class BookInfoDAOImpl implements IBookInfoDAO {
	private  static final String
	     GET_BOOK_BY_ID="SELECT BOOKID,BOOKNAME,AUTHOR,CATEGORY,PRICE,STATUS FROM BOOKS_INFO WHERE BOOKID=:id"; 
	@Autowired
	private NamedParameterJdbcTemplate npjt; 

	/*@Override
	public BookInfo getBookById(int bookId) {
	        BookInfo info=npjt.queryForObject(GET_BOOK_BY_ID,
	        		                                                       Map.of("id",bookId),
	        		                                                       (rs,rowNum)->{
	        		                                                    	  //copy RS object record to  Model class obj
	        		                                                    	   BookInfo binfo=new BookInfo();
	        		                                                    	   binfo.setBookId(rs.getInt(1));
	        		                                                    	   binfo.setBookName(rs.getString(2));
	        		                                                    	   binfo.setAuthor(rs.getString(3));
	        		                                                    	   binfo.setCategory(rs.getString(4));
	        		                                                    	   binfo.setPrice(rs.getFloat(5));
	        		                                                    	   binfo.setStatus(rs.getString(6));
	        		                                                    	   return binfo;
	        		                                                       } );
		return info;
	}//method
	*/	
	
	@Override
	public BookInfo getBookById(int bookId) {
	        BookInfo info=npjt.queryForObject(GET_BOOK_BY_ID,
	        		                                                       Map.of("id",bookId),
	        		                                                       new BeanPropertyRowMapper<BookInfo>(BookInfo.class));
	    return info;
	}//method
		
	

}
