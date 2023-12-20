package Model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Connect;

public class Order {
	
	private int orderID;
	private User orderUser;
	private String orderStatus;
	private String orderDate;
	private int orderTotal;

	public Order(int OrderID, User OrderUser, String OrderStatus, String OrderDate, int OrderTotal) {
		// TODO Auto-generated constructor stub
		this.orderID = OrderID;
		this.orderUser = OrderUser;
		this.orderStatus = OrderStatus;
		this.orderDate = OrderDate;
		this.orderTotal = OrderTotal;
	}
	
	public static Order createOrder(User orderUser, ArrayList<OrderItem> orderItems, String orderDate) {
		int orderTotal = 0;
		for(OrderItem OI : orderItems) {
			orderTotal += OI.getOrderQuantity() * OI.getMenuItem().getMenuItemPrice();
		}
		final String orderStatus = "Pending";
		
		String query = String.format("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1"); 
		Connect con = Connect.getInstance();
		con.execUpdate(query);
		
		int orderID = 0;
		
		try {
			if(con.rs.next()) {
				orderID = con.rs.getInt("orderID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(OrderItem OI : orderItems) {
			OrderItem.createOrderItem(orderID, OI.getMenuItem(), OI.getOrderQuantity());
		}
		return new Order(orderID, orderUser, orderStatus, orderDate, orderTotal);
	}
	
	public static void updateOrder(int orderID, ArrayList<OrderItem> orderItem, String orderStatus) {
		int orderTotal = 0;
		
		String query = String.format("UPDATE order SET `orderStatus`=\'%s\', `orderTotal`= %d WHERE `orderID` = \'%s\' ", orderStatus, orderTotal, orderID);
        Connect con = Connect.getInstance();
        con.execUpdate(query);
	}
	
	public static void deleteOrder(int orderID) {
		String query = String.format("DELETE FROM `order` WHERE `orderID` = %d", orderID);
        Connect con = Connect.getInstance();
        con.execUpdate(query);
	}
	
	public static ArrayList<Order> getAllOrder(){
		
		ArrayList<Order> order = new ArrayList<>();
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM order";
		
		con.rs = con.execQuery(query);
		
		try {
			while(con.rs.next()) {
				System.out.println("Masuk");
				int orderID = con.rs.getInt("orderID");
				int orderUserID = con.rs.getInt("orderUserID");
				User orderUser = User.getUserByID(orderUserID);
				String orderStatus = con.rs.getString("orderStatus");
				String orderDate = con.rs.getString("orderDate");
				int orderTotal = con.rs.getInt("orderTotal");
				order.add(new Order(orderID, orderUser, orderStatus, orderDate, orderTotal));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
		
	}
	
	public static ArrayList<Order> getAllOrdersByStatus(String orderStatus){
		ArrayList<Order> orders = new ArrayList<>();
		
		String query = String.format("SELECT * FROM order where orderStatus = \'%s\'", orderStatus);
        Connect con = Connect.getInstance();
        con.execUpdate(query);
        
        try {
			while(con.rs.next()) {
				int orderID = con.rs.getInt("orderID");
				int userID = con.rs.getInt("orderUserID");
				User orderUser = User.getUserByID(userID);
				String orderDate = con.rs.getString("orderDate");
				int orderTotal = con.rs.getInt("orderTotal");
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return orders;
	}
	
	public static ArrayList<Order> getAllOrderByUserID(int userID){
		ArrayList<Order> orders = new ArrayList<>();
		
		String query = String.format("SELECT * FROM order o JOIN users u ON o.orderUserID = u.userID where u.userID = %d", userID);
        Connect con = Connect.getInstance();
        con.execUpdate(query);
        
        try {
			while(con.rs.next()) {
				int orderID = con.rs.getInt("orderID");
				User orderUser = User.getUserByID(userID);
				String orderStatus = con.rs.getString("orderStatus");
				String orderDate = con.rs.getString("orderDate");
				int orderTotal = con.rs.getInt("orderTotal");
				
				orders.add(new Order(orderID, orderUser, orderStatus, orderDate, orderTotal));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return orders;
 	}
	
	public static Order getOrderByID(int orderID) {
		String query = String.format("SELECT * FROM order WHERE orderID = %d", orderID);
        Connect con = Connect.getInstance();
        con.execUpdate(query);
        
        try {
			while(con.rs.next()) {
				int orderUserID = con.rs.getInt("orderUserID");
				User orderUser = User.getUserByID(orderUserID);
				String orderStatus = con.rs.getString("orderStatus");
				String orderDate = con.rs.getString("orderDate");
				int orderTotal = con.rs.getInt("orderTotal");
				
				return new Order(orderID, orderUser, orderStatus, orderDate, orderTotal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
        
		}
        return null;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public User getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	
	
	


}
