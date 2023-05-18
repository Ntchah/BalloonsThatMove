package drawing;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Game1Scene extends Canvas {
	
	public Game1Scene() {
		
		StackPane mainMenu = new StackPane();

		GameLogic logic = new GameLogic();
		GamePanel gameScreen = new GamePanel(1000, 508);
		mainMenu.getChildren().add(gameScreen);
		gameScreen.requestFocus();

		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				
			}
		};
		animation.start();
	}
	
}
