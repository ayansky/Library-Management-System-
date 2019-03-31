package entity;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String firstName;
	private String lastName;
	private int id;
	private String password;
	private List<Role> roles;
        private ArrayList<Book> issuedBooks;

	public Person(String firstName, String lastName,int id, String password, List<Role> roles,ArrayList<Book> issuedBooks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.password = password;
		this.roles = roles;
                this.issuedBooks = issuedBooks;
		
	}

	public Person() {
	}

	/*  Getters and Setters*/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
        
        public ArrayList<Book> getIssuedBooks(){
            return issuedBooks;
        }
        
        public void setIssuedBooks(ArrayList<Book> issuedBooks){
            this.issuedBooks = issuedBooks;
        }

}
