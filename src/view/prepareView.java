package view;

import Model.Order;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class prepareView {
	
	public TableView<Order> orderTable;
	public TextField orderId;
	private Label orderIDLabel, pendingOrderLabel;
	public Label idValidation, currValidation;
	public Label currLabel;
	
	public Button editButton, removeButton, prepareButton;
	
	public TableView<Order> createPrepareOrderTable(){
		orderTable = new TableView<>();

		TableColumn<Order, Number> orderID = new TableColumn<>("Order ID");
		orderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<Order, String> userID = new TableColumn<>("User ID");
		userID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        TableColumn<Order, String> orderStatus = new TableColumn<>("Status");
        orderStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        TableColumn<Order, String> orderDate = new TableColumn<>("Date");
        orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        TableColumn<Order, Double> orderTotal = new TableColumn<>("Total");
        orderTotal.setCellValueFactory(new PropertyValueFactory<>("orderTotal"));  
        
        orderTable.getColumns().add(orderID);
		orderTable.getColumns().add(userID);
		orderTable.getColumns().add(orderStatus);
        orderTable.getColumns().add(orderDate);
        orderTable.getColumns().add(orderTotal);
        
        currLabel = new Label("Current Selected Order ID: None");
        orderId = new TextField();
        orderIDLabel = new Label("OrderID");
        pendingOrderLabel = new Label("Pending Order Table");
        editButton  = new Button("Edit");
        removeButton = new Button("Remove");
        prepareButton = new Button("Prepare");
        
        idValidation = new Label("");
        currValidation  = new Label("");
        
        return orderTable;
        
	}
	
	public GridPane prepareOrder() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		form.add(pendingOrderLabel, 0, 0);
		form.add(orderTable, 0, 1);
		form.add(currLabel, 0, 2);
		form.add(orderIDLabel, 0, 3);
		form.add(orderId, 0, 3);
		form.add(idValidation, 1, 3);
		form.add(currValidation, 0, 4);
		form.add(editButton, 0, 5);
		form.add(removeButton, 1, 5);
		form.add(prepareButton, 2, 5);
		
		return form;
	}
}
