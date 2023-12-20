package controller;

import Model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.registerView;

public class registerController {
	
	registerView RegisterView;
	
	private void initializeButtonHandler() {
		RegisterView.registerButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String userID = RegisterView.getUserID().getText();
				String username = RegisterView.getUsernameInput().getText();
				String email = RegisterView.getEmailInput().getText();
				String password = RegisterView.getPasswordInput().getText();
				String confirmPassword = RegisterView.getConfirmPasswordInput().getText();
				String userRole = RegisterView.getRoleInput().getText();
				
				RegisterView.nameValidate.setText("");
				RegisterView.emailValidate.setText("");
				RegisterView.passwordValidate.setText("");
				RegisterView.nameValidate.setText("");
				
				boolean fail = false;
				
				if(username.trim().isEmpty()) {
					RegisterView.nameValidate.setText("Username must be filled");
					fail = true;
				}
				if(email.trim().isEmpty()) {
					RegisterView.emailValidate.setText("Email must be filled");
					fail = true;
				}
				if(password.trim().isEmpty()) {
					RegisterView.passwordValidate.setText("Password must be filled");
					fail = true;
				}
				if(confirmPassword.trim().isEmpty()) {
					RegisterView.nameValidate.setText("Confirm Password must be filled");
					fail = true;
				}
				if(fail) {
					return;
				}
				
				boolean unique = true;
				
				//unique for email validation
				//--
				userController.createUser("Customer", username, email, password);
				new loginController();
			}
		});
		
		RegisterView.loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new loginController();
			}
			
		});
	}
	
	public registerController() {
		
		initializeButtonHandler();
	}

}
