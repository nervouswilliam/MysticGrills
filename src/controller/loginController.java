package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.loginView;

public class loginController {
	loginView LoginView;
	
	public void initializeButtonHandler() {
		LoginView.loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String userEmail = LoginView.getEmailInput().getText();
				String userPassword = LoginView.getPasswordInput().getText();
				
				LoginView.emailValidate.setText("");
				LoginView.passwordValidate.setText("");
				boolean fail = false;
				
				if(userEmail.trim().isEmpty()) {
					LoginView.emailValidate.setText("Email must be filled!");
					fail = true;
				}
				if(userPassword.trim().isEmpty()) {
					LoginView.passwordValidate.setText("Password must be filled!");
					fail = true;
				}
				if(fail) {
					return;
				}
				
				if(!userController.authenticateUser(userEmail, userPassword)) {
					LoginView.generalValidate.setText("Email or Password is invalid");
					return;
				}
				
				new homeController();
				
			}
			
		});
		
		LoginView.registerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new registerController();
			}
			
		});
	}

	public loginController() {
		// TODO Auto-generated constructor stub
		initializeButtonHandler();
	}

}
