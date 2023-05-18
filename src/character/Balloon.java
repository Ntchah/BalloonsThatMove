package character;

import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic2;
import sharedObject.RenderableHolder;

public class Balloon extends CollidableEntity {

	public static final int WIDTH = 80;
	public static final int HEIGHT = 80;
	private int count = 0;
	private int game;

	public Balloon(int x, int y, int game) {
		this.x = x;
		this.y = y;
		this.z = -100;
		this.radius = 20;
		this.game = game;
		
		if (game == 2) {
			GameLogic2.balloonInField.add(this);
		}
	}


	public void update() {
		
		switch (game) {
		case 1 :
			
			if (this.x + Balloon.WIDTH > 1000 || this.x < 30) {
				count++;
			}

			if (count % 2 == 0) {
				this.x += 3;
			} else {
				this.x -= 3;
			}
			break;
		
		
		case 2:
			/* map_grass.png ; initial pos (GameLogic2: (0,70,2))
			
			if(x > -10 && x < 225 && y == 70)
				x += 5; 
			if(x == 225 && y >= 70 && y <= 375)
				y += 5;
			if(x >= 225 && x < 375 && y == 375)
				x += 5;
			if(x == 375 && y <= 375 && y > 75)
				y -= 5;
			if(x >= 375 && x < 925 && y == 75)
				x += 5;
			if(x == 925 && y >= 75 && y <= 225)
				y += 5;
			if(x <= 925 && x > 525 && y == 225)
				x -= 5;
			if(x == 525 && y >= 225 && y <= 375)
				y += 5;
			if(x >= 525 && x < 725 && y == 375) 
				x += 5;
			if(x == 725 && y <= 375 && y > 325)
				y -= 5;
			if(x >= 725 && x < 875 && y == 325)
				x += 5;
			if(x == 875 && y >= 325)
				y += 5;
			
			if (this.x == 875 && this.y >= 508)
				this.destroyed = true;
			if (this.destroyed) {
				GameLogic2.balloonInField.remove(this);
			}
			
			break;
			*/
			
			//map_sea.png ; initial pos (GameLogic2: (300,505,2))
			
			
			if(x == 300 && y <= 508 && y > 140)
				y -= 5;
			if(x >= 300 && x < 750 && y == 140)
				x += 5;
			if(x == 725 && y >= 140)
				y += 5;
			
			
			if (this.x == 725 && this.y >= 508)
				this.destroyed = true;
			if (this.destroyed) {
				GameLogic2.balloonInField.remove(this);
			}
			
			break;
			

		}


	}
	
	public void hitByBullet(Bullet bullet) {
		
		this.destroyed = true;
		RenderableHolder.popped.play();
	}

	@Override
	public void draw(GraphicsContext gc) {

		switch (game) {
		
		case 1:
			gc.drawImage(RenderableHolder.balloon, x - radius, y - radius);
			break;
			
		case 2:
			gc.drawImage(RenderableHolder.balloon2, x - radius, y - radius);
			break;
		}
	

	}

}
