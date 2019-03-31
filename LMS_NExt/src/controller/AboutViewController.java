/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import context.Context;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import view.DashBoardView;
import view.LoginView;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class AboutViewController extends Controller {

    @FXML
    private Label userWelcomeLabel;

 

    @FXML
    private void back(ActionEvent event) {
         Context.getInstance().changeScreen(event, DashBoardView.getInstance());
        
    }

    @FXML
    private void logout(ActionEvent event) {
        Context.getInstance().changeScreen(event, LoginView.getInstance());
    }
    
}
