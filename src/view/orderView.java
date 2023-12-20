package view;

import java.sql.Date;

import Model.Order;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class orderView {
	
	private TableView<Order> table;
	private TextField orderIDInput = new TextField();
	private TextField orderUserInput = new TextField();
	private TextField orderItemsInput = new TextField();
	private TextField orderStatusInput = new TextField();
	private TextField orderDateInput = new TextField();
	private TextField orderTotalInput = new TextField();
	
	private Button addButton;
	private Button updateButton;
	private Button deleteButton;
	
	private TableView<Order> createOrderTable(){
		TableView<Order> table = new TableView<>();
		TableColumn<Order, String> idInput = new TableColumn<>("Order ID");
		idInput.setCellValueFactory(new PropertyValueFactory<>("orderID")); //nama di sql nya
		TableColumn<Order, String> userInput = new TableColumn<>("User ID");
		userInput.setCellValueFactory(new PropertyValueFactory<>("userID"));
		TableColumn<Order, String> itemInput = new TableColumn<>("Order Items");
		itemInput.setCellValueFactory(new PropertyValueFactory<>("orderItem"));
		TableColumn<Order, String> statusInput = new TableColumn<>("Order Status");
		statusInput.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		TableColumn<Order, Date> dateInput = new TableColumn<>("Order Date");
		dateInput.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
		TableColumn<Order, Number> totalInput = new TableColumn<>("Order Total");
		totalInput.setCellValueFactory(new PropertyValueFactory<>("orderTotal"));
		
		table.getColumns().add(idInput);
		table.getColumns().add(userInput);
		table.getColumns().add(itemInput);
		table.getColumns().add(statusInput);
		table.getColumns().add(dateInput);
		table.getColumns().add(totalInput);
		return table;
	}
	
	private GridPane createOrderForm(TableView<Order> table) {
        GridPane form = new GridPane();
        form.setVgap(20);
        form.setHgap(10);
        
         addButton = new Button("Add");

         deleteButton = new Button("Delete");

         updateButton = new Button("Update");


        form.add(new Label("Menu ID:"), 0, 0);
//        idInput.setDisable(true);
        form.add(orderIDInput, 1, 0);
        form.add(new Label("User:"), 0, 1);
        form.add(orderUserInput, 1, 1);
        form.add(new Label("Item:"), 0, 2);
        form.add(orderItemsInput, 1, 2); 
        form.add(new Label("Status:"), 0, 3);
        form.add(orderStatusInput, 1, 3); 
        form.add(new Label("Date:"), 0, 4);
        form.add(orderDateInput, 1, 4); 
        form.add(new Label("Total:"), 0, 5);
        form.add(orderTotalInput, 1, 5); 
        form.add(addButton, 0, 6);
        form.add(deleteButton, 1, 6);
        form.add(updateButton, 0, 7);
        

        return form;
    }

	public orderView(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		VBox root = new VBox(); 
        table = createOrderTable();
        GridPane form = createOrderForm(table);
        VBox.setMargin(form, new Insets(20));
        root.getChildren().addAll(table, form);  
        Scene scene = new Scene(root, 800, 600); 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order Management");
        primaryStage.show();
	}

	public TableView<Order> getTable() {
		return table;
	}

	public void setTable(TableView<Order> table) {
		this.table = table;
	}

	public TextField getOrderIDInput() {
		return orderIDInput;
	}

	public void setOrderIDInput(TextField orderIDInput) {
		this.orderIDInput = orderIDInput;
	}

	public TextField getOrderUserInput() {
		return orderUserInput;
	}

	public void setOrderUserInput(TextField orderUserInput) {
		this.orderUserInput = orderUserInput;
	}

	public TextField getOrderItemsInput() {
		return orderItemsInput;
	}

	public void setOrderItemsInput(TextField orderItemsInput) {
		this.orderItemsInput = orderItemsInput;
	}

	public TextField getOrderStatusInput() {
		return orderStatusInput;
	}

	public void setOrderStatusInput(TextField orderStatusInput) {
		this.orderStatusInput = orderStatusInput;
	}

	public TextField getOrderDateInput() {
		return orderDateInput;
	}

	public void setOrderDateInput(TextField orderDateInput) {
		this.orderDateInput = orderDateInput;
	}

	public TextField getOrderTotalInput() {
		return orderTotalInput;
	}

	public void setOrderTotalInput(TextField orderTotalInput) {
		this.orderTotalInput = orderTotalInput;
	}

	public Button getAddButton() {
		return addButton;
	}

	public void setAddButton(Button addButton) {
		this.addButton = addButton;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(Button updateButton) {
		this.updateButton = updateButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(Button deleteButton) {
		this.deleteButton = deleteButton;
	}
	
	

}
