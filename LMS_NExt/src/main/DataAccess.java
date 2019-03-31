
package main;
import entity.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import context.AlertMaker;
import dao.impl.BookDAOimpl;
import entity.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;



public class DataAccess {
	
	static Gson gson = new Gson();
	
	public static void save(Object list, String desternation){
		try (FileWriter writer = new FileWriter(desternation)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static List<Person> getList(String source){
		List<Person> list = new ArrayList<Person>();
		try {
			Reader reader = new FileReader(source);
			list = gson.fromJson(reader, new TypeToken<List<Person>>(){}.getType());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static ArrayList<Book> getBookList(String source) throws IOException
	{     
            ArrayList<Book> bookList = new ArrayList<Book>();
            try{
                
                
		InputStream excelFile = new FileInputStream(source);
		HSSFWorkbook workbook = new HSSFWorkbook(excelFile); //creating a workbook out of an excel file

		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;
		Iterator rowsIterator = sheet.rowIterator();
		rowsIterator.next();
		String author="",title="",publisher="",LLC="",year="",ISBNstring="", stock = "";
		String[] ISBN = null;
		int id = 0;
		String bufferISBN = null;
		while (rowsIterator.hasNext())
		{	
			int i = 0;
			row = (HSSFRow) rowsIterator.next();
			//iterator that will go through the row cell by cell
			Iterator cellsIterator = row.cellIterator();
			while(cellsIterator.hasNext()) {
				cell = (HSSFCell) cellsIterator.next();
				if (i==0) {
                                        if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                                            id = Integer.parseInt(cell.getStringCellValue());
                                        }
                                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                                            id = (int) cell.getNumericCellValue();
                                        }
				}
				if (i==1) {
					if(cell != null)
					    author = cell.getStringCellValue();
					else
						author = null;
				}
				
				if (i==2) {
					title = cell.getStringCellValue();
				}
				
				if (i==3) {
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
					{
						String buffer = cell.getStringCellValue();
						buffer = buffer.replaceAll("[^0-9]", ""); //non-numeric characters removed
						buffer = buffer.trim(); //white spaces removed
						year = buffer; //saved as an integer
					}
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
					{
						year = String.valueOf(cell.getNumericCellValue());
					}	
				}
				
				if (i==4) {
					
					ISBNstring = cell.getStringCellValue();
                                        
                                        
					ISBN = ISBNstring.split(","); //split the string by comma
					//filter the array to remove all null elements
					//ISBN = Arrays.stream(ISBN).filter(s -> !s.isEmpty()).toArray((String[]::new));				
				}
				
				//sixth column is the publisher				
				if (i==5) {
					publisher = cell.getStringCellValue();
				}
				
				//seventh column is the LLC
				if (i==6) {
					if(cell != null)
					    LLC = cell.getStringCellValue();
					else
						LLC = null;
				}
				
				//eighth column is the number in stock
				if (i==7) {
                                       
                                         if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                                             
                                            stock = cell.getStringCellValue();
                                        }
                                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                                             
                                            stock = String.valueOf((int)cell.getNumericCellValue());
                                            
                                        }
				
				}	
				i++; //move to the next cell
			}			
			//Book nb = new Book(id,author,title,year,ISBN, publisher,LLC,stock);
			//nb.setISBN(ISBN);
		    bookList.add(new Book(id,author,title,year,ISBN,ISBNstring,publisher,LLC,stock));
		}	
                workbook.close();
	}
        catch (FileNotFoundException e) {
                        AlertMaker.showErrorMessage("Data not found", " Excel fault");
			e.printStackTrace();
		}
        return bookList;
        }
        
        
	public static void updateDatabase (String path, ArrayList<Book> List) throws IOException{
		
            try{
                InputStream excelFile = new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(excelFile); 
		HSSFSheet sheet = workbook.getSheetAt(0);
	
		String[] columns = {"#", "Author", "Title", "Year", "ISBN", "Publisher", "LLC", "Stock"};
		Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 10);
	        headerFont.setColor(IndexedColors.BLACK.getIndex());
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);
	   
	        HSSFRow headerRow = sheet.createRow(0);
	        
                HSSFCell cell;
	        for(int i = 0; i < columns.length; i++) {
	        	
	        	 cell = headerRow.getCell(i);
	        	
	        	if (cell == null) {
	        	cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);}}
	        //int booksNumber=List.size();
              //  System.out.println(booksNumber);
	        int rowNum = 1;
	        
	        for(Book book: List) {

                      HSSFRow row = sheet.createRow(rowNum++);
	      
                     row.createCell(0).setCellValue(rowNum);	          

	            row.createCell(1).setCellValue(book.getAuthor());
	                    		           
	            row.createCell(2).setCellValue(book.getTitle());
	                 
	            row.createCell(3).setCellValue(book.getYear());
                        
	            row.createCell(4).setCellValue(book.getISBNstring());
                
	            row.createCell(5).setCellValue(book.getPublisher());
                
	            row.createCell(6).setCellValue(book.getLLC());
                    row.createCell(7).setCellValue(book.getStock());
	            
                }
	        for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }
	        FileOutputStream fileOut = new FileOutputStream(path);
	        workbook.write(fileOut);
	        fileOut.close();

	       
	        workbook.close();
            }   
               catch (FileNotFoundException e) {
                        AlertMaker.showErrorMessage("Data not found", " Excel fault");
			e.printStackTrace();
		}
	}
        
        
}
