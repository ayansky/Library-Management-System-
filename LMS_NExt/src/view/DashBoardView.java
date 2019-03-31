/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.View;
import javafx.scene.Scene;

public class DashBoardView extends View{
	
	private DashBoardView() {
		
	}
	
	private static DashBoardView dashBoard = new DashBoardView();
	
	public static DashBoardView getInstance() {
		return dashBoard; 
	}
	
	@Override
	public Scene getScene() {
		return super.getScene("Dashboard.fxml", WIDTH, HEIGHT);
	}

}