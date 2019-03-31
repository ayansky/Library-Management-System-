/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import context.Context;
import view.DashBoardView;
import entity.Person;
import dao.impl.PersonDAOImpl;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class LoginController extends Controller {
	
	private PersonDAOImpl personDA = PersonDAOImpl.getInstance();
   
    @FXML
    private Label lblLogin;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
	
	@FXML
	private void login(ActionEvent actionEvent) {
		Person person = personDA.login(txtUsername.getText(), txtPassword.getText());
		if (person == null) {
			lblLogin.setText("Invalid username/password");
		} else {
			Context.getInstance().setUser(person);
			//show hide screen
			Context.getInstance().changeScreen(actionEvent, DashBoardView.getInstance());
		}
	}
        
        @Override
	public void prepareUI() {
	}

}

