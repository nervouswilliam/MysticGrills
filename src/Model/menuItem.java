package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Connect;

public class menuItem extends Model {

	private int menuItemID;
	private String menuItemName;
	private String menuItemDescription;
	private static int menuItemPrice;
	
	public menuItem(int menuItemID, String menuItemName, String menuItemDescription, int menuItemPrice) {
		// TODO Auto-generated constructor stub
		this.menuItemID = menuItemID;
		this.menuItemName = menuItemName;
		this.menuItemDescription = menuItemDescription;
		this.menuItemPrice = menuItemPrice;
	}
	
	public static menuItem createMenuItem(String menuItemName, String menuItemDescription, int menuItemprice) {
		String query = String.format("INSERT INTO menuItems VALUES (%d, \"%s\", %d)", menuItemName, menuItemDescription, menuItemPrice); 
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
		
		return new menuItem(menuItemID, menuItemName, menuItemDescription, menuItemPrice);
	}
	
	public static void updateMenuItem(int menuItemID, String menuItemName, String menuItemDescription, int menuItemPrice) {
		String query = String.format("UPDATE menuItem SET `menuItemName`=\'%s\', `menuItemDescription`=\'%s\', `menuItemPrice`=\'%s\'  WHERE `menuItemID` = \'%s\'", menuItemName, menuItemDescription, menuItemPrice, menuItemID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static void deleteMenuItem(int menuItemID) {
		String query = String.format("DELETE FROM `menuItem` WHERE `menuItemID` = %d", menuItemID);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static ArrayList<menuItem> getAllMenuItems(){
		ArrayList<menuItem> menuItem = new ArrayList<>();
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM menuItem";
		con.rs = con.execQuery(query);
		
		try {
			while(con.rs.next()) {
				System.out.println("Masuk");
				int menuItemID = con.rs.getInt("menuItemID");
				String menuItemName = con.rs.getString("menuItemName");
				String menuItemDescription = con.rs.getString("menuItemDescription");
				int menuItemPrice = con.rs.getInt("menuItemPrice");
				menuItem.add(new menuItem(menuItemID, menuItemName, menuItemDescription, menuItemPrice));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItem;
	}
	
	public static menuItem getMenuItemByID(int menuItemID) {
		String query = String.format("SELECT * FROM `menuItem` WHERE menuItemID = %d", menuItemID);
		Connect con = Connect.getInstance();
		con.rs = con.execQuery(query);
		try {
			if(con.rs.next()) {
				String menuItemName = con.rs.getString("menuItemName");
				String menuItemDescription = con.rs.getString("menuItemDescription");
				int menuItemPrice = con.rs.getInt("menuItemPrice");
				
				return new menuItem(menuItemID,menuItemName, menuItemDescription, menuItemPrice);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int getMenuItemID() {
		return menuItemID;
	}

	public void setMenuItemID(int menuItemID) {
		this.menuItemID = menuItemID;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getMenuItemDescription() {
		return menuItemDescription;
	}

	public void setMenuItemDescription(String menuItemDescription) {
		this.menuItemDescription = menuItemDescription;
	}

	public static int getMenuItemPrice() {
		return menuItemPrice;
	}

	public static void setMenuItemPrice(int menuItemPrice) {
		menuItem.menuItemPrice = menuItemPrice;
	}
	
	

}
