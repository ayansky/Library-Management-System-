/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.LoginView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Login2  extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Library System");
		primaryStage.setResizable(false);
		primaryStage.setScene(LoginView.getInstance().getScene());
		primaryStage.show();
	}
}
    
