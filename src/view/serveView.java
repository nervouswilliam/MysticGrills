package view;

import Model.Order;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class serveView {
	public TableView<Order> pendingOrderTable, preparingOrderTable;
	public TextField orderID;
	private Label orderIDLabel, pendingOrderLabel, preparingOrderLabel;
	public Label idValidation, currValidation, currLabel;
	
	private HBox btnRow;
	public Button editButton, removeButton, serveButton;
	
	public TableView<Order> createPendingOrderTable(){
		pendingOrderTable = new TableView<>();
		
		TableColumn<Order, Number> pendingOrderID = new TableColumn<>("Order ID");
		pendingOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<Order, Number> pendingUserID = new TableColumn<>("User ID");
		pendingUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		TableColumn<Order, String> pendingOrderStatus = new TableColumn<>("Status");
		pendingOrderStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		TableColumn<Order, String> pendingOrderDate = new TableColumn<>("Date");
		pendingOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
		TableColumn<Order, Number> pendingOrderTotal = new TableColumn<>("Total");
		pendingOrderTotal.setCellValueFactory(new PropertyValueFactory<>("orderTotal"));
		
		pendingOrderTable.getColumns().add(pendingOrderID);
		pendingOrderTable.getColumns().add(pendingUserID);
		pendingOrderTable.getColumns().add(pendingOrderStatus);
		pendingOrderTable.getColumns().add(pendingOrderDate);
		pendingOrderTable.getColumns().add(pendingOrderTotal);
		
		return pendingOrderTable;
	}
	
	public TableView<Order> createPreparingOrderTable(){
		preparingOrderTable = new TableView<>();
		
		TableColumn<Order, Number> preparedOrderID = new TableColumn<>("Order ID");
		preparedOrderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<Order, Number> preparedUserID = new TableColumn<>("User ID");
		preparedUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		TableColumn<Order, Number> preparedOrderStatus = new TableColumn<>("Status");
		preparedOrderID.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		TableColumn<Order, Number> preparedOrderDate = new TableColumn<>("Date");
		preparedOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
		TableColumn<Order, Number> preparedOrderTotal = new TableColumn<>("Total");
		preparedOrderTotal.setCellValueFactory(new PropertyValueFactory<>("orderTotal"));
		
		preparingOrderTable.getColumns().add(preparedOrderID);
		preparingOrderTable.getColumns().add(preparedUserID);
		preparingOrderTable.getColumns().add(preparedOrderStatus);
		preparingOrderTable.getColumns().add(preparedOrderDate);
		preparingOrderTable.getColumns().add(preparedOrderTotal);
		
		return preparingOrderTable;
	}
	
	public GridPane serveOrder() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		currLabel = new Label("Current Selected Pending Order ID: None");
		orderID = new TextField();
		orderIDLabel = new Label("Prepared Order ID: ");
		
		pendingOrderLabel = new Label("Pending Orders Table");
		preparingOrderLabel = new Label("Prepared Orders Table");
		
		editButton = new Button("Edit");
		removeButton = new Button("Remove");
		serveButton = new Button("Serve");
		
		idValidation = new Label("");
		currValidation = new Label("");
		
		form.add(pendingOrderLabel, 0, 0);
		form.add(pendingOrderTable, 0, 1);
		form.add(preparingOrderLabel, 0, 2);
		form.add(preparingOrderTable, 0, 3);
		form.add(currLabel, 0, 4);
		form.add(orderIDLabel, 0, 5);
		form.add(orderID, 1, 5);
		form.add(idValidation, 2, 5);
		form.add(currValidation, 0, 6);
		form.add(editButton, 0, 7);
		form.add(removeButton, 1, 7);
		form.add(serveButton, 2, 7);
		
		return form;
	}
}
