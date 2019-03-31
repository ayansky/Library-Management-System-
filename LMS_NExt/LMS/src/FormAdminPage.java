import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

//form that pops up if the admin logged in successfully

public class FormAdminPage {
	
	//declaring and initializing the components of the form: frame itself, labels, and buttons
	//now has only "create" (a library) button. Need to add more
	private JFrame adminPageFrame = new JFrame();
	private JLabel label1;
	private JButton btnCreateLibrary;
	
	
	public FormAdminPage() throws Exception{
				
		adminPageFrame.setTitle("Admin Page");
		adminPageFrame.setSize(600,400);
		adminPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when clicked
		adminPageFrame.setVisible(true);
		adminPageFrame.setLayout(new FlowLayout());
		
		label1 = new JLabel("Create new library");
		label1.setBounds(70, 30, 400, 100);
		adminPageFrame.add(label1);
		
		//button to allow the admin to choose the .xls file and create a library
		btnCreateLibrary = new JButton("Create");
		btnCreateLibrary.setBounds(380, 190, 90, 25);
		adminPageFrame.add(btnCreateLibrary);
		
		//what happens when you click on "create" button 
		btnCreateLibrary.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent me){
					String path = "";
					//file dialog is used to allow the admin to choose the .xls file
					FileDialog fileDialog = new FileDialog(adminPageFrame,"open",FileDialog.LOAD);
					fileDialog.setVisible(true);
					String directory = fileDialog.getDirectory();
					String fileName = fileDialog.getFile();
					path = directory+fileName; //full path to the file
					if (path != null) { //when the file is chosen
						try {
							Library NU = new Library("NU", path); //create new library. For now the name is hardcoded ("NU"). 
														//need to add the option to enter the name of the library
							
							//loop that prints the books that were added to the library.
							//for now it is performed in the terminal, in the future needs to be displayed in the JTable
							for (int j = 0; j<NU.getBooksNumber(); j++) {
								NU.getBooks(j).printBook();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			
		}
	
}
