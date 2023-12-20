package controller;

import java.util.ArrayList;

import Model.Order;
import Model.OrderItem;
import Model.menuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class updateOrderItemController {
	
	private updateOrderItemView view = new updateOrderItemView();
	
	private Order order;
	private ArrayList<OrderItem> orderItemList;
	private int back;
	private menuItem currMenuItem = null;
	private OrderItem currOrderItem = null;
	
	public void initializeButtonHandler() {
		view.addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.currValidation.setText("");
				view.quantityValidation.setText("");
				if(currMenuItem == null) {
					view.currValidation.setText("Menu Item must Be chosen first");
					return;
				}
				if(view.menuItemQuantity.getText().trim().equals("")) {
					view.quantityValidation.setText("Quantity must be filled");
					return;
				}
				
				int quantity;
				try {
					quantity = Integer.parseInt(view.menuItemQuantity.getText());
				}catch(Exception e) {
					view.quantityValidation.setText("Quantity needs to be an Integer");
					return;
				}
				
				if(quantity < 1) {
					view.quantityValidation.setText("Quantity myst be more than or equals 1");
					return;
				}
				
				orderItemList.add(new OrderItem(0, currMenuItem, quantity));
				
				loadMenuItemData();
				loadOrderItemData();
				view.menuItemQuantity.setText("");
			}
			
		}); 
		
		view.saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(orderItemList.isEmpty()) {
					orderController.deleteOrder(order.getOrderID());
				} else {
					orderController.updateOrder(order.getOrderID(), orderItemList, order.getOrderStatus());
				}
				
				if(back == 1) {
					new orderMenuItemController();
				} else if(back == 2) {
					new prepareController();
				} else {
					new serveController();
				}
			}
			
		});
		
		view.changeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.currValidation.setText("");
				view.quantityValidation.setText("");
				if(currOrderItem == null) {
					view.currValidation.setText("Order must be chosen first");
					return;
				}
				if(view.menuItemQuantity.getText().trim().equals("")) {
					view.quantityValidation.setText("Quantity must be filled");
					return;
				}
				
				int quantity;
				try {
					quantity  = Integer.parseInt(view.menuItemQuantity.getText());
				}catch(Exception e) {
					view.quantityValidation.setText("Qunatity must be an integer");
					return;
				}
				
				if(quantity < 0) {
					view.quantityValidation.setText("Quantity must be more than or equals to 0");
					return;
				}else if(quantity == 0) {
					ArrayList<OrderItem> filter = new ArrayList<>();
					
					for(OrderItem OI : orderItemList) {
						if(OI.getMenuItem().getMenuItemID() != currOrderItem.getMenuItem().getMenuItemID()) {
							filter.add(OI);
						}
					}
					orderItemList = filter;
				}else {
					for(OrderItem OI : orderItemList) {
						if(OI.getMenuItem().getMenuItemID() == currOrderItem.getMenuItem().getMenuItemID()) {
							OI.setOrderQuantity(quantity);
						}
					}
				}
				loadOrderItemData();
				view.quantityValidation.setText("");
			}
			
		});
	}
	
	private void setupTableListener() {
		view.menuItemTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null) {
				int menuID = newSelection.getMenuItemID();
				String name = newSelection.getMenuItemName();
				String description = newSelection.getMenuItemDescription();
				int price = newSelection.getMenuItemPrice();
				
				currMenuItem = new menuItem(menuID, name, description, price);
				view.currMenuItemLabel.setText("Current Selected Menu Item ID: " +menuID); 
			}
		});
	}
	
	private void loadOrderItemData() {
		view.orderItemTable.getItems().setAll(orderItemList);
	}
	
	private void loadMenuItemData() {
		ArrayList<menuItem> menuItemList = menuItemController.getAllMenuItems();
		
		ArrayList<menuItem> filter = new ArrayList<>();
		for(menuItem MI : menuItemList) {
			boolean found = false;
			for(OrderItem OI : orderItemList) {
				if(MI.getMenuItemID() == OI.getMenuItem().getMenuItemID()) {
					found = true;
					break;
				}
			}
			if(!found) {
				filter.add(MI);
			}
		}
	}
	
	public updateOrderItemController(Order order, int back) {
		this.order = order;
		this.back = back;
		this.orderItemList = orderItemController.getAllOrderByOrderID(order.getOrderID());
		initializeButtonHandler();
		loadOrderItemData();
		loadMenuItemData();
		setupTableListener();
	}
	

}
