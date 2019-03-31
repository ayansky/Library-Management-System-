/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.BookDAOimpl;
import entity.Book;
import java.util.ArrayList;

/**
 *
 * @author Ayan
 */
public class Searching {
    
	ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
	String key = new String();
	String[] key_arr;
	ArrayList<Book> arr = listOfBook;  
        ArrayList<String>a=new ArrayList<String>();
	int r,l,mid;
	public Searching() {
		
	}
        
		
                
	
	
 	public Searching(String search) {
		this.key = search.trim();
		this.r = arr.size() - 1;
	}
        public Searching(String search, ArrayList<String> a) {
		this.key = search.trim();
		this.a = a;
		this.r = a.size() - 1;
	}
        public int SearchISBN(int l, int r){
                if (r>=l) {
            mid = l + (r-l)/2;
            // If the element is present at the 
            // middle itself
            if (a.get(mid).contains(key))
               return mid;
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (a.get(mid).compareTo(key) > 0)           	
            	return SearchISBN(l,mid - 1);
                       
            // Else the element can only be present
            // in right subarray            
            return SearchISBN(mid + 1,r);
        }
 
        // We reach here when element is not present
        //  in array
        return -1;
    }
    
	public int[][] searchGlobal() {	
		
		int[][] result = new int[2][127];
		int[][] updated = null;
		int iter = 0;
		
		ArrayList<Book> local = new ArrayList<Book>();
		for(String temp : key.split(" ")) {
			iter++;		
			if(iter == 1) {
				int j = 0;
				for(int index = 0; index < listOfBook.size(); index++) {
					int priority = 0;
					Book b = listOfBook.get(index);
					String a = b.getAuthor(), t = b.getTitle(), y = b.getYear(), llc = b.getLLC(), ISBN = b.getISBNstring(), p = b.getPublisher();
					if(a.matches("(?i:." + temp + ".)"))
						priority++;
					if(t.matches("(?i:." + temp + ".)")) 
						priority++;
					if(y.matches("(?i:." + temp + ".)"))
						priority++;
					if(llc.matches("(?i:." + temp + ".)")) 
						priority++;
					if(p.matches("(?i:." + temp + ".)")) 
						priority++;
					if(ISBN.matches("(?i:." + temp + ".)")) 
						priority++;
					if(priority != 0) {
					    local.add(b);					
						result[0][j] = index;
						result[1][j] = priority;						
					}
				    j++;
				}
					
		    }
			else {
				
				int j = 0;
				updated = new int[2][local.size()];
				for(int index = 0; index < local.size(); index++) {
					int priority = 0;
				    Book b = local.get(index);
				    String a = b.getAuthor(), t = b.getTitle(), y = b.getYear(), llc = b.getLLC(), ISBN = b.getISBNstring(), p = b.getPublisher();
					if(a.matches("(?i:." + temp + ".)"))
						priority++;
					if(t.matches("(?i:." + temp + ".)")) 
						priority++;
					if(y.matches("(?i:." + temp + ".)"))
						priority++;
					if(llc.matches("(?i:." + temp + ".)")) 
						priority++;
					if(p.matches("(?i:." + temp + ".)")) 
						priority++;
					if(ISBN.matches("(?i:." + temp + ".)")) 
						priority++;
					if(priority != 0) {
						updated[0][j] = (b.getId() - 1);
						updated[1][j] = priority;
						j++;
					}		
	          } 
           }
       }
	   if(iter > 1) 
		   return updated;		   
	   return result;
	   	
	 }
	
	
    
}