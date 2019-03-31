/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.AlertMaker;
import entity.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import main.DataAccess;

/**
 *
 * @author Ayan
 */
public class BookDAOimpl {
    public BookDAOimpl() {
             loadList();}
    
    private static BookDAOimpl bookDAO = new BookDAOimpl();
         
    private  String cdr = System.getProperty("user.dir");
    private   String bookDir = cdr + "/src/entity/Book.xls";
            
    ArrayList<Book> listOfBook; 
   
        public static BookDAOimpl getInstance() {
		return bookDAO;
            }
        
        public void loadList(){
            try {
             listOfBook = DataAccess.getBookList(bookDir);
             } catch (IOException e) {
            e.printStackTrace();
              }
       }
        
        
        public String bookPath(){
            return bookDir;
        }
        
        
        
	public ArrayList<Book> getAll() {  
            
              ArrayList<Book> list = new ArrayList<Book>();
               for(int i=0; i<listOfBook.size() ;i++)
                          list.add(listOfBook.get(i));
		
		return list;
	}
             
        
        
       public void save(ArrayList<Book> list) throws IOException{
                     DataAccess.updateDatabase(bookDir,list);
         }
      
       
       
       
      public void addBook(Book book) throws IOException {
		if (listOfBook == null) {
			listOfBook = new ArrayList<Book>();
		}
		boolean exist = false;
		for (Book b : listOfBook) {
			if (b.getISBNstring().equals(book.getISBNstring())) {
				exist = true;
                                AlertMaker.showErrorMessage("Book already exists", "try another ISBN");
			}
		}
		if (!exist) {
			listOfBook.add(book);
			DataAccess.updateDatabase(bookDir,listOfBook);
		}
	}
      
      public void deleteBook(Book book) throws Exception{
                        listOfBook.remove(book);
			DataAccess.updateDatabase(bookDir,listOfBook);
      }
}
