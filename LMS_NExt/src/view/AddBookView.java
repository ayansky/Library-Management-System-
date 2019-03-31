/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AddBookController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static view.View.WIDTH;
import static view.View.HEIGHT;

/**
 *
 * @author Ayan
 */

public class AddBookView  extends View{
	
	private AddBookView() {
		
	}
	
	private static AddBookView book = new AddBookView();
	
	public static AddBookView getInstance() {
		return book; 
	}
	
	@Override
	public Scene getScene() {
		return super.getScene("AddBookView.fxml", WIDTH, HEIGHT);
	}
        
        public void newScene() throws IOException{
    		Stage primaryStage1 = new Stage();
    		FXMLLoader loader1 = new FXMLLoader();
    		Pane root1 = loader1.load(getClass().getResource("AddBookView.fxml").openStream());
    		AddBookController adc = loader1.getController();
	        Scene scene = new Scene(root1,400,500);
                primaryStage1.setScene(scene);
                primaryStage1.show();
        }

}

