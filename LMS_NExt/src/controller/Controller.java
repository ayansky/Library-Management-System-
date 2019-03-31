/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import context.Context;
import view.DashBoardView;

/**
 *
 * @author Ayan
 */
public abstract class Controller {
	
	@FXML
	private Label userWelcomeLabel;
	
	public void prepareUI() {
		String username = Context.getInstance().getUser().getFirstName();
		userWelcomeLabel.setText("Login as " + username);
                
	}
}
