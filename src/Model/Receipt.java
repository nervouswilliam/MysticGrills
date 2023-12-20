package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Connect;

public class Receipt {
	private int receiptID;
	private Order receiptOrder;
	private int receiptPaymentAmount;
	private String receiptPaymentDate;
	private String receiptPaymentType;
	
	public Receipt(int receiptID, Order receiptOrder, int receiptPaymentAmount, String receiptPaymentDate, String receiptPaymentType) {
		this.receiptID = receiptID;
		this.receiptOrder = receiptOrder;
		this.receiptPaymentAmount = receiptPaymentAmount;
		this.receiptPaymentDate = receiptPaymentDate;
		this.receiptPaymentType = receiptPaymentType;
	}
	
	public static Receipt createReceipt(Order orderID, String receiptPaymentType, int receiptPaymentAmount, String receiptPaymentDate) {
		String query = String.format("INSERT INTO receipt (receiptOrderID, receiptPaymentAmount, receiptPaymentDate, receiptPaymentType) Values (%d, %d, \"%s\", \"%s\")", orderID, receiptPaymentAmount, receiptPaymentDate, receiptPaymentType);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
		
		int receiptId = 0;
		
		try {
			receiptId = con.rs.getInt("receiptID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Receipt(receiptId, orderID, receiptPaymentAmount, receiptPaymentDate, receiptPaymentType);
	
	}
	
	public static void updateReceipt(int orderID, String receiptPaymentType, int receiptPaymentAmount, String receiptPaymentDate) {
		String query = String.format("Update receipt r JOIN orders o ON o.orderID = r.receiptOrderID SET r.receiptPaymentType = \"%s\", r.receiptPaymentAmount = %d, r.receiptPaymentDate = \"%s\" WHERE r.receiptOrderID = %d", receiptPaymentType, receiptPaymentAmount, receiptPaymentDate, orderID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static void deleteReceipt(int orderID) {
		String query = String.format("DELETE r FROM receipt r JOIN orders o ON o.orderID = r.receiptOrderID WHERE r.receiptOrderID = %d", orderID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static Receipt getReceiptByID(int receiptID) {
		String query = String.format("SELECT * FROM receipt WHERE receiptID = %d", receiptID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
		
		try {
			if(con.rs.next()) {
				int receiptOrderID = con.rs.getInt("receiptOrderID");
				Order receiptOrder = Order.getOrderByID(receiptOrderID);
				String receiptPaymentType = con.rs.getString("receiptPaymentType");
				int receiptPaymentAmount = con.rs.getInt("receiptPaymentAmount");
				String receiptPaymentDate = con.rs.getString("receiptOrderID");
				
				
				
				return new Receipt(receiptID, receiptOrder, receiptPaymentAmount, receiptPaymentDate, receiptPaymentType);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Receipt getReceiptByOrderID(int orderID) {
		String query = String.format("SELECT * FROM receipt r JOIN orders o ON o.orderID = r.receiptOrderID WHERE r.receiptOrderID = %d", orderID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
		
		try {
			if(con.rs.next()) {
				int receiptID = con.rs.getInt("receiptID");
				String receiptPaymentType = con.rs.getString("receiptPaymentType");
				int receiptPaymentAmount = con.rs.getInt("receiptPaymentAmount");
				String receiptPaymentDate = con.rs.getString("receiptPaymentDate");
				int receiptOrderID = con.rs.getInt("receiptOrderID");
				Order receiptOrder = Order.getOrderByID(receiptOrderID);
				
				return new Receipt(receiptID, receiptOrder, receiptPaymentAmount, receiptPaymentDate, receiptPaymentType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Receipt> getAllReceipts(){
		String query = String.format("SELECT * FROM receipts");
		Connect con = Connect.getInstance();
		con.execUpdate(query);
		
		ArrayList<Receipt> receiptList = new ArrayList<>();
		
		try {
			while(con.rs.next()) {
				int receiptID = con.rs.getInt("receiptID");
				String receiptPaymentType = con.rs.getString("receiptPaymentType");
				int receiptPaymentAmount = con.rs.getInt("receiptPaymentAmount");
				String receiptPaymentDate = con.rs.getString("receiptPaymentDate");
				int receiptOrderID = con.rs.getInt("receiptOrderID");
				Order receiptOrder = Order.getOrderByID(receiptOrderID);
				
				receiptList.add(new Receipt(receiptID, receiptOrder, receiptPaymentAmount, receiptPaymentDate, receiptPaymentType));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receiptList;
		
	}
	public int getOrderID() {
		return receiptOrder.getOrderID();
	}

	public int getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public Order getReceiptOrder() {
		return receiptOrder;
	}

	public void setReceiptOrder(Order receiptOrder) {
		this.receiptOrder = receiptOrder;
	}

	public int getReceiptPaymentAmount() {
		return receiptPaymentAmount;
	}

	public void setReceiptPaymentAmount(int receiptPaymentAmount) {
		this.receiptPaymentAmount = receiptPaymentAmount;
	}

	public String getReceiptPaymentDate() {
		return receiptPaymentDate;
	}

	public void setReceiptPaymentDate(String receiptPaymentDate) {
		this.receiptPaymentDate = receiptPaymentDate;
	}

	public String getReceiptPaymentType() {
		return receiptPaymentType;
	}

	public void setReceiptPaymentType(String receiptPaymentType) {
		this.receiptPaymentType = receiptPaymentType;
	}
	
	
}
