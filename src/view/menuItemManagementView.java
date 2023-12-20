package view;

import Model.menuItem;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class menuItemManagementView {
	public TableView<menuItem> menuItemTable;
	public TextField menuItemName, description, price;
	public Label nameLabel, nameValidation, descriptionLabel, descriptionValidation, priceLabel, priceValidation;
	public Button insertButton, updateButton, deleteButton;
	public Integer currBrand = null;
	
	public TableView<menuItem> menuItemManagementTable(){ 
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
	
	public GridPane menuItemManagementForm() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		insertButton = new Button("Insert");
		updateButton = new Button("Update");
		deleteButton = new Button("Delete");
		nameLabel = new Label("Name: ");
		descriptionLabel = new Label("Description: ");
		priceLabel = new Label("Price: ");
		
		menuItemName = new TextField();
		description = new TextField();
		price = new TextField();
		
		form.add(menuItemTable, 0, 0);
		form.add(nameLabel, 0, 1);
		form.add(menuItemName, 1, 1);
		form.add(nameValidation, 2, 1);
		form.add(descriptionLabel, 0, 2);
		form.add(description, 1, 2);
		form.add(descriptionValidation, 2, 2);
		form.add(priceLabel, 0, 3);
		form.add(price, 1, 3);
		form.add(priceValidation, 2, 3);
		form.add(insertButton, 0, 4);
		form.add(updateButton, 1, 4);
		form.add(deleteButton, 2, 4);
		
		return form;
	}

	public TableView<menuItem> getMenuItemTable() {
		return menuItemTable;
	}

	public void setMenuItemTable(TableView<menuItem> menuItemTable) {
		this.menuItemTable = menuItemTable;
	}

	public TextField getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(TextField menuItemName) {
		this.menuItemName = menuItemName;
	}

	public TextField getDescription() {
		return description;
	}

	public void setDescription(TextField description) {
		this.description = description;
	}

	public TextField getPrice() {
		return price;
	}

	public void setPrice(TextField price) {
		this.price = price;
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(Label nameLabel) {
		this.nameLabel = nameLabel;
	}

	public Label getNameValidation() {
		return nameValidation;
	}

	public void setNameValidation(Label nameValidation) {
		this.nameValidation = nameValidation;
	}

	public Label getDescriptionLabel() {
		return descriptionLabel;
	}

	public void setDescriptionLabel(Label descriptionLabel) {
		this.descriptionLabel = descriptionLabel;
	}

	public Label getDescriptionValidation() {
		return descriptionValidation;
	}

	public void setDescriptionValidation(Label descriptionValidation) {
		this.descriptionValidation = descriptionValidation;
	}

	public Label getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(Label priceLabel) {
		this.priceLabel = priceLabel;
	}

	public Label getPriceValidation() {
		return priceValidation;
	}

	public void setPriceValidation(Label priceValidation) {
		this.priceValidation = priceValidation;
	}

	public Button getInsertButton() {
		return insertButton;
	}

	public void setInsertButton(Button insertButton) {
		this.insertButton = insertButton;
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

	public Integer getCurrBrand() {
		return currBrand;
	}

	public void setCurrBrand(Integer currBrand) {
		this.currBrand = currBrand;
	}
	
	
}
