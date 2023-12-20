package controller;

import java.util.ArrayList;

import Model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.userManagementView;

public class userManagement {
	
	userManagementView view = new userManagementView();
	User currUser = null;
	
	private void initializeButtonHandler(){
		view.updateButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String userRole = view.userRole.getText();
				
				view.roleValidation.setText("");
				if(!userRole.equals("Cashier") && !userRole.equals("Admin") && !userRole.equals("Chef") && !userRole.equals("Waiter") && !userRole.equals("Customer")) {
					view.roleValidation.setText("role must be [Cashier | Admin | Chef | Waiter | Customer]");
					return;
				}
				
				userController.updateUser(currUser.getUserID(), userRole, currUser.getUsername(), currUser.getEmail(), currUser.getPassword());
				loadUserData();
			}
			
		});
		
		view.deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.roleValidation.setText("");
				if(currUser == null) {
					view.roleValidation.setText("User must be chosen to use delete Function");
					return;
				}
				
				userController.deleteUser(currUser.getUserID());
				loadUserData();
			}

			
			
		});
	}
	
	private void setupTableListener() {
		view.getUserTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null) {
				int id = newSelection.getUserID();
				String role = newSelection.getRole();
				String username = newSelection.getUsername();
				String email = newSelection.getEmail();
				String password = newSelection.getPassword();
				
				currUser = new User(id, role, username, email, password);
				view.userRole.setText(role);
			}
		});
	}
	
	private void loadUserData() {
		ArrayList<User> menuItem = userController.getAllUser();
		view.userTable.getItems().setAll(menuItem);
	}
	
	public userManagement() {
		initializeButtonHandler();
	}

}
