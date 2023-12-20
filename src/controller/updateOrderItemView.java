package controller;

import Model.OrderItem;
import Model.menuItem;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class updateOrderItemView {
	public TextField menuItemQuantity;
	public Label menuItemLabel, orderItemLabel;
	private Label menuItemQuantityLabel;
	public Label quantityValidation, currValidation;
	public Label currMenuItemLabel, currOrderItemLabel;
	
	public TableView<menuItem> menuItemTable;
	public TableView<OrderItem> orderItemTable;
	
	public Button addButton, saveButton, changeButton;
	
	public TableView<menuItem> updateOrderItemTable(){
		menuItemTable = new TableView<>();
		
		TableColumn<menuItem, Number> menuItemID = new TableColumn<>("Menu Item ID");
		menuItemID.setCellValueFactory(new PropertyValueFactory<>("menuItemID"));
		TableColumn<menuItem, String> menuItemName = new TableColumn<>("Menu Item Name");
		menuItemName.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));
		TableColumn<menuItem, String> menuItemDescription = new TableColumn<>("Menu Item Description");
		menuItemDescription.setCellValueFactory(new PropertyValueFactory<>("menuItemDescription"));
		TableColumn<menuItem, Number> menuItemPrice = new TableColumn<>("Menu Item Price");
		menuItemPrice.setCellValueFactory(new PropertyValueFactory<>("menuItemPrice"));
		
		menuItemTable.getColumns().add(menuItemID);
		menuItemTable.getColumns().add(menuItemName);
		menuItemTable.getColumns().add(menuItemDescription);
		menuItemTable.getColumns().add(menuItemPrice);
		
		return menuItemTable;
	}
	
	public TableView<OrderItem> updateMenuItemTable(){
		orderItemTable = new TableView<>();
		
		TableColumn<OrderItem, String> orderItemName = new TableColumn<>("Order Item Name");
		orderItemName.setCellValueFactory(new PropertyValueFactory<>("orderItemName"));
		TableColumn<OrderItem, String> orderItemDescription = new TableColumn<>("Order Item Description");
		orderItemDescription.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));
		TableColumn<OrderItem, Number> orderItemPrice = new TableColumn<>("Order Item Price");
		orderItemPrice.setCellValueFactory(new PropertyValueFactory<>("orderItemPrice"));
		TableColumn<OrderItem, Number> orderItemQuantity = new TableColumn<>("Order Item Quantity");
		orderItemQuantity.setCellValueFactory(new PropertyValueFactory<>("orderItemQuantity"));
		
		orderItemTable.getColumns().add(orderItemName);
		orderItemTable.getColumns().add(orderItemDescription);
		orderItemTable.getColumns().add(orderItemPrice);
		orderItemTable.getColumns().add(orderItemQuantity);
		
		return orderItemTable;
	}
	
	public GridPane updateOrderItem() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		menuItemLabel = new Label("Menu Item Table");
		orderItemLabel = new Label("OrderItem Table");
		
		menuItemQuantityLabel = new Label("Quantity: ");
		currMenuItemLabel = new Label("Current Selected menu Item ID: None");
		currOrderItemLabel = new Label("Current Selected Order Item ID: None");
		
		addButton = new Button("Add");
		saveButton = new Button("Save");
		changeButton = new Button("Change");
		
		menuItemQuantity = new TextField();
		quantityValidation = new Label("");
		currValidation = new Label("");
		
		form.add(menuItemLabel, 0, 0);
		form.add(menuItemTable, 0, 1);
		form.add(orderItemLabel, 0, 2);
		form.add(orderItemTable, 0, 3);
		form.add(currMenuItemLabel, 0, 4);
		form.add(currOrderItemLabel, 0, 5);
		form.add(menuItemQuantityLabel, 0, 6);
		form.add(menuItemQuantity, 1, 6);
		form.add(quantityValidation, 2, 6);
		form.add(currValidation, 0, 7);
		form.add(addButton, 0, 8);
		form.add(changeButton, 1, 8);
		form.add(saveButton, 2, 8);
		
		return form;	
	}
}
