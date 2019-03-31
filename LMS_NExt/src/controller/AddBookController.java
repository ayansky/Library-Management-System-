/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.Context;
import dao.impl.BookDAOimpl;
import entity.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.DataAccess;
import view.BookListView;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class AddBookController extends Controller{
     
    private BookDAOimpl bookDAO = BookDAOimpl.getInstance();
    
    @FXML
    private TextField author;
    @FXML
    private TextField title;
    @FXML
    private TextField year;
    @FXML
    private TextField isbn;
    @FXML
    private TextField publisher;
    @FXML
    private TextField llc;
    @FXML
    private TextField stock;
    @FXML
    private Button cancel;
    @FXML
    private Button saveBook;
    @FXML
    private Label addStatus;

    @Override
	public void prepareUI() {
	}
       

    @FXML
    private void cancelAddBookEventHandler(ActionEvent event) {
                Stage stage = (Stage) cancel.getScene().getWindow();
                stage.close();
                Context.getInstance().changeScreen(event, BookListView.getInstance());
    }

    @FXML
    private void saveBookEventHandler(ActionEvent event) throws IOException {
                Book book = new Book();
                
                
                if(validInputs()){
                book.setAuthor(year.getText());
		book.setTitle(title.getText());
		book.setISBNstring(isbn.getText());
		book.setYear(year.getText());
                book.setPublisher(publisher.getText());
                book.setStock(stock.getText());
                book.setLLC(llc.getText());
               
                bookDAO.addBook(book);
               /*
                ArrayList<Book> list = new ArrayList<Book>();
                for(int i=0; i<BookDAOimpl.getInstance().getAll().size() ;i++)
                          list.add(BookDAOimpl.getInstance().getAll().get(i));
		
                
                DataAccess.updateDatabase(BookDAOimpl.getInstance().bookPath(),list,list.size());
		*/
                Stage stage = (Stage) saveBook.getScene().getWindow();
                stage.close();
                Context.getInstance().changeScreen(event, BookListView.getInstance());
                  
        }

    }
               
    
    
    private boolean validInputs() {
		boolean valid = true;
		addStatus.setVisible(!valid);
		if(title.getText().isEmpty()||isbn.getText().isEmpty()||stock.getText().isEmpty()){
                       
			addStatus.setText("Please enter mandatory fields!");
			addStatus.setVisible(true);
			valid = false;
		} 
                
	
        return valid;
    }
    
    
    
}
