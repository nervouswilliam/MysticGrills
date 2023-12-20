package view;

import Model.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class userManagementView {
	
	public TableView<User> userTable;
	public TextField userRole;
	public Label roleLabel, roleValidation;
	public Button updateButton, deleteButton;
	
	public TableView<User> userManagementTable(){
		TableColumn<User, Number> userID = new TableColumn<>("User ID");
		userID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		TableColumn<User, String> userRole = new TableColumn<>("User Role");
		userRole.setCellValueFactory(new PropertyValueFactory<>("userRole"));
		TableColumn<User, Number> userName = new TableColumn<>("User Name");
		userName.setCellValueFactory(new PropertyValueFactory<>("username"));
		TableColumn<User, Number> userEmail = new TableColumn<>("User Email");
		userEmail.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
		TableColumn<User, Number> userPassword = new TableColumn<>("UserPassword");
		userPassword.setCellValueFactory(new PropertyValueFactory<>("userPassword"));
		
		userTable.getColumns().add(userID);
		userTable.getColumns().add(userRole);
		userTable.getColumns().add(userName);
		userTable.getColumns().add(userEmail);
		userTable.getColumns().add(userPassword);
		
		return userTable;
		
	}
	
	public GridPane userManagementForm() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		updateButton = new Button("Update");
		deleteButton = new Button("Delete");
		roleLabel = new Label("Role: ");
		roleValidation = new Label("");
		
		form.add(roleLabel, 0, 0);
		form.add(userRole, 1, 1);
		form.add(roleValidation, 2, 1);
		form.add(updateButton, 0, 2);
		form.add(deleteButton, 1, 2);
		
		return form;
		
		
	}

	public TableView<User> getUserTable() {
		return userTable;
	}

	public void setUserTable(TableView<User> userTable) {
		this.userTable = userTable;
	}

	public TextField getUserRole() {
		return userRole;
	}

	public void setUserRole(TextField userRole) {
		this.userRole = userRole;
	}

	public Label getRoleLabel() {
		return roleLabel;
	}

	public void setRoleLabel(Label roleLabel) {
		this.roleLabel = roleLabel;
	}

	public Label getRoleValidation() {
		return roleValidation;
	}

	public void setRoleValidation(Label roleValidation) {
		this.roleValidation = roleValidation;
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
