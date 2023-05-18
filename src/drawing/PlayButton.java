package drawing;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayButton extends VBox {

	public Button playButton;
	public Button playButton2;
	
	public PlayButton() {
		
		setPrefWidth(700);
		setPrefHeight(150);
		setAlignment(Pos.CENTER);
		setSpacing(100);
		
		playButton = new Button("PLAY 1");
		playButton2 = new Button("PLAY 2");
		playButton.setPrefWidth(150);
		playButton2.setPrefWidth(150);
		playButton.setFont(new Font(24));
		playButton2.setFont(new Font(24));
		
		playButton.setStyle("-fx-text-fill: #ffffff");
		playButton.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		playButton2.setStyle("-fx-text-fill: #ffffff");
		playButton2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		setUpButton();
		getChildren().addAll(playButton, playButton2);
	}
	
	public void setUpButton() {
		
		playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playButton.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			
		});
		
		playButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playButton.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			
		});
		playButton2.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playButton2.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			
		});
		
		playButton2.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				playButton2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		
		});
	}
}
