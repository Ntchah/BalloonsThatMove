package character;

public abstract class CollidableEntity extends Entity{
	
	protected int radius;
	
	public boolean collideWith(CollidableEntity other){
		return Math.hypot(this.x-other.x, this.y-other.y) <= this.radius+other.radius;
		
	}
}

