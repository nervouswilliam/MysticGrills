package Main;

import Model.User;
import controller.loginController;
import controller.menuItemController;
import controller.orderItemController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import view.loginView;
import view.menuItemView;
import view.orderItemView;
import view.registerView;

public class Main extends Application{

	public static Stage mainStage;
	public static String currUserRole = "Admin";
	public static Integer currUserID = 2;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		mainStage = primaryStage;
		mainStage.setTitle("Mystic Grills");
		new loginController();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
