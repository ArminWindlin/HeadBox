package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Shotgun extends GameObject {

	private Handler handler;
	
	private BufferedImage Shotgun_image;

	public Shotgun(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		Shotgun_image = ss.grabImage(1064, 0, 48, 24);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 48, 24);
	}

	public void tick() {
		collision();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Shotgun_image, (int) x, (int) y, null);

	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					Player tempObject1 = (Player) tempObject;
					tempObject1.WeaponType = 2;
					handler.removeObject(this);
					tempObject1.ShotgunAmmo = 20;
				}
			}
		}
	}

}
