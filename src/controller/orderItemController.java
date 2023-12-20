package controller;

import java.util.ArrayList;

import Model.OrderItem;
import Model.menuItem;
import view.orderItemView;

public class orderItemController {
	
	public static OrderItem createOrderItem(int orderID, menuItem MenuItem, int orderQuantity) {
		return OrderItem.createOrderItem(orderID, MenuItem, orderQuantity);
	}
	
	public static void updateOrderItem(int orderID, menuItem MenuItem, int orderQuantity) {
		OrderItem.updateOrderItem(orderID, MenuItem, orderQuantity);
	}
	
	public static void deleteOrderItem(int orderID) {
		OrderItem.deleteOrderItem(orderID);
	}
	
	public static ArrayList<OrderItem> getAllOrderByOrderID(int orderID){
		return OrderItem.getAllOrder(orderID);
	}
	
//orderItemView orderItem;
//	
//	private void initializeButtonHandler() {
//		orderItem.getAddButton().setOnAction(e ->{
//			String orderID = orderItem.getOrderIDInput().getText();
//			String menuName = orderItem.getMenuNameInput().getText();
//			int orderQuantity = Integer.parseInt(orderItem.getOrderQuantityInput().getText());
//			OrderItem order = new OrderItem(orderID, menuName, orderQuantity);
//			
//			order.insert();
//			loadOrderData();
//		});
//		orderItem.getDeleteButton().setOnAction(e ->{
//			String orderID = orderItem.getOrderIDInput().getText();
//			String menuName = orderItem.getMenuNameInput().getText();
//			int orderQuantity = Integer.parseInt(orderItem.getOrderQuantityInput().getText());
//			
//			OrderItem.delete(orderID);
//			loadOrderData();
//		});
//		orderItem.getUpdateButton().setOnAction(e ->{
//			String orderID = orderItem.getOrderIDInput().getText();
//			String menuName = orderItem.getMenuNameInput().getText();
//			int orderQuantity = Integer.parseInt(orderItem.getOrderQuantityInput().getText());
//			
//			OrderItem.update(orderID, menuName, orderQuantity);
//			loadOrderData();
//		});
//		
//		
//	}
//	
//	private void loadOrderData() {
//		ArrayList<OrderItem> orders = OrderItem.getAllOrder();
//		orderItem.getTable().getItems().setAll(orders);
//	}
//	
//	private void setupTableSelectionListener() {
//        orderItem.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                orderItem.getOrderIDInput().setText(newSelection.getOrderID());
//                orderItem.getMenuNameInput().setText(newSelection.getMenuName());
//                orderItem.getOrderQuantityInput().setText(String.valueOf(newSelection.getOrderQuantity()));
//            }
//        });
//	}
//
//	public orderItemController(orderItemView orderItem) {
//		// TODO Auto-generated constructor stub
//		this.orderItem = orderItem;
//		initializeButtonHandler();
//		loadOrderData();
//		setupTableSelectionListener();
//	}

}
