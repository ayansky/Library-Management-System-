/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.Context;
import dao.impl.PersonDAOImpl;
import entity.Person;
import entity.Role;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.BookListView;
import view.DashBoardView;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class AddMemberController extends Controller {
    
    private PersonDAOImpl personDA = PersonDAOImpl.getInstance();
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField memberId;
    @FXML
    private PasswordField password;
    @FXML
    private TextField confirm;
    @FXML
    private Label messageLabel;
    @FXML
    private Button saveMember;
    @FXML
    private Button cancel;
    
    
    
    
   @Override
	public void prepareUI() {
	}

    @FXML
    private void saveMember(ActionEvent event) throws IOException {
		if (validInputs()) {
			Person member = new Person();
			member.setId(Integer.parseInt(memberId.getText()));
			member.setFirstName(firstname.getText());
			member.setLastName(lastname.getText());
                        member.setPassword(password.getText());
			List<Role> roles = new ArrayList<Role>();
			roles.add(Role.MEMBER);
			member.setRoles(roles);
			personDA.addPerson(member);
                         Stage stage = (Stage) saveMember.getScene().getWindow();
                        stage.close();
                        Context.getInstance().changeScreen(event, BookListView.getInstance());
			Context.getInstance().changeScreen(event, DashBoardView.getInstance());
		}
	}

	private boolean validInputs() {
		boolean valid = true;
		messageLabel.setVisible(!valid);
		if (firstname.getText().isEmpty() || lastname.getText().isEmpty() || password.getText().isEmpty()
                        || confirm.getText().isEmpty()|| memberId.getText().isEmpty()) {
			messageLabel.setText("Please enter mandatory fields!");
			messageLabel.setVisible(true);
			valid = false;
		} 
                if (!memberId.getText().isEmpty() || !firstname.getText().isEmpty() || !lastname.getText().isEmpty()){
                    if(password.getText() == null ? confirm.getText() != null : !password.getText().equals(confirm.getText())){
                        messageLabel.setText("Password confirmation failed!");
			messageLabel.setVisible(true);
			valid = false;
                    }
                if(!firstname.getText().isEmpty() || !lastname.getText().isEmpty() || !password.getText().isEmpty()
                        || !confirm.getText().isEmpty()|| !memberId.getText().isEmpty()){
                    boolean isPresent =PersonDAOImpl.getInstance().searchID(memberId.getText());
                   if(isPresent){
                        messageLabel.setText("Choose another ID number!");
			messageLabel.setVisible(true);
                       valid = false;
                   }
                }
	}
        return valid;
    }

    @FXML
    private void cancelAdd(ActionEvent event) {
         Stage stage = (Stage) cancel.getScene().getWindow();
                stage.close();
                Context.getInstance().changeScreen(event, BookListView.getInstance());
    }
        
    }
