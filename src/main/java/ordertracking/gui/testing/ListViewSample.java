package ordertracking.gui.testing;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class ListViewSample extends Application {

	public static final ObservableList<String> names = FXCollections
			.observableArrayList();
	public static final ObservableList<String> data = FXCollections
			.observableArrayList();

	final Label label = new Label();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("List View Sample");

		final ListView<String> listView = new ListView<String>(data);
		listView.setPrefSize(200, 250);
		listView.setEditable(true);

		names.addAll("Adam", "Alex", "Alfred", "Albert", "Brenda", "Connie",
				"Derek", "Donny", "Lynne", "Myrtle", "Rose", "Rudolph", "Tony",
				"Trudy", "Williams", "Zach");

		listView.setItems(names);

		label.setLayoutX(10);
		label.setLayoutY(115);
		label.setFont(Font.font("Verdana", 20));

		listView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {
					public void changed(ObservableValue<? extends String> ov,
							String old_val, String new_val) {
						label.setText(new_val);
						System.out.println(listView.getSelectionModel()
								.getSelectedItem());
						System.out.println("Old val = " + old_val
								+ ", new val = " + new_val);

					}
				});

		StackPane root = new StackPane();
		root.getChildren().addAll(listView, label);
		primaryStage.setScene(new Scene(root, 200, 250));
		primaryStage.show();
	}
}