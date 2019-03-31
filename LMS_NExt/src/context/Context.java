/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import entity.Person;
import view.View;

/**
 *
 * @author Ayan
 */

public class Context {
	
	private Context() {
	}
	
	private static Context personContext = new Context();
	
	public static Context getInstance() {
		return personContext;
	}
	
	private Person user;
	
	public void setUser(Person person) {
		user = person;
	}
	
	public Person getUser() {
		return user;
	}
	
	public void changeScreen(Stage root, View view) {
		root.setScene(view.getScene());
	}
	
	public void changeScreen(ActionEvent actionEvent, View view) {
		Stage root = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
		changeScreen(root, view);
	}
}

