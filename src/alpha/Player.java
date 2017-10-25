package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	int WeaponType = 1;
	int ShotgunAmmo;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

		direction = 1;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 61);

		collision();

		direction = getDirection();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.ShootEnemy || tempObject.getId() == ID.SmartEnemy) {

				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					if (this.getId() == ID.Player)
						HUD.HEALTH1 -= 2;
					if (this.getId() == ID.Player2)
						HUD.HEALTH2 -= 2;
				}
			}
		}
	}

	public void render(Graphics g) {
		if (this.getId() == ID.Player)
			g.setColor(Color.green);
		if (this.getId() == ID.Player2)
			g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, 32, 32);
		if (this.getId() == ID.Player)
			g.setColor(new Color(34, 139, 34));
		if (this.getId() == ID.Player2)
			g.setColor(new Color(25, 25, 112));
		g.fillRect((int) x + 8, (int) y + 8, 16, 16);

		if (this.getId() == ID.Player)
			g.setColor(Color.green);
		if (this.getId() == ID.Player2)
			g.setColor(Color.blue);
		if (direction == 1) {
			g.fillRect((int) x + 32, (int) y, 20, 10);
			g.fillRect((int) x + 32, (int) y + 22, 20, 10);
		}
		if (direction == 3) {
			g.fillRect((int) x, (int) y + 32, 10, 20);
			g.fillRect((int) x + 22, (int) y + 32, 10, 20);
		}
		if (direction == 5) {
			g.fillRect((int) x - 20, (int) y, 20, 10);
			g.fillRect((int) x - 20, (int) y + 22, 20, 10);
		}
		if (direction == 7) {
			g.fillRect((int) x, (int) y - 20, 10, 20);
			g.fillRect((int) x + 22, (int) y - 20, 10, 20);
		}
		if (direction == 2) {
			g.fillRect((int) x + 22, (int) y + 32, 10, 10);
			g.fillRect((int) x + 32, (int) y + 22, 10, 10);
		}
		if (direction == 4) {
			g.fillRect((int) x - 10, (int) y + 22, 10, 10);
			g.fillRect((int) x, (int) y + 32, 10, 10);
		}
		if (direction == 6) {
			g.fillRect((int) x, (int) y - 10, 10, 10);
			g.fillRect((int) x - 10, (int) y, 10, 10);
		}
		if (direction == 8) {
			g.fillRect((int) x + 22, (int) y - 10, 10, 10);
			g.fillRect((int) x + 32, (int) y, 10, 10);
		}

		if (ShotgunAmmo > 0) {
			g.setColor(Color.white);
			if (this.getId() == ID.Player)
				g.drawString("Shotgun Ammo: " + ShotgunAmmo, 20, 80);
			if (this.getId() == ID.Player2)
				g.drawString("Shotgun Ammo: " + ShotgunAmmo, Game.WIDTH - 215, 80);
		}
	}

	void shot() {
		if (WeaponType == 1) {
			if (this.getId() == ID.Player)
				handler.addObject(new SimpleBullet((int) x + 12, (int) y + 12, ID.SimpleBullet, handler));
			if (this.getId() == ID.Player2)
				handler.addObject(new SimpleBullet((int) x + 12, (int) y + 12, ID.SimpleBullet2, handler));
			AudioPlayer.getSOund("pistol_shot").play();
		}
		if (WeaponType == 2) {
			new ShotgunBullet((int) x - 4, (int) y - 4, handler, this);
			AudioPlayer.getSOund("shotgun_shot").play();
			ShotgunAmmo--;
			if (ShotgunAmmo == 0)
				WeaponType = 1;
		}

	}

}
