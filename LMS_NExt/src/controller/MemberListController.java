/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.Context;
import dao.impl.BookDAOimpl;
import dao.impl.PersonDAOImpl;
import entity.Book;
import entity.Person;
import entity.Role;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import view.AddMemberView;
import view.DashBoardView;
import view.LoginView;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class MemberListController extends Controller {

    @FXML
    private TableView<Person> memberTable;
    @FXML
    private TableColumn<Person, String> id;
    @FXML
    private TableColumn<Person, String> firstname;
    @FXML
    private TableColumn<Person, String> lastname;
    @FXML
    private TextField memberSearch;
    @FXML
    private Label userWelcomeLabel;

    /**
     * Initializes the controller class.
     */
   @Override
	public void prepareUI() {
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
         firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
         lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
         
         memberTable.setEditable(true);
         memberTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         
         showAllMember();
        }
        
       public void showAllMember(){
		List<Person> list = PersonDAOImpl.getInstance().getAll(Role.MEMBER);
		ObservableList<Person> data = FXCollections.observableArrayList(list);
		memberTable.setItems(data);
	}
           
       
    @FXML
    private void searchMember(ActionEvent event) {
           
		String id = memberSearch.getText();
		if (id.isEmpty()) {
			showAllMember();
		} else {
			Person search = PersonDAOImpl.getInstance().search(id, Role.MEMBER);
			ObservableList<Person> data = null;
			if (search != null) {
				List<Person> list = new ArrayList<Person>();
				list.add(search);
				data = FXCollections.observableArrayList(list );
			}
			memberTable.setItems(data);
                }
       }
    

    @FXML
    private void AddMember(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow();
         AddMemberView.getInstance().newMemberScene();
    }

    @FXML
    private void back(ActionEvent event) {
        Context.getInstance().changeScreen(event, DashBoardView.getInstance());
    }

    @FXML
    private void logout(ActionEvent event) {
         Context.getInstance().changeScreen(event, LoginView.getInstance());
    }
    
}
