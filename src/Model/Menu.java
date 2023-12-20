package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Connect;

public class Menu {
	private String menuID;
	private String menuName;
	private String menuDescription;
	private int price;
	public Menu(String MenuID, String Menuname, String Menudescription, int Price) {
		// TODO Auto-generated constructor stub
		menuID = MenuID;
		menuName = Menuname;
		menuDescription = Menudescription;
		price = Price;
	}
	
	public void insert() {
		String query = String.format("INSERT INTO menu VALUES(\"%s\", \"%s\", \"%s\", %d)", this.menuID, this.menuName, this.menuDescription, this.price);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static void delete(String id) {
		String query = String.format("DELETE FROM `menu` WHERE `menuID` = \'%s\'", id);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static void update(String id, String name, String description, int price) {
		String query = String.format("UPDATE menu SET `menuName'=\'%s\', `menuDescription`=\'%s\', `menuPrice`=\'%s\'  WHERE `menuID` = \'%s\'", name, description, price, id);
		Connect con = Connect.getInstance();
		con.execUpdate(query);
	}
	
	public static ArrayList<Menu> getAllMenu(){
		ArrayList<Menu> menu = new ArrayList<>();
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM menu";
		con.rs = con.execQuery(query);
		
		try {
			while(con.rs.next()) {
				System.out.println("Masuk");
				String menuID = con.rs.getString("MenuID");
				String menuName = con.rs.getString("menuName");
				String menuDescription = con.rs.getString("menuDescription");
				int menuPrice = con.rs.getInt("price");
				menu.add(new Menu(menuID, menuName, menuDescription, menuPrice));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	

}
