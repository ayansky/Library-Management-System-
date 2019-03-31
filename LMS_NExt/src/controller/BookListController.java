/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import context.AlertMaker;
import context.Context;
import dao.impl.BookDAOimpl;
import entity.Book;
import entity.Role;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.DataAccess;
import view.AddBookView;
import view.AddMemberView;
import view.DashBoardView;
import view.LoginView;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class BookListController extends Controller {
    
     @FXML
    private AnchorPane BookListView;
    
    @FXML
    private TableColumn<Book, String> author;
    @FXML
    private TableColumn<Book, String> title;
    @FXML
    private TableColumn<Book, String>  year;
    @FXML
    private TableColumn<Book, String> isbn;
    @FXML
    private TableColumn<Book, String> publisher;
    @FXML
    private TableColumn<Book, String> llc;
    @FXML
    private TableColumn<Book, String> stock;
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private Button deleteBook;
    @FXML
    private Button sortButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField searchText;
    @FXML
    private Label userlbl;
    @FXML
    private ComboBox<String> cb;
    @FXML
    private Label userWelcomeLabel;
    @FXML
    private TextField IssueReturn;
    @FXML
    private Button addBook;
    
  
   
    
    @Override
	public void prepareUI() {
		super.prepareUI(); 
                author.setCellValueFactory(new PropertyValueFactory<>("author"));
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		year.setCellValueFactory(new PropertyValueFactory<>("year"));
		isbn.setCellValueFactory(new PropertyValueFactory<>("ISBNstring"));
		publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		llc.setCellValueFactory(new PropertyValueFactory<>("LLC"));
		stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
                bookTable.setEditable(true);
                bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                cb.getItems().addAll("Sort By","Author","Title","Year","ISBN","Publisher","LLC");
                title.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                title.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTitle(t.getNewValue());});
                author.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                author.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAuthor(t.getNewValue());});
                isbn.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                isbn.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setISBNstring(t.getNewValue());});
                year.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                year.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setYear(t.getNewValue());});
                publisher.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                publisher.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPublisher(t.getNewValue());});
                llc.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                llc.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLLC(t.getNewValue());});
                stock.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
                stock.setOnEditCommit((CellEditEvent<Book, String> t) -> {
                ((Book) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStock(t.getNewValue());});
                
                showAllBook();
                if (!Context.getInstance().getUser().getRoles().contains(Role.ADMIN)) {
			addBook.setDisable(true);
			deleteBook.setDisable(true);
			
		}
               
    }    
    
    public static ObservableList<Book> books = FXCollections.observableArrayList();
    
    static ArrayList<Book> list = new ArrayList<Book>();
    public void showAllBook() {
                ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
                ObservableList<Book> data = FXCollections.observableArrayList(listOfBook);
                bookTable.setItems(data);     
                list = new ArrayList<Book>(data);
                    
}
    
    static ObservableList<Book> filtered = FXCollections.observableArrayList();
    boolean ascending_order = true;
    

    @FXML
    private void sortBookEventHandler(MouseEvent event) {
      //  ArrayList<Book> list = new ArrayList<Book>();
       ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
         
         
               Sorting s = new Sorting(list);
               
		filtered.clear();
		String  sorted = cb.getValue();
		if(ascending_order) {
			if(sorted == "Author") {
				s.sortbyAuthor();
				for(int i = 0; i < s.local_bookList.size(); i++) {
					filtered.add(s.local_bookList.get(i));
				}
                               
				bookTable.setItems(filtered);
			}
			else if(sorted == "Title") {
				
				s.sortbytitle();
				for(int i = 0; i < list.size(); i++) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			else if(sorted == "Year") {
				s.sortbyYear();
				for(int i = 0; i < list.size(); i++) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			
			else if(sorted == "Publisher") {
				s.sortbyPublisher();
				for(int i = 0; i < list.size(); i++) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
                        else if(sorted == "ISBN") {
				s.sortbyISBNString();
				for(int i = 0; i < list.size(); i++) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
                        }
			else if(sorted == "LLC") {
				s.sortbyLLC();
				for(int i = 0; i < list.size(); i++) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			else 
				bookTable.setItems(books);	
			ascending_order = false;
		}
		
		
		else {
			if(sorted == "Author") {
				s.sortbyAuthor();
				for(int i = (list.size() - 1); i >= 0; i--) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			else if(sorted == "Title") {
				
				s.sortbytitle();
				for(int i = (list.size() - 1); i >= 0; i--) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			else if(sorted == "Year") {
				s.sortbyYear();
				for(int i = (list.size()- 1); i >= 0; i--) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			
			else if(sorted == "Publisher") {
				s.sortbyPublisher();
				for(int i = (list.size() - 1); i >= 0; i--) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			else if(sorted == "LLC") {
				s.sortbyLLC();
				for(int i = (list.size() - 1); i >= 0; i--) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			}
			else if(sorted == "ISBN") {
				s.sortbyISBNString();
				for(int i = (list.size() - 1); i >= 0; i--) {
					filtered.add(s.local_bookList.get(i));
				}
				bookTable.setItems(filtered);
			
			}
			else 
				bookTable.setItems(books);	
			ascending_order = true;
		}
    }
		
		
			
			
    

    @FXML
    private void deleteBooksEventHandler(MouseEvent event) throws IOException {
        ObservableList<Book> rows, bookList;
        bookList = bookTable.getItems();
        rows = bookTable.getSelectionModel().getSelectedItems();
        
        for(int i=0; i<rows.size();i++){
         bookList.remove(rows.get(i));
         BookDAOimpl.getInstance().getAll().remove(rows.get(i));
        }
      //  list = new ArrayList<Book>(bookList);
        //DataAccess.updateDatabase(bookDir,BookDAOimpl.getInstance().getAll());
        //BookDAOimpl.getInstance().save();
    }
    
    public void GetUser(String user) {
		userlbl.setText(user);
	}
    static ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
    @FXML
    private void searchBookEventHandler(ActionEvent event) throws Exception {
                filtered.clear();
                Sorting s = new Sorting(list);
		String search = searchText.getText();
             //   ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
                ObservableList<Book> data = FXCollections.observableArrayList(listOfBook);
                try{	if(!search.isEmpty()){
				
                     Searching bs = new Searching(search);
                    int[][] priority = s.sort(bs.searchGlobal());
                    for(int i = 0; i < priority[0].length; i++) {
			filtered.add(data.get(priority[0][i]));}
			bookTable.setItems(filtered);}
                else{
                    showAllBook();
                }
			} catch(Exception e) {
                            
                            AlertMaker.showErrorMessage("Search Fault", "Could not find requested book");
	   }
    }

  
    @FXML
    private void AddBook(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow();
         AddBookView.getInstance().newScene();
    }
    
     private  String cdr = System.getProperty("user.dir");
     private   String bookDir = cdr + "/src/entity/Book.xls";
    
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
          
         DataAccess.updateDatabase(bookDir,list);
        Context.getInstance().changeScreen(event, LoginView.getInstance());
       
         
    }

    @FXML
    private void back(ActionEvent event) {
         Context.getInstance().changeScreen(event, DashBoardView.getInstance());
    }

    @FXML
    private void returnBook(ActionEvent event) {
        
            String isbn = IssueReturn.getText();
            Sorting s = new Sorting(list);
            s.sortbyISBN();
            Searching search = new Searching(isbn, s.arr_sorted);
            int book_id = search.SearchISBN(0,s.arr_sorted.size() - 1);
            int stock = Integer.parseInt(BookDAOimpl.getInstance().getAll().get(book_id).getStock());
            BookDAOimpl.getInstance().getAll().get(book_id).setStock(Integer.toString(stock++));
            String title="Status";
            String mes="Successfully returned";
            AlertMaker.showMessage(title, mes );
            ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
            ObservableList<Book> data = FXCollections.observableArrayList(listOfBook);
            bookTable.setItems(data);    
            //bookTable.refresh();
            
}
    

    @FXML
    private void issueBook(ActionEvent event) {
        
    String isbn = IssueReturn.getText();
    String elect="electronic";
    String elect1="ebook";
    Sorting s = new Sorting(list);
    s.sortbyISBNString();
    Searching search = new Searching(isbn, s.arr_sorted);
    System.out.print("Succsess");
    int book_id = search.SearchISBN(0,s.arr_sorted.size() - 1);
    int stock = Integer.parseInt(BookDAOimpl.getInstance().getAll().get(book_id).getStock());
    System.out.println(stock);
    if((isbn.toLowerCase().contains(elect))||(isbn.toLowerCase().contains(elect1))) {
     String title="Out of books";
        String mes="Sorry, there is no such book left in the Library!";
   
        AlertMaker.showMessage(title, mes );}
      if(stock > 0){
        String title="Status";
        String mes="Succsessfully borrowed!";
   
        AlertMaker.showMessage(title, mes );
      
    System.out.print("SuccsessURA");
    BookDAOimpl.getInstance().getAll().get(book_id).setStock(Integer.toString(stock - 1));
    System.out.print("SuccsessURA1");
    
    bookTable.refresh();
    
    }
    else {
        String title="This book is of e-type";
        String mes=isbn + " is an ebook! Approach librerian to have access!";
   
        AlertMaker.showMessage(title, mes );
}
      
      ArrayList<Book> listOfBook = BookDAOimpl.getInstance().getAll(); 
            ObservableList<Book> data = FXCollections.observableArrayList(listOfBook);
            bookTable.setItems(data); 
    }
    
    

  
    
    
    
    
}