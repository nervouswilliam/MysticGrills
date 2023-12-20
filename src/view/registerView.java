package view;

import Model.User;
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

public class registerView {
	private TableView<User> table;
	private TextField userID = new TextField();
	private TextField usernameInput = new TextField();
	private TextField EmailInput = new TextField();
	private TextField passwordInput = new TextField();
	private TextField confirmPasswordInput = new TextField();
	private TextField roleInput = new TextField();
	public Button registerButton, loginButton;
	
	public Label nameValidate, emailValidate, passwordValidate, confirmPasswordValidate;
	
//	private TableView<User> createUserTable(){
//		TableView<User> table = new TableView<>();
//		TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
//		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
//		TableColumn<User, String> emailColumn = new TableColumn<>("Email");
//		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//		TableColumn<User, String> passwordColumn = new TableColumn<>("Password");
//		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
//		TableColumn<User, String> confirmPasswordColumn = new TableColumn<>("Confirm Password");
//		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("confirmpassword"));
//		
//		table.getColumns().add(usernameColumn);
//		table.getColumns().add(emailColumn);
//		table.getColumns().add(passwordColumn);
//		table.getColumns().add(confirmPasswordColumn);
//		return table;
//	}
	
	private GridPane createUserForm() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		registerButton = new Button("register");
		loginButton = new Button("Login");
		
		nameValidate = new Label("");
		emailValidate = new Label("");
		passwordValidate = new Label("");
		confirmPasswordValidate = new Label("");
		
		form.add(new Label("User ID :"), 0, 0);
		form.add(userID, 1, 0);
		form.add(new Label("Username: "), 0, 1);
		form.add(usernameInput, 1, 1);
		form.add(nameValidate, 2, 1);
		form.add(new Label("Email :"), 0, 2);
		form.add(EmailInput, 1, 2);
		form.add(emailValidate, 2, 0);
		form.add(new Label("Passwprd: "), 0, 3);
		form.add(passwordInput, 1, 3);
		form.add(passwordValidate, 2, 3);
		form.add(new Label("Confirm Passwprd: "), 0, 4);
		form.add(confirmPasswordInput, 1, 4);
		form.add(confirmPasswordValidate, 2, 4);
		
		form.add(registerButton, 0, 5);
		return form;
	}

	public registerView(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		VBox root = new VBox();
//		table = createUserTable();
		GridPane form = createUserForm();
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(form);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mystic Grills");
		primaryStage.show();
	}

	public TableView<User> getTable() {
		return table;
	}

	public void setTable(TableView<User> table) {
		this.table = table;
	}

	public TextField getUserID() {
		return userID;
	}

	public void setUserID(TextField userID) {
		this.userID = userID;
	}

	public TextField getUsernameInput() {
		return usernameInput;
	}

	public void setUsernameInput(TextField usernameInput) {
		this.usernameInput = usernameInput;
	}

	public TextField getEmailInput() {
		return EmailInput;
	}

	public void setEmailInput(TextField emailInput) {
		EmailInput = emailInput;
	}

	public TextField getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(TextField passwordInput) {
		this.passwordInput = passwordInput;
	}

	public TextField getConfirmPasswordInput() {
		return confirmPasswordInput;
	}

	public void setConfirmPasswordInput(TextField confirmPasswordInput) {
		this.confirmPasswordInput = confirmPasswordInput;
	}

	public Button getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(Button registerButton) {
		this.registerButton = registerButton;
	}

	public TextField getRoleInput() {
		return roleInput;
	}

	public void setRoleInput(TextField roleInput) {
		this.roleInput = roleInput;
	}
	
	

}
