package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Connect;

public class User {

	private int UserID;
	private String Username;
	private String Email;
	private String Password;
	private String Role;
	
	public User(int userID, String username, String email, String password, String role) {
		this.UserID = userID;
		this.Username = username;
		this.Email = email;
		this.Password = password;
		this.Role = role;
	}
	
	public static void createUser(String userRole, String username, String userEmail, String userPassword) {
		String query = String.format("INSERT INTO users (userRole, username, userEmail, userPassword) VALUES(\"%s\", \"%s\", \"%s\", \"%s\")", userRole, username, userEmail, userPassword);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static void updateUser(int userID, String userRole, String username, String userEmail, String userPassword) {
		String query = String.format("UPDATE user SET `userRole`=\'%s\', `username`=\'%s\', `userPassword`=\'%s\'  WHERE `userID` = \'%s\'", userRole, username, userEmail, userPassword);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static void deleteUser(int userID) {
		String query = String.format("DELETE FROM `user` WHERE `userID` = \'%s\'", userID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static User authenticateUser(String userEmail, String userPassword) {
		String query = String.format("SELECT * FROM `user` WHERE userEmail = \'%s\' AND userPassword = \'%s\'", userEmail, userPassword);
		return null;
	}
	
	public static ArrayList<User> getAllUser(){
		ArrayList<User> user = new ArrayList<>();
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM user";
		con.rs = con.execQuery(query);
		
		try {
			while(con.rs.next()) {
				System.out.println("Masuk");
				int userID = con.rs.getInt("userID");
				String username = con.rs.getString("username");
				String userEmail = con.rs.getString("userEmail");
				String userPhone = con.rs.getString("userPhone");
				String userRole = con.rs.getString("userRole");
				user.add(new User(userID, username, userEmail, userPhone, userRole));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static User getUserByID(int orderUserID) {
		String query = String.format("SELECT * FROM `user` WHERE userID = \'%s\'", orderUserID);
		Connect con = Connect.getInstance();
		con.rs = con.execQuery(query);
		try {
			if(con.rs.next()) {
				String userRole = con.rs.getString("userRole");
				String username = con.rs.getString("userName");
				String userEmail = con.rs.getString("userEmail");
				String userPassword = con.rs.getString("userPassword");
				
				return new User(orderUserID, username, userEmail, userPassword, userRole);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	
	
	

}
