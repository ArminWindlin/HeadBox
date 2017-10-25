package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ShootEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	private GameObject player2;

	private int clempSpeed = 2;
	private int shootDuration = 60;

	private BufferedImage ShootEnemy_image;

	public ShootEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		ShootEnemy_image = ss.grabImage(1360, 0, 40, 40);

		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player)
				player = handler.object.get(i);
		}
		player2 = player;
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player2)
				player2 = handler.object.get(i);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 40, 40);
	}

	public void tick() {
		clempSpeed--;
		if (clempSpeed == 0) {
			clempSpeed = 2;
			x += velX;
			y += velY;
		}

		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float diffX2 = x - player2.getX() - 16;
		float diffY2 = y - player2.getY() - 16;
		float distance = (float) Math.sqrt(diffX * diffX + diffY * diffY);
		float distance2 = (float) Math.sqrt(diffX2 * diffX2 + diffY2 * diffY2);

		if (distance < distance2) {
			velX = ((-1 / distance) * diffX) / 2;
			velY = ((-1 / distance) * diffY) / 2;
		} else {
			velX = ((-1 / distance2) * diffX2) / 2;
			velY = ((-1 / distance2) * diffY2) / 2;
		}

		shootDuration--;
		if (shootDuration == 0) {
			shootDuration = 60;
			handler.addObject(new EnemyBullet((int) x + 13, (int) y + 13, ID.EnemyBullet, handler));
		}

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(ShootEnemy_image, (int) x, (int) y, null);
	}
}
