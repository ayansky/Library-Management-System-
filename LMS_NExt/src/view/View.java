/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Ayan
 */

public abstract class View {
	
	public final static double WIDTH = 1000;
	
	public final static double HEIGHT = 600;
	
	public abstract Scene getScene();
	
	protected Scene getScene(String resouce) {
		return getScene(resouce, WIDTH, HEIGHT);
	}
	
	protected Scene getScene(String resouce, double width, double height) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resouce));
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, width, height);
			scene.getStylesheets().add(getClass().getResource("mycss.css").toExternalForm());
			Controller myController = (Controller) fxmlLoader.getController();
                        myController.prepareUI();
			return scene;
		} catch (IOException e) {
		}
		return null;
	}
}

