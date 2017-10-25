package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SimpleBullet extends GameObject {

	private Handler handler;

	private int bulletspeed1 = 16;
	private int bulletspeed2 = 11;

	private int duration = 1000;
	
	private BufferedImage Bullet_image;

	public SimpleBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		Bullet_image = ss.grabImage(1112, 0, 10, 10);

		// direction of bullet
		if (this.getId() == ID.SimpleBullet) {
			for (int i = 0; i < handler.object.size(); i++) {
				if (handler.object.get(i).getId() == ID.Player) {
					GameObject tempObject = handler.object.get(i);
					if (tempObject.getDirection() == 1) {
						velX = bulletspeed1;
						velY = 0;
					}
					if (tempObject.getDirection() == 3) {
						velX = 0;
						velY = bulletspeed1;
					}
					if (tempObject.getDirection() == 5) {
						velX = -bulletspeed1;
						velY = 0;
					}
					if (tempObject.getDirection() == 7) {
						velX = 0;
						velY = -bulletspeed1;
					}
					if (tempObject.getDirection() == 2) {
						velX = bulletspeed2;
						velY = bulletspeed2;
					}
					if (tempObject.getDirection() == 6) {
						velX = -bulletspeed2;
						velY = -bulletspeed2;
					}
					if (tempObject.getDirection() == 8) {
						velX = bulletspeed2;
						velY = -bulletspeed2;
					}
					if (tempObject.getDirection() == 4) {
						velX = -bulletspeed2;
						velY = bulletspeed2;
					}

				}
			}
		}
		if (this.getId() == ID.SimpleBullet2) {
			for (int i = 0; i < handler.object.size(); i++) {
				if (handler.object.get(i).getId() == ID.Player2) {
					GameObject tempObject2 = handler.object.get(i);
					if (tempObject2.getDirection() == 1) {
						velX = bulletspeed1;
						velY = 0;
					}
					if (tempObject2.getDirection() == 3) {
						velX = 0;
						velY = bulletspeed1;
					}
					if (tempObject2.getDirection() == 5) {
						velX = -bulletspeed1;
						velY = 0;
					}
					if (tempObject2.getDirection() == 7) {
						velX = 0;
						velY = -bulletspeed1;
					}
					if (tempObject2.getDirection() == 2) {
						velX = bulletspeed2;
						velY = bulletspeed2;
					}
					if (tempObject2.getDirection() == 6) {
						velX = -bulletspeed2;
						velY = -bulletspeed2;
					}
					if (tempObject2.getDirection() == 8) {
						velX = bulletspeed2;
						velY = -bulletspeed2;
					}
					if (tempObject2.getDirection() == 4) {
						velX = -bulletspeed2;
						velY = bulletspeed2;
					}

				}
			}
		}

	}

	public SimpleBullet(int x, int y, ID id, Handler handler, int bs1, int bs2) {
		super(x, y, id);
		this.handler = handler;
		velX = bs1;
		velY = bs2;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		Bullet_image = ss.grabImage(1112, 0, 10, 10);
	}

	public SimpleBullet(int x, int y, ID id, Handler handler, int bs1, int bs2, int duration) {
		super(x, y, id);
		this.handler = handler;
		this.duration = duration;
		velX = bs1;
		velY = bs2;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		Bullet_image = ss.grabImage(1112, 0, 10, 10);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 10, 10);
	}

	public void tick() {
		x += velX;
		y += velY;

		if (y >= Game.HEIGHT || y <= 0)
			handler.removeObject(this);
		if (x >= Game.WIDTH || x <= 0)
			handler.removeObject(this);

		collision();

		duration--;
		if (duration == 0) {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Bullet_image, (int) x, (int) y, null);
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.ShootEnemy || tempObject.getId() == ID.SmartEnemy) {

				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					handler.removeObject(tempObject);
					handler.removeObject(this);
					HUD.addScore(10);

					if (this.getId() == ID.SimpleBullet)
						HUD.kills1++;
					if (this.getId() == ID.SimpleBullet2)
						HUD.kills2++;

				}
			}
		}
	}

}
