package alpha;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velX, velY;
	protected int direction;

	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public float getVelX(){
		return velX;
	}
	public float getVelY(){
		return velY;
	}
	
	public int getDirection(){
		if(velX > 0)
			if(velY > 0)
				return 2;
			else if(velY < 0)
				return 8;
			else
				return 1;
		else if(velX < 0)
			if(velY > 0)
				return 4;
			else if(velY < 0)
				return 6;
			else
				return 5;
		else
			if(velY > 0)
				return 3;
			else if(velY < 0)
				return 7;
			else
				return direction;	
	}
}
