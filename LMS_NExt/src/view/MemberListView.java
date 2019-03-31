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
public class MemberListView  extends View{
	
	private MemberListView() {
		
	}
	
	private static MemberListView memberList = new MemberListView();
	
	public static MemberListView getInstance() {
		return memberList; 
	}
	
	@Override
	public Scene getScene() {
		return super.getScene("MemberList.fxml", WIDTH, HEIGHT);
	}

}