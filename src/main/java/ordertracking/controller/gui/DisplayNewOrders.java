package ordertracking.controller.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class DisplayNewOrders {

//	private final TableView<Person> table = new TableView<>();
//
////	public static void main(String[] args) {
////		launch(args);
////	}
//
//	private ObservableList<Person> getData() {
//		// List<Person> data = new ArrayList<Person>();
//		// data.add(new Person("Jacob", "Smith", "jacob.smith@example.com"));
//		// data.add(new Person("Isabella", "Johnson",
//		// "isabella.johnson@example.com"));
//		// return data;
//		ObservableList<Person> data = FXCollections.observableArrayList(
//				new Person("Jacob", "Smith", "jacob.smith@example.com"),
//				new Person("Isabella", "Johnson",
//						"isabella.johnson@example.com"), new Person("Ethan",
//						"Williams", "ethan.williams@example.com"), new Person(
//						"Emma", "Jones", "emma.jones@example.com"), new Person(
//						"Michael", "Brown", "michael.brown@example.com"));
//		return data;
//	}
//
//
//	
//	public Scene getNewOrders() {
//		//Stage stage = new Stage();
//		Scene scene = new Scene(new Group());
////		stage.setTitle("Table View Sample");
////		stage.setWidth(450);
////		stage.setHeight(500);
//
//		final Label label = new Label("Address Book");
//		label.setFont(new Font("Arial", 20));
//
//		table.setEditable(false);
//
//		TableColumn firstNameCol = new TableColumn("First Name");
//		firstNameCol.setMinWidth(100);
//		firstNameCol
//				.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//
//		TableColumn lastNameCol = new TableColumn("Last Name");
//		lastNameCol.setMinWidth(100);
//		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//
//		TableColumn emailCol = new TableColumn("Email");
//		emailCol.setMinWidth(200);
//		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//		table.setItems(getData());
//		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
//
//        //Add change listener
//        table.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//            //Check whether item is selected and set value of selected item to Label
//            if (table.getSelectionModel().getSelectedItem() != null) {
//            	label.setText(newValue.getFirstName());
//            }
//        });
//
//		final VBox vbox = new VBox();
//		vbox.setSpacing(5);
//		vbox.setPadding(new Insets(10, 0, 0, 10));
//		vbox.getChildren().addAll(label, table);
//
//		((Group) scene.getRoot()).getChildren().addAll(vbox);
//
//		//stage.setScene(scene);
//		//stage.show();
//		return scene;
//	}

}