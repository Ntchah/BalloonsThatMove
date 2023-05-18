package character;

import input.InputUtility;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.GameLogic;
import logic.GameLogic2;
import logic.Utility;
import sharedObject.RenderableHolder;
import javafx.scene.transform.*;
import javafx.util.Duration;

public class Monkey extends CollidableEntity {

	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	private int angle = -90;
	private int game;
	public static final int ATKRANGE = 100;
	
	public Monkey(int x, int y, int game) {
		this.x = x;
		this.y = y;
		this.z = -100;
		this.radius = 20;
		this.game = game;
	}
	
	public void shoot() {
		
		switch (game) {
		
		case 1 :
			Bullet b = new Bullet(this.x, this.y, this, 1);
			RenderableHolder.getInstance().add(b);
			GameLogic.bulletInField.add(b);
			break;
			
		case 2 :
			for (Balloon balloons : GameLogic2.balloonInField) {
				if (Utility.getObjectDistance(this, balloons) <= Monkey.ATKRANGE) {
						Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1500), event -> {
						Bullet c = new Bullet(this.x, this.y, this, 2);
						RenderableHolder.getInstance().add(c);
						GameLogic.bulletInField.add(c);
						System.out.println("Shoot");
					}));
					timeline.setCycleCount(Timeline.INDEFINITE);
					timeline.play();
					System.out.println("Work");
				}
			}
			break;
		}

		

		
	}
	
	
	private void turn(boolean left) {
		if (left) {
			angle -= 3;
			if (angle < 0)
				angle += 360;
		} else {
			angle += 3;
			if (angle >= 360)
				angle -= 360;
		}
		
	}
	
	
	public void update() {

		switch (game) {
		
		case 1 :
			if (InputUtility.getKeyPressed(KeyCode.A)) {
				turn(true);
			} else if (InputUtility.getKeyPressed(KeyCode.D)) {
				turn(false);
			} if (InputUtility.getKeyPressed(KeyCode.SPACE)) {
				shoot();
			}
			 break;
		
		case 2 :
			
			for (Balloon balloon : GameLogic2.balloonInField) {
				if (Utility.getObjectDistance(this, balloon) <= ATKRANGE) {
					this.angle = (int) Utility.turningDegree(this, balloon);
					System.out.println(angle);


				}
			}
			
		}
		
	}
	
	@Override
	public int getZ() {
		return -100;
	}
	@Override
	public void draw(GraphicsContext gc) {
		
		switch (game) {
		
		case 1 :
			
//			gc.drawImage(RenderableHolder.monkey, x - radius, y - radius);
			
			ImageView imageView = new ImageView(RenderableHolder.monkey);
			Rotate rotate = new Rotate(angle + 90, RenderableHolder.monkey.getWidth() / 2, RenderableHolder.monkey.getHeight());
			
			rotate.setPivotX(RenderableHolder.monkey.getWidth() / 2);
			rotate.setPivotY(RenderableHolder.monkey.getHeight());
			imageView.getTransforms().add(rotate);
			
			WritableImage rotatedImage = imageView.snapshot(null, null);
			
			gc.drawImage(rotatedImage, x - radius, y - radius);
			break;
			
		case 2 :
//			gc.drawImage(RenderableHolder.monkey2, x - radius, y - radius);
			
			ImageView imageView2 = new ImageView(RenderableHolder.monkey2);
			Rotate rotate2 = new Rotate(angle + 90, RenderableHolder.monkey2.getWidth() / 2, RenderableHolder.monkey2.getHeight());
			
			rotate2.setPivotX(RenderableHolder.monkey2.getWidth() / 2);
			rotate2.setPivotY(RenderableHolder.monkey2.getHeight());
			imageView2.getTransforms().add(rotate2);
			
			WritableImage rotatedImage2 = imageView2.snapshot(null, null);
			
			gc.drawImage(rotatedImage2, x - radius, y - radius);
			break;
		}

		
		
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	
}
