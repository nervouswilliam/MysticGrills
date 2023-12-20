package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Connect;

public class OrderItem {

	private int OrderID;
	private static menuItem menuItem;
	private int OrderQuantity;
	
	public OrderItem(int orderID, menuItem menuItem, int orderQuantity) {
		// TODO Auto-generated constructor stub
		OrderID = orderID;
		menuItem = menuItem;
		OrderQuantity = orderQuantity;
	}
	
	public static OrderItem createOrderItem(int orderID, menuItem MenuItem, int orderQuantity) {
		String query = String.format("INSERT INTO orderItems VALUES (%d, \"%s\", %d)", orderID, menuItem, orderQuantity); 
		Connect con = Connect.getInstance();
		con.execUpdate(query);
		
		int menuItemID = 0;
		try {
			if(con.rs.next()) {
				menuItemID = con.rs.getInt("menuItemID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new OrderItem(orderID, menuItem, orderQuantity);
	}
	
	public static void deleteOrderItem(int id) {
		 String query = String.format("DELETE FROM `orderItem` WHERE `orderID` = %d", id);
         Connect con = Connect.getInstance();
         con.execUpdate(query);
	}
	
	public static void updateOrderItem(int id, menuItem MenuItem, int quantity) {
		String query = String.format("UPDATE orderItem SET `orderQuantity`=\'%s\' WHERE `orderID` = \'%s\' AND menuItemID = %d ", quantity, id, MenuItem);
        Connect con = Connect.getInstance();
        con.execUpdate(query);
	}
	
	public static ArrayList<OrderItem> getAllOrder(int orderID){
		
		ArrayList<OrderItem> orderitem = new ArrayList<>();
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM orderItem";
		
		con.rs = con.execQuery(query);
		
		try {
			while(con.rs.next()) {
				System.out.println("Masuk");
				int menuItemID = con.rs.getInt("orderID");
				menuItem MenuItem = menuItem.getMenuItemByID(menuItemID);
				int orderQuantity = con.rs.getInt("orderQuantity");
				orderitem.add(new OrderItem(orderID, menuItem, orderQuantity));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public static menuItem getMenuItem() {
		return menuItem;
	}

	public static void setMenuItem(menuItem menuItem) {
		OrderItem.menuItem = menuItem;
	}

	public int getOrderQuantity() {
		return OrderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		OrderQuantity = orderQuantity;
	}

	


}
