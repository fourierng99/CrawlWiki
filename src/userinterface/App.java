package userinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {
	private static Stage appStage;
	private static Scene currentScene;
	private static Map<Scene, Scene> prevSceneMap;
	private static int sceneHeight;
	private static int sceneWidth;
	
	@Override
	public void start(Stage appStage) throws Exception {
		// initialize values for properties
		sceneHeight = 900;
		sceneWidth = 1600;
		App.appStage = appStage;
		currentScene = HomeScene.buildScene();
		prevSceneMap = new HashMap<Scene, Scene>();
		
		appStage.setTitle("Tra cứu lịch sử Việt Nam");
		appStage.setScene(currentScene);
		appStage.show();
	}
	public static int getSceneHeight() {
		return sceneHeight;
	}
	public static int getSceneWidth() {
		return sceneWidth;
	}
	public static void alertMessage(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Tin nhắn từ ứng dụng");
		alert.setHeaderText(message);
		alert.showAndWait();
	}
	public static void setScene(Scene newScene) {
		prevSceneMap.put(newScene, currentScene);
		currentScene = newScene;
		appStage.setScene(currentScene);
		appStage.show();
	}
	public static void backToPrevScene() {
		currentScene = prevSceneMap.get(currentScene);
		appStage.setScene(currentScene);
		appStage.show();
	}
	public static void main(String[] args) {
		
		launch();
	}
}
