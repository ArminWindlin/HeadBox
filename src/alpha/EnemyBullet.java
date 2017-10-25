package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

	private Handler handler;
	
	private BufferedImage EnemyBullet_image;
	
	private GameObject player;
	private GameObject player2;

	public EnemyBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		EnemyBullet_image = ss.grabImage(1400, 0, 15, 15);
		
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player)
				player = handler.object.get(i);
		}
		player2 = player;
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player2)
				player2 = handler.object.get(i);
		}
		
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float diffX2 = x - player2.getX() - 16;
		float diffY2 = y - player2.getY() - 16;
		float distance = (float) Math.sqrt(diffX * diffX + diffY * diffY);
		float distance2 = (float) Math.sqrt(diffX2 * diffX2 + diffY2 * diffY2);

		if (distance < distance2) {
			velX = ((-1 / distance) * diffX)*5;
			velY = ((-1 / distance) * diffY)*5;
		} else {
			velX = ((-1 / distance2) * diffX2)*5;
			velY = ((-1 / distance2) * diffY2)*5;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 15, 15);
	}

	public void tick() {
		x += velX;
		y += velY;

		if (y >= Game.HEIGHT || y <= 0)
			handler.removeObject(this);
		if (x >= Game.WIDTH || x <= 0)
			handler.removeObject(this);

		collision();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(EnemyBullet_image, (int) x, (int) y, null);
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2 || tempObject.getId() == ID.SmartEnemy) {

				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					handler.removeObject(this);
					if (tempObject.getId() == ID.Player)
						HUD.HEALTH1 -= 40;
					if (tempObject.getId() == ID.Player2)
						HUD.HEALTH2 -= 40;
					if (tempObject.getId() == ID.SmartEnemy)
						handler.removeObject(tempObject);
				}
			}
		}
	}

}
