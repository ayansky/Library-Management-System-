import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Library {

	private String name;
	private Books[] booksList; //aggregation
	
	public Books getBooks(int k) {
		return booksList[k];
	}
	public int getBooksNumber() {
		return booksList.length;
	}
	
	public Library(String name, String path) throws IOException 
	{
		InputStream excelFile = new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(excelFile); //creating a workbook out of an excel file

		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		//iterator that will go through the sheet row by row
		Iterator rowsIterator = sheet.rowIterator();

		//counter will tell the number of books in the database (lines - 1, hence initliazed to -1)
		int counter = -1;
		while (rowsIterator.hasNext()) {
			rowsIterator.next();
			counter++;
		}
		
		//create an array of Books of size counter
		booksList = new Books[counter];
		
		//"rewind" the iterator to the beginning of the file
		rowsIterator = sheet.rowIterator();
		
		//skip the first line with headers (author, title...)
		
		rowsIterator.next();
		int k = 0; //counter
		
		while (rowsIterator.hasNext())
		{
			row=(HSSFRow) rowsIterator.next();
			//iterator that will go through the row cell by cell
			Iterator cellsIterator = row.cellIterator();
			
			//creating new book that corresponds to a new row
			booksList[k] = new Books();
			int i = 0; //counter 
			
			while (cellsIterator.hasNext())
			{
				cell=(HSSFCell) cellsIterator.next(); //get what is written in the cell
				
				//first column is the ID
				if (i==0) {
					booksList[k].setId(Integer.parseInt(cell.getStringCellValue()));
				}
				
				//second column is the author
				if (i==1) {
					booksList[k].setAuthor(cell.getStringCellValue());
				}
				
				//third column if the title
				if (i==2) {
					booksList[k].setTitle(cell.getStringCellValue());
				}
				
				//fourth column is the year. Some "year" cells have non-numeric characters
				if (i==3) {
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
					{
						String buffer = cell.getStringCellValue();
						buffer = buffer.replaceAll("[^0-9]", ""); //non-numeric characters removed
						buffer = buffer.trim(); //white spaces removed
						booksList[k].setYear(Integer.parseInt(buffer)); //saved as an integer
					}
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
					{
						booksList[k].setYear((int)cell.getNumericCellValue());
					}
					
					
				}
				
				//fifth column is ISBN
				if (i==4) {
					
					String buffer = cell.getStringCellValue();
					String[] ISBN = buffer.split("[ ]"); //split the string and form the array
					for (int j = 0; j<ISBN.length; j++) {
						ISBN[j] = ISBN[j].replaceAll("[^0-9 ]", ""); //remove all non-numeric characters
																	 //the non-numeric array elements become null
					}
					
					//filter the array to remove all null elements
					ISBN = Arrays.stream(ISBN).filter(s -> !s.isEmpty()).toArray((String[]::new));
															
					booksList[k].setISBN(ISBN);					
				}
				
				//sixth column is the publisher				
				if (i==5) {
					booksList[k].setPublisher(cell.getStringCellValue());
				}
				
				//seventh column is the LLC
				if (i==6) {
					booksList[k].setLLC(cell.getStringCellValue());
				}
				
				//eigth column is the number in stock
				if (i==7) {
					booksList[k].setStock((int)cell.getNumericCellValue());
				}
				
				i++; //move to the next cell
				
			}
			k++; //move to the next row
		}
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
