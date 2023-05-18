package logic;

import java.util.ArrayList;
import java.util.List;

import character.Balloon;
import character.Bullet;
import character.Entity;
import character.Monkey;
import sharedObject.RenderableHolder;
import drawing.Field;

public class GameLogic {
	
	private List<Entity> gameObjectContainer;
	public static final ArrayList<Bullet> bulletInField = new ArrayList<>();
	
	private Balloon balloon;
	private Monkey monkey;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 508;
	
	public GameLogic() {
	
		this.gameObjectContainer = new ArrayList<Entity>();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		monkey = new Monkey(WIDTH/2, -Monkey.HEIGHT + HEIGHT + 10, 1);
		balloon = new Balloon(30,40, 1);
		
		addNewObject(monkey);
		addNewObject(balloon);
	}
	
	public void addNewObject(Entity entity){
		
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
		
	}
	
	public void logicUpdate() {
		
		//Thread thread = new Thread(() -> {
		monkey.update();
		balloon.update();
		//});

		//thread.start();
		
		for (Bullet e : bulletInField) {
			e.update();
			if (!balloon.isDestroyed() && balloon.collideWith(e)) {
				e.onCollision(balloon);
			}
		}
		
		
		//if(!balloon.isDestroyed() && bullet.collideWith(balloon)){
		//	bullet.onCollision(balloon);
		}
	}

