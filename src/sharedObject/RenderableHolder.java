package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image monkey;
	public static Image field;
	public static Image balloon;
	public static Image bullet;
	public static Image bg;
	public static Image map2;
	public static Image monkey2;
	public static Image balloon2;
	public static AudioClip mainMenuSong;
	public static AudioClip  onClicked;
	public static AudioClip  popped;
	
	//public static AudioClip  explosionSound;

	static {
		
		loadResource();
		
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		
		monkey = new Image(ClassLoader.getSystemResource("sniper.png").toString(), 100, 100, true, true);
		monkey2 = new Image(ClassLoader.getSystemResource("sniper.png").toString(), 60, 60, true, true);
		balloon = new Image(ClassLoader.getSystemResource("ceramic.png").toString(), 80, 80, true, true);
		balloon2 = new Image(ClassLoader.getSystemResource("ceramic.png").toString(), 40, 40, true, true);
		field = new Image(ClassLoader.getSystemResource("main2.png").toString(),1000,508,false,true);
		bullet = new Image(ClassLoader.getSystemResource("scooba.png").toString(), 20, 20, true, true);
		bg = new Image(ClassLoader.getSystemResource("mainMenu.png").toString(), 1000, 508, false, true);
		map2 = new Image(ClassLoader.getSystemResource("map_sea.png").toString(), 1000, 508, false, true);
		mainMenuSong = new AudioClip(ClassLoader.getSystemResource("mainMenu.wav").toString());
		popped = new AudioClip(ClassLoader.getSystemResource("balloonPopped.wav").toString());
		onClicked = new AudioClip(ClassLoader.getSystemResource("buttonClicked.wav").toString());
		
		//explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}

	public void add(IRenderable entity) {
		
		entities.add(entity);
		Collections.sort(entities, comparator);

	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
