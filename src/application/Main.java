package application;


import javafx.application.Application;
import javafx.stage.Stage;
import drawing.MainMenuScene;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		
		MainMenuScene start = new MainMenuScene(stage);
		stage.show();
		
		

	}
	public static void main(String[] args) {
		
		Application.launch(args);
		
	}

}
