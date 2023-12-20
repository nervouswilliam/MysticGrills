package view;

import Model.Order;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class orderedMenuItemView{
	
	private TableView<Order> orderTable;
	public Label select;
	public Label menuItemLabel;
	public Label cartLabel;
	public Label quantityLabel;
	public Label selectedValidation;
	
	public Button editButton;
	
	private TableView<Order> createOrderTable(){
		TableView<Order> table = new TableView<>();
		TableColumn<Order, String> orderIDColumn = new TableColumn<>("Order ID");
		orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<Order, String> orderStatusColumn = new TableColumn<>("Order Status");
		orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		TableColumn<Order, String> orderDateColumn = new TableColumn<>("Order Date");
		orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
		TableColumn<Order, String> orderTotalColumn = new TableColumn<>("Order Total");
		orderTotalColumn.setCellValueFactory(new PropertyValueFactory<>("orderTotal"));
		
		table.getColumns().add(orderIDColumn);
		table.getColumns().add(orderStatusColumn);
		table.getColumns().add(orderDateColumn);
		table.getColumns().add(orderTotalColumn);
		return table;
	}
	
	private GridPane buttonPlacement() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		menuItemLabel = new Label("Menu Item Table");
		cartLabel = new Label("Cart Order");
		quantityLabel = new Label("Quantity: ");
		select = new Label("Selected Item:");
		selectedValidation = new Label("");
		
		editButton = new Button("Edit");
		
		
		form.add(editButton, 0, 0);
		return form;
	}

	public orderedMenuItemView(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		
		VBox root = new VBox();
//		table = createUserTable();
		GridPane form = buttonPlacement();
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(form);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ordered Menu");
		primaryStage.show();
	}

	public TableView<Order> getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(TableView<Order> orderTable) {
		this.orderTable = orderTable;
	}

	public Label getSelect() {
		return select;
	}

	public void setSelect(Label select) {
		this.select = select;
	}

	public Label getMenuItemLabel() {
		return menuItemLabel;
	}

	public void setMenuItemLabel(Label menuItemLabel) {
		this.menuItemLabel = menuItemLabel;
	}

	public Label getCartLabel() {
		return cartLabel;
	}

	public void setCartLabel(Label cartLabel) {
		this.cartLabel = cartLabel;
	}

	public Label getQuantityLabel() {
		return quantityLabel;
	}

	public void setQuantityLabel(Label quantityLabel) {
		this.quantityLabel = quantityLabel;
	}

	public Label getSelectedValidation() {
		return selectedValidation;
	}

	public void setSelectedValidation(Label selectedValidation) {
		this.selectedValidation = selectedValidation;
	}

	public Button getEditButton() {
		return editButton;
	}

	public void setEditButton(Button editButton) {
		this.editButton = editButton;
	}
	
	

}
