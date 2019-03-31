/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static view.View.WIDTH;
import static view.View.HEIGHT;

/**
 *
 * @author Ayan
 */

public class LoginView extends View {
	private LoginView() {
		
	}
	private static LoginView loginView = new LoginView();
	
	public static LoginView getInstance() {
		return loginView;
	}
	
	@Override
	public Scene getScene() {
		return super.getScene("Login.fxml", 900, 500);
	}

}