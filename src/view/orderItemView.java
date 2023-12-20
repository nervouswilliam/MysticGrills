package view;

import Model.OrderItem;
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

public class orderItemView {

	private TableView<OrderItem> table;
	private TextField orderIDInput = new TextField();
	private TextField menuNameInput = new TextField();
	private TextField orderQuantityInput = new TextField();
	private Button addButton;
	private Button updateButton;
	private Button deleteButton;
	
	private TableView<OrderItem> createOrderTable(){
		TableView<OrderItem> table = new TableView<>();
		TableColumn<OrderItem, String> idInput = new TableColumn<>("Order ID");
		idInput.setCellValueFactory(new PropertyValueFactory<>("orderID")); //nama di sql nya
		TableColumn<OrderItem, String> nameInput = new TableColumn<>("Menu Name");
		nameInput.setCellValueFactory(new PropertyValueFactory<>("menuName"));
		TableColumn<OrderItem, Number> quantityInput = new TableColumn<>("Order Quantity");
		quantityInput.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));
		
		table.getColumns().add(idInput);
		table.getColumns().add(nameInput);
		table.getColumns().add(quantityInput);
		return table;
	}
	
	private GridPane createOrderForm(TableView<OrderItem> table) {
        GridPane form = new GridPane();
        form.setVgap(20);
        form.setHgap(10);
        
         addButton = new Button("Add");

         deleteButton = new Button("Delete");

         updateButton = new Button("Update");


        form.add(new Label("Menu ID:"), 0, 0);
//        idInput.setDisable(true);
        form.add(orderIDInput, 1, 0);
        form.add(new Label("Name:"), 0, 1);
        form.add(menuNameInput, 1, 1);
        form.add(new Label("Quantity:"), 0, 2);
        form.add(orderQuantityInput, 1, 2); 
        form.add(addButton, 0, 3);
        form.add(deleteButton, 1, 3);
        form.add(updateButton, 0, 4);
        

        return form;
    }
	public orderItemView(Stage primaryStage) {
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

	public TableView<OrderItem> getTable() {
		return table;
	}

	public void setTable(TableView<OrderItem> table) {
		this.table = table;
	}

	public TextField getOrderIDInput() {
		return orderIDInput;
	}

	public void setOrderIDInput(TextField orderIDInput) {
		this.orderIDInput = orderIDInput;
	}

	public TextField getMenuNameInput() {
		return menuNameInput;
	}

	public void setMenuNameInput(TextField menuNameInput) {
		this.menuNameInput = menuNameInput;
	}

	public TextField getOrderQuantityInput() {
		return orderQuantityInput;
	}

	public void setOrderQuantityInput(TextField orderQuantityInput) {
		this.orderQuantityInput = orderQuantityInput;
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
