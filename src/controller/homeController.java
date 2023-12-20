package controller;

import view.homeView;

public class homeController {
	private homeView view = new homeView();
	
	public homeController() {
		setupText();
	}
	
	public void setupText() {
		view.welcomeLabel.setText("Welcome Back " + userController.currUser.getRole());
	}
}
