package controller;

import Model.Order;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.serveView;

public class serveController {
	
	private serveView view = new serveView();
	private Order currOrder = null;
	private void initializeButtonHandler() {
		view.editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.idValidation.setText("");
				view.currValidation.setText("");
				
				if(currOrder == null) {
					view.currValidation.setText("Pending Order must be chosen first");
					return;
				}
				
				new updateOrderItemController(currOrder, 3);
				loadPendingOrderData();
				view.orderID.setText("");
			}
			
		});
		
		view.removeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.idValidation.setText("");
				view.currValidation.setText("");
				
				if(currOrder == null) {
					view.currValidation.setText("Pending Order must be chosen first");
					return;
				}
				
				orderController.deleteOrder(currOrder.getOrderID());
			}
			
		});
		
		view.serveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.idValidation.setText("");
				view.currValidation.setText("");
				
				String orderID = view.orderID.getText();
				
				if(orderID.trim().isEmpty()) {
					view.idValidation.setText("Prepared OrderID cannot be empty");
					return;
				}
				int orderId;
				try {
					orderId = Integer.parseInt(orderID);
				}catch(Exception e) {
					view.idValidation.setText("Prepared OrderID is not in database");
					return;
				}
				
				Order order = orderController.getOrderByOrderID(orderId);
				if(order == null) {
					view.idValidation.setText("prepared Order ID is not in the database");
					return;
				}
				
				orderController.updateOrder(orderId, orderItemController.getAllOrderByOrderID(orderId), "Served");
				
				loadPreparedOrderData();
				view.orderID.setText("");
				
			}
			
		});
	}
	
	private void loadPendingOrderData() {
		view.pendingOrderTable.getItems().setAll(orderController.getAllOrderByStatus("Pending"));
	}
	
	private void loadPreparedOrderData() {
		view.preparingOrderTable.getItems().setAll(orderController.getAllOrderByStatus("Prepared"));
	}

}
