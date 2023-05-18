package application;

import javafx.application.Application;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;

public class Test2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 1000, 508);
		
		ImageView imageView = new ImageView("sniper.png");
		Rotate rotate = new Rotate(45, RenderableHolder.monkey.getWidth() / 2, RenderableHolder.monkey.getHeight() / 2);
		imageView.getTransforms().add(rotate);
		
		root.getChildren().add(imageView);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}

	public static void main(String[] args) {
		
		Application.launch(args);
	}
}
