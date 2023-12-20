package controller;

import Model.Order;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.prepareView;

public class prepareController {
	
	private prepareView view = new prepareView();
	
	private Order currOrder = null;

	private void initializeButtonHandler() {
		view.editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.idValidation.setText("");
				view.currValidation.setText("");
				
				if(currOrder == null) {
					view.currValidation.setText("Order must be chosen first");
					return;
				}
				
				new updateOrderItemController(currOrder, 2);
			}
			
		});
		
		view.prepareButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.idValidation.setText("");
				view.currValidation.setText("");
				String orderIDText = view.orderId.getText();
				if(orderIDText.trim().isEmpty()) {
					view.idValidation.setText("Order ID must be filled");
					return;
				}
				int orderID;
				try {
					orderID = Integer.parseInt(orderIDText);
				}catch(Exception e) {
					view.idValidation.setText("Order ID must be in database");
					return;
				}
				Order order = orderController.getOrderByOrderID(orderID);
				if(order == null) {
					view.idValidation.setText("Order ID must be in database");
					return;
				}
				orderController.updateOrder(orderID, orderItemController.getAllOrderByOrderID(orderID), "Prepared");
				
				loadOrderData();
				view.orderId.setText("");
			}
			
		});
		
		view.removeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.idValidation.setText("");
				view.currValidation.setText("");
				
				if(currOrder == null) {
					view.currValidation.setText("Order must be chosen first");
					return;
				}
				
				orderController.deleteOrder(currOrder.getOrderID());
				
				loadOrderData();
				view.orderId.setText("");
			}
			
		});
	}
	
	public void loadOrderData() {
		view.orderTable.getItems().setAll(orderController.getAllOrderByStatus("Pending"));
	}
	
	private void setupTableListener() {
		view.orderTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
			if(newSelection != null) {
				int orderID = newSelection.getOrderID();
				currOrder = new Order(orderID, newSelection.getOrderUser(), newSelection.getOrderStatus(), newSelection.getOrderDate(), newSelection.getOrderTotal());
				view.currLabel.setText("Current Selected Order ID: " + orderID);
			}
		});
	}
	
	public prepareController() {
		initializeButtonHandler();
	}
}
