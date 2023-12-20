package controller;

import java.util.ArrayList;

import Model.Order;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.orderedMenuItemView;

public class orderMenuItemController {
	
	orderedMenuItemView view;
	private Order currOrder = null;
	
	private void initializeButtonHandler() {
		view.editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				view.selectedValidation.setText("");
				if(currOrder == null) {
					view.selectedValidation.setText("Order must be chosen first");
				}
				
				loadOrderTable();
				
				
			}
			
		});
	}
	
	private void loadOrderTable() {
		ArrayList<Order> order = Order.getAllOrder();
		view.getOrderTable().getItems().setAll(order);
	}

	public orderMenuItemController() {
		// TODO Auto-generated constructor stub
		initializeButtonHandler();
	}

}
