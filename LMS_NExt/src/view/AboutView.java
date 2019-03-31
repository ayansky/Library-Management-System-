/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import static view.View.HEIGHT;
import static view.View.WIDTH;

/**
 *
 * @author Ayan
 */
 
public class AboutView  extends View{
	
	private AboutView() {
		
	}
	
	private static AboutView about = new AboutView();
	
	public static AboutView getInstance() {
		return about; 
	}
	
	@Override
	public Scene getScene() {
		return super.getScene("AboutView.fxml", WIDTH, HEIGHT);
	}

}

