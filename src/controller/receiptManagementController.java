package controller;

import java.util.ArrayList;

import Model.OrderItem;
import Model.Receipt;
import view.receiptManagementView;

public class receiptManagementController {
	receiptManagementView view = new receiptManagementView();
	Receipt currReceipt = null;
	
	public void setupTableListener() {
		view.receiptTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection != null) {
				int orderID = newSelection.getOrderID();
				currReceipt = new Receipt(orderID, newSelection.getReceiptOrder(), newSelection.getReceiptPaymentAmount(), newSelection.getReceiptPaymentDate(), newSelection.getReceiptPaymentType());
				view.currLabel.setText("Current Selected Receipt ID: "+orderID);
			}
			loadOrderItemData();
		});
	}
	
	public void loadOrderItemData() {
		if(currReceipt != null) {
			ArrayList<OrderItem> orderItemList = orderItemController.getAllOrderByOrderID(currReceipt.getOrderID());
			view.orderItemTable.getItems().setAll(orderItemList);
		}
	}
	
	public void loadReceiptData() {
		ArrayList<Receipt> receiptList  = receiptController.getAllReceipts();
		view.receiptTable.getItems().setAll(receiptList);
	}
	
	public receiptManagementController() {
		setupTableListener();
		loadOrderItemData();
		loadReceiptData();
	}
}
