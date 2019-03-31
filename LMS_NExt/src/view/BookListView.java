/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import static view.View.WIDTH;
import static view.View.HEIGHT;

/**
 *
 * @author Ayan
 */
public class BookListView  extends View{
	
	private BookListView() {
		
	}
	
	private static BookListView BookList = new BookListView();
	
	public static BookListView getInstance() {
		return BookList; 
	}
	
	@Override
	public Scene getScene() {
		return super.getScene("BookListView.fxml", WIDTH, HEIGHT);
	}

}

