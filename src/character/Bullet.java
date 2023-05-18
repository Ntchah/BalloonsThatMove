package character;

import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic2;
import sharedObject.RenderableHolder;

public class Bullet extends CollidableEntity{


	private static final int SPEED = 15;
	private int angle;
	private int game;
	public Bullet(double x, double y, Monkey monkey, int game) {
		
		this.x = x;
		this.y = y;
		this.radius = 10;
		this.z = 0;
		this.game = game;
		this.angle = monkey.getAngle();
		
	}
	
	public void onCollision(Balloon balloon) {
		
		switch (game) {
		
		case 1 :
			
			balloon.hitByBullet(this);
			this.destroyed = true;
			break;
	
		case 2 :
			
			for (Balloon b : GameLogic2.balloonInField) {
				b.hitByBullet(this);
				this.destroyed = true;
				break;
			}
		}

		
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		gc.drawImage(RenderableHolder.bullet, x - radius, y - radius);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
			this.x += Math.cos(Math.toRadians(angle)) * SPEED;
			this.y += Math.sin(Math.toRadians(angle)) * SPEED;
			
			if (this.x > 600 || this.x < 0 || this.y > 400 || this.y < 0) {
				this.destroyed = true;
			}

	}

}
