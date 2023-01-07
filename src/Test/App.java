package Test;

import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
	public static void run() {
		launch();
	}
	public void start(Stage stage) {
		Text searchHeader = new Text("Tìm kiếm mọi thứ");
		TextField searchInput = new TextField();		
		FlowPane search = new FlowPane(searchHeader, searchInput);
		
		GridPane gp = new GridPane();
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		Button b4 = new Button("b4");
		Button b5 = new Button("b5");
		Button b6 = new Button("b6");
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		gp.add(b4, 1, 1);
		gp.add(b5, 0, 2);
		
		
		
		GridPane gp2 = new GridPane();
		gp2.add(search, 0, 0);
		gp2.add(gp, 0, 1);
		
		Scene scene = new Scene(gp2);
		Scene scene2 = new Scene(b6);
		
		b1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stage.setScene(scene2);
			}
		});
		
		b6.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stage.setScene(scene);
			}
		});
		//Setting title to the Stage
		stage.setTitle("CSS Example");
		//Adding scene to the stage
		stage.setScene(scene);
		//Displaying the contents of the stage
		stage.show();
		
		System.out.print("Hello Me");
	}
}
