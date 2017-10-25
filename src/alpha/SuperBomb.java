package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SuperBomb extends GameObject {

	private Handler handler;

	private BufferedImage Superbomb_image;

	public SuperBomb(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		Superbomb_image = ss.grabImage(1325, 0, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {
		collision();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Superbomb_image, (int) x, (int) y, null);

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					handler.removeObject(this);
					handler.clearEnemies();
					AudioPlayer.getSOund("explosion").play();
				}
			}
		}
	}

}
