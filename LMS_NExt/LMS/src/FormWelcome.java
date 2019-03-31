import java.awt.*;
import javax.swing.*;


//Welcome Form implemented with the help of Java Swing 
public class FormWelcome {
	
	//declaring and initializing the components of the form: frame itself, label, and buttons
	private JFrame welcomeFrame = new JFrame();
	private JLabel label1 = new JLabel("What type of user are you?");
	private JButton btnAdmin = new JButton("Admin");
	private JButton btnReader = new JButton("Reader");
	private JButton btnExit = new JButton("Exit");
	private JButton btnAbout = new JButton("About");;
	
	public FormWelcome() {
		
		welcomeFrame.setTitle("Welcome to the Library Management System!");
		welcomeFrame.setSize(600,400);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close when clicked 
		welcomeFrame.setVisible(true); 
		welcomeFrame.setLayout(new FlowLayout());
		welcomeFrame.setLocation(350,50);
	
		label1.setBounds(70, 85, 400, 100);
		welcomeFrame.add(label1);
		
		btnAdmin.setVisible(true);
		btnAdmin.setBounds(150, 120, 120, 30);
		welcomeFrame.add(btnAdmin);
		
		btnReader.setVisible(true);
		btnAdmin.setBounds(290, 120, 120, 30);
		welcomeFrame.add(btnReader);
		
		btnExit.setVisible(true);
		btnExit.setBounds(450, 520, 120, 30);
		welcomeFrame.add(btnExit);
		
		btnAbout.setVisible(true);
		btnAbout.setBounds(20, 520, 120, 30);
		welcomeFrame.add(btnAbout);
		
		//what happens when you click on "Admin" button? An Admin Login Form is called
		btnAdmin.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    		FormAdminLogin AdministratorLog = new FormAdminLogin();
		    	}
			});
		
		//exit when "exit" is clicked
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
					System.exit(0);
			    }
			});	
			
		//the rest is commented out because no FormCustomerLogin and FormAbout exist yet
		
		
		/*btnCustomer.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			       FormCustomerLogin CustomerLogin = new FormCustomerLogin();
			    }
			});
			
		btnAbout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt){
					FormAbout about = new FormAbout();
				}
			});*/
		
		
		
	}
}
