package logic;

import java.util.ArrayList;
import javafx.animation.*;
import java.util.List;
import drawing.Field2;
import javafx.util.Duration;
import character.Balloon;
import character.Bullet;
import character.Entity;
import character.Monkey;
import sharedObject.RenderableHolder;

public class GameLogic2 {
	
	private List<Entity> gameObjectContainer;
	public static final ArrayList<Bullet> bulletInField = new ArrayList<>();
	public static final ArrayList<Balloon> balloonInField = new ArrayList<>();
	private Monkey monkey;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 508;
	
	public GameLogic2() {
	
		this.gameObjectContainer = new ArrayList<Entity>();
		Field2 field = new Field2();
		RenderableHolder.getInstance().add(field);
		monkey = new Monkey(100, 200, 2);
		
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				
				//initial position****
				addNewObject(new Balloon(300, 505, 2));
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		
		addNewObject(monkey);

	}
	
	public void addNewObject(Entity entity){
		
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
		
	}
	
	public void logicUpdate() {
		
		for (Entity e : gameObjectContainer) {
			e.update();
		}
		
		
		for (Bullet e : bulletInField) {
			for (Balloon balloon : balloonInField) {
				if (!balloon.isDestroyed() && balloon.collideWith(e)) {
					e.onCollision(balloon);
				}
			}

		}
	}	
	
}
	

