/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import context.Context;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import view.AboutView;
import view.AddMemberView;
import view.BookListView;
import view.DashBoardView;
import view.LoginView;
import view.MemberListView;

/**
 * FXML Controller class
 *
 * @author Ayan
 */
public class DashboardController extends Controller {

    @FXML
    private Label userWelcomeLabel;

    
    
   @Override
	public void prepareUI() {
            super.prepareUI();;
	}



    @FXML
    private void BookList(ActionEvent event) {
        Context.getInstance().changeScreen(event, BookListView.getInstance());
    }


    @FXML
    private void memberList(ActionEvent event) {
        Context.getInstance().changeScreen(event, MemberListView.getInstance());
    }

    @FXML
    private void about(ActionEvent event) {
        Context.getInstance().changeScreen(event, AboutView.getInstance());
    }


    @FXML
    private void logout(ActionEvent event) {
          Context.getInstance().changeScreen(event, LoginView.getInstance());
    }

}
