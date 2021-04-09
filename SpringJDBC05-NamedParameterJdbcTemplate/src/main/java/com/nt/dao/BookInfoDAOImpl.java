package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.BookInfo;


@Repository("bookInfoDAO")
public class BookInfoDAOImpl implements IBookInfoDAO {
	private  static final String
	     GET_BOOK_BY_ID="SELECT BOOKID,BOOKNAME,AUTHOR,CATEGORY,PRICE,STATUS FROM BOOKS_INFO WHERE BOOKID=:id"; 
	private  static final String
    GET_BOOKS_BY_DESGS="SELECT BOOKID,BOOKNAME,AUTHOR,CATEGORY,PRICE,STATUS FROM BOOKS_INFO WHERE CATEGORY IN(:type1,:type2,:type3)  ORDER BY CATEGORY";
	
	private  static final String
    INSERT_BOOKS_INFO_QUERY="INSERT INTO BOOKS_INFO VALUES(BOOKID_SEQ.NEXTVAL,:bookName ,:category,:author,:price,:status)";
	

	
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

	/*	@Override
		public List<BookInfo> getBooksByCategory(String category1, String category2, String category3) {
			//prepare  SqlParameterSource object having named params and values
			MapSqlParameterSource  source=new MapSqlParameterSource();
			source.addValue("type1", category1);
			source.addValue("type2", category2);
			source.addValue("type3", category3);
			List<BookInfo> list=npjt.query(GET_BOOKS_BY_DESGS,
					                                            source,
					                                            rs->{
					                                            	List<BookInfo> list1=new ArrayList();
					                                            	while(rs.next()) {
					                                                  BookInfo binfo=new BookInfo();
			                                                    	   binfo.setBookId(rs.getInt(1));
			                                                    	   binfo.setBookName(rs.getString(2));
			                                                    	   binfo.setAuthor(rs.getString(3));
			                                                    	   binfo.setCategory(rs.getString(4));
			                                                    	   binfo.setPrice(rs.getFloat(5));
			                                                    	   binfo.setStatus(rs.getString(6));
			                                                    	   list1.add(binfo);
					                                            	}//while
					                                            	return list1;
					                                            });
			return list;
		}*/
	
	
	@Override
	public List<BookInfo> getBooksByCategory(String category1, String category2, String category3) {
		//prepare  SqlParameterSource object having named params and values
		MapSqlParameterSource  source=new MapSqlParameterSource();
		source.addValue("type1", category1);
		source.addValue("type2", category2);
		source.addValue("type3", category3);
		List<BookInfo> list=npjt.query(GET_BOOKS_BY_DESGS,
				                                            source,
				                                            new RowMapperResultSetExtractor<BookInfo>(new BeanPropertyRowMapper<BookInfo>(BookInfo.class)));
				                                            
		return list;
	}
	
	@Override
	public int insert(BookInfo info) {
		BeanPropertySqlParameterSource bpsps=new  BeanPropertySqlParameterSource(info);
		int count=npjt.update(INSERT_BOOKS_INFO_QUERY, bpsps);
		return count;
	}
		
	

}
