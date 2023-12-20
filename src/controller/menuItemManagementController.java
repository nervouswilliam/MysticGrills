package controller;

import java.util.ArrayList;

import Model.menuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.menuItemManagementView;

public class menuItemManagementController {
	menuItemManagementView view = new menuItemManagementView();
	int menuItemID;
	String currName;
	
	private void initializeButtonHandler() {
		view.insertButton.setOnAction(new EventHandler<ActionEvent> () {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = view.menuItemName.getText();
				String description = view.description.getText();
				String price = view.price.getText();
				
				view.nameValidation.setText("");
				view.descriptionValidation.setText("");
				view.priceValidation.setText("");
				
				boolean fail = false;
				if(name.length() == 0) {
					view.nameValidation.setText("Name must be filled");
					fail = true;
				}
				if(description.trim().length() < 10) {
					view.descriptionValidation.setText("Description must be over 10 characters!");
					fail = true;
				}
				int priceItem;
				try {
					priceItem = Integer.parseInt(price);
				} catch(Exception e) {
					view.priceValidation.setText("Price must be a number");
					return;
				}
				if(priceItem < 2.5) {
					view.priceValidation.setText("Price must be more than 2.5");
					fail = true;
				}
				
				boolean isUnique = true;
				
				for(menuItem mi : menuItemController.getAllMenuItems()) {
					if(mi.getMenuItemName().equals(name)) {
						isUnique = false;
						break;
					}
				}
				
				if(!isUnique) {
					view.nameValidation.setText("Name is already Taken");
					return;
				}
				if(!fail) {
					menuItemController.createMenuItem(name, description, priceItem);
					loadProductData();
				}
			}
			
		});
		
		view.updateButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = view.menuItemName.getText();
				String description = view.description.getText();
				String price = view.price.getText();
				
				view.nameValidation.setText("");
				view.descriptionValidation.setText("");
				view.priceValidation.setText("");
				
				boolean fail = false;
				if(name.length() == 0) {
					view.nameValidation.setText("Name must be filled");
					fail = true;
				}
				if(description.trim().length() < 10) {
					view.descriptionValidation.setText("Description must be over 10 characters!");
					fail = true;
				}
				int priceItem;
				try {
					priceItem = Integer.parseInt(price);
				} catch(Exception e) {
					view.priceValidation.setText("Price must be a number");
					return;
				}
				if(priceItem < 2.5) {
					view.priceValidation.setText("Price must be more than 2.5");
					fail = true;
				}
				
				boolean isUnique = true;
				
				for(menuItem mi : menuItemController.getAllMenuItems()) {
					if(mi.getMenuItemName().equals(name) && currName.equals(name)) {
						isUnique = false;
						break;
					}
				}
				
				if(!isUnique) {
					view.nameValidation.setText("Name is already Taken");
					return;
				}
				if(!fail) {
					menuItemController.updateMenuItem(menuItemID, name, description, priceItem);
					loadProductData();
				}
			}
			
		});
		
		view.deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menuItemController.deleteMenuItem(menuItemID);
				loadProductData();
			};
		});
	}
	
	private void setupTableListerner() {
		view.getMenuItemTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
			if(newSelection != null) {
				menuItemID = newSelection.getMenuItemID();
				view.menuItemName.setText(newSelection.getMenuItemName());
				view.description.setText(newSelection.getMenuItemDescription());
				view.price.setText(String.valueOf(newSelection.getMenuItemPrice()));
				currName = newSelection.getMenuItemName();
			}
		});
	}
	
	private void loadProductData() {
		ArrayList<menuItem> menuItem = menuItemController.getAllMenuItems();
		view.menuItemTable.getItems().setAll(menuItem);
	}
	
	public menuItemManagementController() {
		initializeButtonHandler();
		loadProductData();
	}
}
