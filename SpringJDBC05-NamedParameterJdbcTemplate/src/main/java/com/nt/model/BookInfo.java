package com.nt.model;

import lombok.Data;

@Data
public class BookInfo {
   private Integer bookId;
   private String bookName;
   private String category;
   private String author;
   private Float price; 
   private String status;
}
