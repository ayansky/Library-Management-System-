/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import controller.Sorting;
import java.util.ArrayList;

public class Book {
	
    private int id;
    private String author;
    private String title;
    private String year;
    private String[] ISBN; //to solve the issue of multiple ISBNstring
    private String publisher;
    private String LLC;
    private String ISBNstring;
    private String stock;

    public Book() {
	    //no-arg constructor
    }
    	

    public Book(int id, String author, String title, String year, String[] ISBN, String ISBNstring, String publisher, String LLC, String stock) {
    	//BookDAO bookDAO = BookDAO.getInstance();
       // ArrayList<Book> books = bookDAO.getAll();
        this.id = id;//books.get(books.size()-1).getId()+1;
    	this.author = author;
    	this.title = title;
    	this.year = year;
    	this.ISBN = ISBN;
    	this.ISBNstring = ISBNstring;
    	this.publisher = publisher;
    	this.LLC = LLC;
    	this.stock = stock;
    	Sorting.arr_author.add(author);
    	Sorting.arr_title.add(title);
    	Sorting.arr_year.add(year);
    	Sorting.arr_publisher.add(publisher); 
        Sorting.arr_ISBN_string.add(ISBNstring);
    	//Sorting.arr_stock.add(stock);
    	Sorting.arr_LLC.add(LLC);
    }
    
    
/**
 * @return the id
 */
    public int getId() {
        return id;
    }
    
/**
 * @param id the id to set
 */
    public void setId(int id) {
    	   this.id = id;
    }
/**
 * @return the author
 */
    public String getAuthor() {
        return author;
    }

/**
 * @param author the author to set
 */
    public void setAuthor(String author) {
        this.author = author;
        Sorting.arr_author.add(author);
    }

/**
 * @return the title
 */
    public String getTitle() {
        return title;
    }

/**
 * @param title the title to set
 */
    public void setTitle(String title) {
        this.title = title;
        Sorting.arr_title.add(title);
    }

/**
 * @return the year
 */
    public String getYear() {
        return year;
        
    }
    
/**
 * @param year the year to set
 */

    public void setYear(String year) {
        this.year = year;
        Sorting.arr_year.add(year);
    }

/**
 * @return the ISBNstring
 */
    public String[] getISBN() {
        return ISBN;
    }

/**
 * @param ISBNstring the ISBNstring to set
 */
    public void setISBN(String[] ISBN) {
        this.ISBN = ISBN; 
    	/*for(int i = 0; i < ISBN.length; i++) {
	        Sorting.arr_ISBN.add(ISBN[i]); //CAREFUL DUNNO TO WHICH BOOK IT BELONGS   
    	    Sorting.arr_ISBN_index.add(i);
        }    */
    }
    
    public String getISBNstring() {
    	return ISBNstring;
    }
    
    public void setISBNstring(String ISBNstring) {
    	this.ISBNstring = ISBNstring;
        Sorting.arr_ISBN_string.add(ISBNstring);
        
    }
 
/**
 * @return the publisher
 */
    public String getPublisher() {
        return publisher;
    }

/**
 * @param publisher the publisher to set
 */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
        Sorting.arr_publisher.add(publisher);
    }

/**
 * @return the LLC
 */
    public String getLLC() {
        return LLC;
        
    }

/**
 * @param LLC the LLC to set
 */
    public void setLLC(String LLC) {
        this.LLC = LLC;
        Sorting.arr_LLC.add(LLC);
    }

/**
 * @return the stock
 */
    public String getStock() {
        return stock;
    }


/**
 * @param stock the stock to set
 */
    public void setStock(String stock) {
        this.stock = stock;
    }
    
    public void printBook() {
		System.out.print(id + " "+ author + " "+title + " "+year + " ");
		for (int j = 0; j<ISBN.length; j++) {
			System.out.print(ISBN[j] + " ");
		}
		System.out.print(publisher + " "+ LLC + " "+ stock);
		System.out.println();
	}
    
}
