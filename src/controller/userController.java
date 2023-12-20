package controller;

import java.util.ArrayList;

import Model.User;

public class userController {
	
	public static User user;

	public static User currUser;
	
	public static void createUser(String userRole, String userName, String userEmail, String userPassword) {
		currUser.createUser("Customer", userName, userEmail, userPassword);
	}
	
	public static void updateUser(int userID, String userRole, String userName, String userEmail, String userPassword) {
		currUser.updateUser(userID, userRole, userName, userEmail, userPassword);
	}
	
	public static void deleteUser(int userID) {
		currUser.deleteUser(userID);
	}
	
	public static boolean authenticateUser(String userEmail, String userPassword) {
		user = currUser.authenticateUser(userEmail, userPassword);
		return user != null;
	}
	
	public static ArrayList<User> getAllUser(){
		return currUser.getAllUser();
	}
	
	public static User getUserID(int userID) {
		return currUser.getUserByID(userID);
	}
}
