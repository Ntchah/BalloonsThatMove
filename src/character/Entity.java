package character;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{

	public double x;
	public double y;
	protected int z;
	protected boolean visible,destroyed;
	
	protected Entity() {
		
		visible = true;
		destroyed = false;
		
	}
	
	public abstract void update();
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
	}
}
