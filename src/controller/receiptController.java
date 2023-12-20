package controller;

import java.util.ArrayList;

import Model.Order;
import Model.Receipt;

public class receiptController {

	public static Receipt createReceipt(Order order, String receiptPaymentType, int receiptPaymentAmount, String receiptPaymentDate) {
		return Receipt.createReceipt(order, receiptPaymentType, receiptPaymentAmount, receiptPaymentDate);
	}
	
	public static void updateReceipt(int orderID, String receiptPaymentType, int receiptPaymentAmount, String receiptPaymentDate) {
		Receipt.updateReceipt(orderID, receiptPaymentType, receiptPaymentAmount, receiptPaymentDate);
	}
	
	public void deleteReceipt(int orderID) {
		Receipt.deleteReceipt(orderID);
	}
	
	public static Receipt getReceiptByID(int receiptID) {
		return Receipt.getReceiptByID(receiptID);
	}
	
	public static ArrayList<Receipt> getAllReceipts(){
		return Receipt.getAllReceipts();
	}
}
