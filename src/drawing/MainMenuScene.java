package drawing;

import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic2;

public class MainMenuScene {

	private Button playButton;
	private Canvas canvas;
	private GraphicsContext gc;
	private static StackPane root;
	private Stage stage;
	private PlayButton button;
	
	
	public MainMenuScene(Stage stage) {
		
		this.stage = stage;
		canvas = new Canvas(1000, 508);
		gc = canvas.getGraphicsContext2D();
		button = new PlayButton();
		RenderableHolder.mainMenuSong.play();
		setUp();
		
//		StackPane mainMenu = new StackPane();
//		String image_path = ClassLoader.getSystemResource("mainMenu.png").toString();
//		ImageView imageView = new ImageView(new Image(image_path));
//		
//		imageView.setPreserveRatio(true);
//		imageView.setFitWidth(600);
//		mainMenu.getChildren().add(imageView);
//		Scene scene = new Scene(mainMenu, 600, 450);
		
	}
	
	public void setBackground() {
		
		gc.drawImage(RenderableHolder.bg, 0, 0, 1000, 508);
		draw(gc);
		
	}
	
	public void draw(GraphicsContext gc) {
		
		root = new StackPane();
		root.setPrefSize(600, 400);
		root.getChildren().addAll(canvas, button);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Balloons Test");
		stage.setResizable(false);
		
	}
	
	public void setUp() {
		

		button.playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				RenderableHolder.onClicked.play();
				RenderableHolder.mainMenuSong.stop();
				StackPane mainMenu = (StackPane) canvas.getParent();
				mainMenu.getChildren().remove(canvas);
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
			
		});
		
		button.playButton2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				RenderableHolder.onClicked.play();
				RenderableHolder.mainMenuSong.stop();
				StackPane mainMenu = (StackPane) canvas.getParent();
				mainMenu.getChildren().remove(canvas);
				GameLogic2 logic = new GameLogic2();
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
			
		});
		
		setBackground();
		
	}
}
