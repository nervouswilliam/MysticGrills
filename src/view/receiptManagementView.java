package view;

import Model.OrderItem;
import Model.Receipt;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class receiptManagementView {
	public TableView<Receipt> receiptTable;
	public TableView<OrderItem> orderItemTable;
	public Label receiptLabel, receiptDetailLabel ,currLabel;
	
	
	public TableView<Receipt> receiptManagementTable(){
		receiptTable = new TableView<>();
		
		receiptLabel = new Label("Receipt");
		receiptDetailLabel = new Label("Receipt Details: ");
		currLabel = new Label("Current selected ReceiptID: None");
		
		TableColumn<Receipt, Number> receiptID = new TableColumn<>("Receipt ID");
		receiptID.setCellValueFactory(new PropertyValueFactory<>("receiptID"));
		TableColumn<Receipt, Number> orderID = new TableColumn<>("Order ID");
		orderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<Receipt, Number> receiptPaymentAmount = new TableColumn<>("Amount");
		receiptPaymentAmount.setCellValueFactory(new PropertyValueFactory<>("receiptPaymentAmount"));
		TableColumn<Receipt, String> receiptPaymentDate = new TableColumn<>("Date");
		receiptPaymentDate.setCellValueFactory(new PropertyValueFactory<>("receiptPaymentDate"));
		TableColumn<Receipt, String> receiptPaymentType = new TableColumn<>("Payment Type");
		receiptPaymentType.setCellValueFactory(new PropertyValueFactory<>("receiptPaymentType"));
		
		receiptTable.getColumns().add(receiptID);
		receiptTable.getColumns().add(orderID);
		receiptTable.getColumns().add(receiptPaymentAmount);
		receiptTable.getColumns().add(receiptPaymentDate);
		receiptTable.getColumns().add(receiptPaymentType);
		
		
		
		return receiptTable;
	}
	
	public TableView<OrderItem> orderItemManagementTable(){
		orderItemTable = new TableView<>();
		
		TableColumn<OrderItem, Number> orderId = new TableColumn<>("OrderID");
		orderId.setCellValueFactory(new PropertyValueFactory<>("orderID"));
		TableColumn<OrderItem, Number> name = new TableColumn<>("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));
		TableColumn<OrderItem, Number> price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("menuItemPrice"));
		TableColumn<OrderItem, Number> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		orderItemTable.getColumns().add(orderId);
		orderItemTable.getColumns().add(name);
		orderItemTable.getColumns().add(price);
		orderItemTable.getColumns().add(quantity);
		
		return orderItemTable;
	}
	
	public GridPane receiptManagementForm() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		form.add(receiptLabel, 0, 0);
		form.add(receiptTable, 0, 1);		
		form.add(receiptDetailLabel, 0, 2);
		form.add(orderItemTable, 0, 3);
		
		return form;
	}

	public TableView<Receipt> getReceiptTable() {
		return receiptTable;
	}

	public void setReceiptTable(TableView<Receipt> receiptTable) {
		this.receiptTable = receiptTable;
	}

	public TableView<OrderItem> getOrderItemTable() {
		return orderItemTable;
	}

	public void setOrderItemTable(TableView<OrderItem> orderItemTable) {
		this.orderItemTable = orderItemTable;
	}

	public Label getReceiptLabel() {
		return receiptLabel;
	}

	public void setReceiptLabel(Label receiptLabel) {
		this.receiptLabel = receiptLabel;
	}

	public Label getReceiptDetailLabel() {
		return receiptDetailLabel;
	}

	public void setReceiptDetailLabel(Label receiptDetailLabel) {
		this.receiptDetailLabel = receiptDetailLabel;
	}

	public Label getCurrLabel() {
		return currLabel;
	}

	public void setCurrLabel(Label currLabel) {
		this.currLabel = currLabel;
	}
	
	
}
