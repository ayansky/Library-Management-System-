import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

//parent class for Admins and Readers
public class Users {
	private String name;
	private String passwordHash; //not the password, but its hash value is stored
	private static ArrayList<Users> usersList = new ArrayList<Users>(); //ArrayList of users
	 
	public Users() {
		usersList.add(this);
	}
	
	public Users(String name, String password) throws NoSuchAlgorithmException {
		this();
		this.name = name;
		this.setPasswordHash(password);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPasswordHash(String password) throws NoSuchAlgorithmException {
		this.passwordHash = hashPassword(password);
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	//method to find the hash value of the password
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    messageDigest.update(password.getBytes());
	    return new String(messageDigest.digest());
	}

	//static method to check is there is such a combination of a name and password
	public static boolean isLoggedIn(String name, String password) throws NoSuchAlgorithmException {
	
		Iterator<Users> userIterator = usersList.iterator();
		while(userIterator.hasNext()){
			Users tempUser = userIterator.next();
			if(name.equals(tempUser.getName()) && Users.hashPassword(password).equals(tempUser.getPasswordHash())) {
				return true;
			}
		}
		return false;
	}

}
