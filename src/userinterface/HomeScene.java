package userinterface;

import java.io.InputStream;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeScene {
	public static Scene buildScene() {
		BorderPane bp = new BorderPane();
		
		// Search input
		//TextField searchInput = new TextField();
		//searchInput.setPromptText("Tìm kiếm tất cả mọi thứ ở đây");
		//searchInput.setFocusTraversable(false);
		//bp.setTop(searchInput);
		
		// Label
		Label ll = new Label("Tra cuu lich su");
		bp.setTop(ll);
		ll.setFont(new Font("Arial", 30));
		ll.setPadding(new Insets(100));
		BorderPane.setAlignment(ll, Pos.CENTER);
		//ll.setAlignment(Pos.CENTER);
		
		// list of categories
		FlowPane fp = new FlowPane();
		
		fp.setPadding(new Insets(60));
		fp.setVgap(100);
	    fp.setHgap(100);
	    fp.setMaxWidth(990);
		Class<?> homeSceneClass = HomeScene.class;
		for (int i = 0; i < 5; i++) {
			VBox g = new VBox();
			InputStream input = homeSceneClass.getResourceAsStream("/userinterface/image" + i + ".jpg");
			Image image = new Image(input, 200, 200, false, true);
	        ImageView imageView = new ImageView(image);
	        g.getChildren().add(imageView);
	        Label l = new Label("Image" + (i + 1));
	        g.getChildren().add(l);
	        g.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			g.setPadding(new Insets(10));
	        fp.getChildren().addAll(g);
	        g.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					App.setScene(ListEntityScene.buildScene());
				}
			});
	        //fp.getChildren().add(imageView);
		}
		bp.setCenter(fp);
	
		return new Scene(bp, App.getSceneWidth(), App.getSceneHeight());
	}
}
