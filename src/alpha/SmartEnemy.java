package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	private GameObject player2;

	private BufferedImage player_image;

	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		player_image = ss.grabImage(1000, 0, 32, 32);

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
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

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

		// if (y <= 0 || y >= Game.HEIGHT - 32)
		// velY *= -1;
		// if (x <= 0 || x >= Game.WIDTH - 16)
		// velX *= -1;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(player_image, (int) x, (int) y, null);

		// g.setColor(Color.yellow);
		// g.fillRect((int) x, (int) y, 25, 25);

	}
}
