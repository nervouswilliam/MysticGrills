package view;

import Model.Menu;
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


public class menuItemView {
	
	private TableView<Menu> table;
	private TextField menuIDInput = new TextField();
	private TextField menuNameInput = new TextField();
	private TextField menuDescriptionInput = new TextField();
	private TextField menuPriceInput = new TextField();
	private Button addButton;
	private Button updateButton;
	private Button deleteButton;
	
	private TableView<Menu> createMenuTable(){
		TableView<Menu> table = new TableView<>();
		TableColumn<Menu, String> idInput = new TableColumn<>("Menu ID");
		idInput.setCellValueFactory(new PropertyValueFactory<>("menuID"));
		TableColumn<Menu, String> nameInput = new TableColumn<>("Menu Name");
		nameInput.setCellValueFactory(new PropertyValueFactory<>("menuName"));
		TableColumn<Menu, Number> descriptionInput = new TableColumn<>("Description");
		descriptionInput.setCellValueFactory(new PropertyValueFactory<>("menuDescription"));
		TableColumn<Menu, Number> priceInput = new TableColumn<>("Price");
		priceInput.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		table.getColumns().add(idInput);
		table.getColumns().add(nameInput);
		table.getColumns().add(descriptionInput);
		table.getColumns().add(priceInput);
		return table;
	}
	
	private GridPane createMenuForm(TableView<Menu> table) {
        GridPane form = new GridPane();
        form.setVgap(20);
        form.setHgap(10);
        
         addButton = new Button("Add");

         deleteButton = new Button("Delete");

         updateButton = new Button("Update");


        form.add(new Label("Menu ID:"), 0, 0);
//        idInput.setDisable(true);
        form.add(menuIDInput, 1, 0);
        form.add(new Label("Name:"), 0, 1);
        form.add(menuNameInput, 1, 1);
        form.add(new Label("Description:"), 0, 2);
        form.add(menuDescriptionInput, 1, 2); 
        form.add(new Label("Price:"), 0, 3);
        form.add(menuPriceInput, 1, 3);
        form.add(addButton, 0, 4);
        form.add(deleteButton, 1, 4);
        form.add(updateButton, 0, 5);
        

        return form;
    }

	
	
	public menuItemView(Stage primaryStage) {
		// TODO Auto-generated constructor stub
		VBox root = new VBox(); 
        table = createMenuTable();
        GridPane form = createMenuForm(table);
        VBox.setMargin(form, new Insets(20));
        root.getChildren().addAll(table, form);  
        Scene scene = new Scene(root, 800, 600); 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Product Management");
        primaryStage.show();
	}

	public TableView<Menu> getTable() {
		return table;
	}

	public void setTable(TableView<Menu> table) {
		this.table = table;
	}

	public TextField getMenuIDInput() {
		return menuIDInput;
	}

	public void setMenuIDInput(TextField menuIDInput) {
		this.menuIDInput = menuIDInput;
	}

	public TextField getMenuNameInput() {
		return menuNameInput;
	}

	public void setMenuNameInput(TextField menuNameInput) {
		this.menuNameInput = menuNameInput;
	}

	public TextField getMenuDescriptionInput() {
		return menuDescriptionInput;
	}

	public void setMenuDescriptionInput(TextField menuDescriptionInput) {
		this.menuDescriptionInput = menuDescriptionInput;
	}

	public TextField getMenuPriceInput() {
		return menuPriceInput;
	}

	public void setMenuPriceInput(TextField menuPriceInput) {
		this.menuPriceInput = menuPriceInput;
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
