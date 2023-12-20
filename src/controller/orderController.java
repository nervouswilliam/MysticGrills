package controller;

import java.util.ArrayList;

import Model.Order;
import Model.OrderItem;
import Model.User;
import view.orderView;

public class orderController {
	
	public static Order createOrder(User orderUser, ArrayList<OrderItem> orderItems, String orderData) {
		return Order.createOrder(orderUser, orderItems, orderData);
	}
	
	public static void updateOrder(int orderID, ArrayList<OrderItem> orderItems, String orderStatus) {
		Order.updateOrder(orderID, orderItems, orderStatus);
	}
	
	public static void deleteOrder(int orderID) {
		Order.deleteOrder(orderID);
	}
	
	public static ArrayList<Order> getAllOrders(){
		return Order.getAllOrder();
	}
	
	public static ArrayList<Order> getAllOrderByStatus(String status){
		return Order.getAllOrdersByStatus(status);
	}
	
	public static ArrayList<Order> getAllOrderByUserID(int userID){
		return Order.getAllOrderByUserID(userID);
	}
	
	public static Order getOrderByOrderID(int orderID) {
		return Order.getOrderByID(orderID);
	}
//	orderView orderview;
//	
//	private void initializeButtonHandler() {
//		orderview.getAddButton().setOnAction(e ->{
//			String orderID = orderview.getOrderIDInput().getText();
//			String orderUser = orderview.getOrderUserInput().getText();
//			String orderItems = orderview.getOrderItemsInput().getText();
//			String orderStatus = orderview.getOrderStatusInput().getText();
//			Date orderDate = orderview.getOrderDateInput().getText();
//			int orderTotal = Integer.parseInt(orderview.getOrderTotalInput().getText());
//			Order order = new Order(orderID, orderUser, orderItems, orderStatus, orderDate, orderTotal);
//			
//			order.insert();
//			loadOrderData();
//		});
//		orderview.getDeleteButton().setOnAction(e ->{
//			String orderID = orderview.getOrderIDInput().getText();
//			String orderUser = orderview.getOrderUserInput().getText();
//			String orderItems = orderview.getOrderItemsInput().getText();
//			String orderStatus = orderview.getOrderStatusInput().getText();
//			Date orderDate = orderview.getOrderDateInput().getText();
//			int orderTotal = Integer.parseInt(orderview.getOrderTotalInput().getText());
//			
//			Order.delete(orderID);
//			loadOrderData();
//		});
//		orderview.getUpdateButton().setOnAction(e ->{
//			String orderID = orderview.getOrderIDInput().getText();
//			String orderUser = orderview.getOrderUserInput().getText();
//			String orderItems = orderview.getOrderItemsInput().getText();
//			String orderStatus = orderview.getOrderStatusInput().getText();
//			Date orderDate = orderview.getOrderDateInput().getText();
//			int orderTotal = Integer.parseInt(orderview.getOrderTotalInput().getText());
//			
//			Order.update(orderID, orderUser, orderItems, orderStatus, orderDate, orderTotal);
//			loadOrderData();
//		});
//		
//		
//	}
//	
//	private void loadOrderData() {
//		ArrayList<Order> orders = Order.getAllOrder();
//		orderview.getTable().getItems().setAll(orders);
//	}
//	
//	private void setupTableSelectionListener() {
//        orderview.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                orderview.getOrderIDInput().setText(newSelection.getOrderID());
//                orderview.getOrderUserInput().setText(newSelection.getOrderUser());
//                orderview.getOrderItemsInput().setText(newSelection.getOrderItems());
//                orderview.getOrderStatusInput().setText(newSelection.getOrderStatus());
//                orderview.getOrderDateInput().setDate(newSelection.getOrderDate());
//                orderview.getOrderTotalInput().setText(String.valueOf(newSelection.getOrderTotal()));
//            }
//        });
//	}
//
//
//	public orderController(orderView orderview) {
//		// TODO Auto-generated constructor stub
//		this.orderview = orderview;
//		initializeButtonHandler();
//		loadOrderData();
//		setupTableSelectionListener();
//	}
//
}
