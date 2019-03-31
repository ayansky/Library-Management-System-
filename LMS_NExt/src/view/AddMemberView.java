/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AddBookController;
import controller.AddMemberController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static view.View.WIDTH;
import static view.View.HEIGHT;

public class AddMemberView extends View {

	/**
	 * This is the private constructor (Singleton Pattern).
	 */
	private AddMemberView() {
	}

	private static AddMemberView addMemberView = new AddMemberView();

	public static AddMemberView getInstance() {
		return addMemberView;
	}

	@Override
	public Scene getScene() {
		return super.getScene("AddMember.fxml", WIDTH, HEIGHT);
	}
        
        
        public void newMemberScene() throws IOException{
    		Stage primaryStage1 = new Stage();
    		FXMLLoader loader1 = new FXMLLoader();
    		Pane root1 = loader1.load(getClass().getResource("AddMember.fxml").openStream());
    		AddMemberController adc = loader1.getController();
	        Scene scene = new Scene(root1,400,500);
                primaryStage1.setScene(scene);
                primaryStage1.show();
        }

}
