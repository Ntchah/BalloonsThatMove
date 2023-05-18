package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {

	void draw(GraphicsContext gc);
	
	boolean isVisible();
	
	boolean isDestroyed();
	
	int getZ();
	
}
