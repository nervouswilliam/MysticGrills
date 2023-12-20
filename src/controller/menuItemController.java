package controller;

import java.util.ArrayList;

import Model.Menu;
import Model.menuItem;
import view.menuItemView;

public class menuItemController {
	
	public static menuItem createMenuItem(String menuItemName, String menuItemDescription, int menuItemPrice) {
		return menuItem.createMenuItem(menuItemName, menuItemDescription, menuItemPrice);
	}
	
	public static void updateMenuItem(int menuItemID, String menuItemName, String menuItemDescription, int menuItemPrice) {
		menuItem.updateMenuItem(menuItemID, menuItemName, menuItemDescription, menuItemPrice);
	}
	
	public static void deleteMenuItem(int menuItemID) {
		menuItem.deleteMenuItem(menuItemID);
	}
	
	public static ArrayList<menuItem> getAllMenuItems(){
		return menuItem.getAllMenuItems();
	}
	
	public static menuItem getMenuItemByID(int menuItemID) {
		return menuItem.getMenuItemByID(menuItemID);
	}
	
//	menuItemView menuItem;
//	
//	private void initializeButtonHandler() {
//		menuItem.getAddButton().setOnAction(e ->{
//			String menuID = menuItem.getMenuIDInput().getText();
//			String menuName = menuItem.getMenuNameInput().getText();
//			String menuDescription = menuItem.getMenuDescriptionInput().getText();
//			int menuPrice = Integer.parseInt(menuItem.getMenuPriceInput().getText());
//			Menu menu = new Menu(menuID, menuName, menuDescription, menuPrice);
//			
//			menu.insert();
//			loadMenuData();
//		});
//		menuItem.getDeleteButton().setOnAction(e ->{
//			String menuID = menuItem.getMenuIDInput().getText();
//			String menuName = menuItem.getMenuNameInput().getText();
//			String menuDescription = menuItem.getMenuDescriptionInput().getText();
//			int menuPrice = Integer.parseInt(menuItem.getMenuPriceInput().getText());
////			Menu menu = new Menu(menuID, menuName, menuDescription, menuPrice);
//			
//			Menu.delete(menuID);
//			loadMenuData();
//		});
//		menuItem.getUpdateButton().setOnAction(e ->{
//			String menuID = menuItem.getMenuIDInput().getText();
//			String menuName = menuItem.getMenuNameInput().getText();
//			String menuDescription = menuItem.getMenuDescriptionInput().getText();
//			int menuPrice = Integer.parseInt(menuItem.getMenuPriceInput().getText());
////			Menu menu = new Menu(menuID, menuName, menuDescription, menuPrice);
//			
//			Menu.update(menuID, menuName, menuDescription, menuPrice);
//			loadMenuData();
//		});
//		
//		
//	}
//	
//	private void loadMenuData() {
//		ArrayList<Menu> menus = Menu.getAllMenu();
//		menuItem.getTable().getItems().setAll(menus);
//	}
//	
//	private void setupTableSelectionListener() {
//        menuItem.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                menuItem.getMenuIDInput().setText(newSelection.getMenuID());
//                menuItem.getMenuNameInput().setText(newSelection.getMenuName());
//                menuItem.getMenuDescriptionInput().setText(newSelection.getMenuDescription());
//                menuItem.getMenuPriceInput().setText(String.valueOf(newSelection.getPrice()));
//            }
//        });
//    }
//
//	public menuItemController(menuItemView menuItem) {
//		// TODO Auto-generated constructor stub
//		this.menuItem = menuItem;
//		initializeButtonHandler();
//		setupTableSelectionListener();
//		loadMenuData();
//	}

}
