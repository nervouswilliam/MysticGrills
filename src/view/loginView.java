package view;

import Model.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loginView {
	private TableView<User> table;
	private TextField emailInput = new TextField();
	private TextField passwordInput = new TextField();
	public Button loginButton, registerButton;
	public Label emailValidate, passwordValidate, generalValidate;
	
	private GridPane createUserForm() {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		loginButton = new Button("login");
		registerButton = new Button("Register");
		emailValidate = new Label("");
		passwordValidate = new Label("");
		generalValidate = new Label("");
		
		form.add(new Label("Email :"), 0, 0);
		form.add(emailInput, 1, 0);
		form.add(emailValidate, 2, 0);
		form.add(new Label("Password: "), 0, 1);
		form.add(passwordInput, 1, 1);
		form.add(passwordValidate, 2, 1);
		form.add(loginButton, 0, 2);
		form.add(registerButton, 1, 2);
		return form;
	}

	public loginView(Stage primaryStage) {
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

	public TextField getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(TextField emailInput) {
		this.emailInput = emailInput;
	}

	public TextField getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(TextField passwordInput) {
		this.passwordInput = passwordInput;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}
	

}
