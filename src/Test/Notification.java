package Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Notification extends Application {
	private static String notification;
	@Override
	public void start(Stage primaryStage) throws Exception {
        Label my_label=new Label(notification);  
        StackPane root = new StackPane();   
        Scene scene=new Scene(root, 300, 100);  
        root.getChildren().add(my_label);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Label Class Example");  
        primaryStage.show();  
    }
	public static void show(String notification) {
		Notification.notification = notification;
		launch();
	}
}
