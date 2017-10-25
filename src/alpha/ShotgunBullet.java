package alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ShotgunBullet {

	GameObject player;
	int velX;
	int velY;
	int velX2;
	int velY2;
	int velX3;
	int velY3;
	int velX4;
	int velY4;
	int velX5;
	int velY5;
	private int bs1 = 16;
	private int bs2 = 11;
	private int bs3 = 15;
	private int bs4 = 6;

	private int duration = 20;

	public ShotgunBullet(int x, int y, Handler handler, GameObject player) {
		this.player = player;

		bulletDirection();
		if (player.getId() == ID.Player) {
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet, handler, velX, velY, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet, handler, velX2, velY2, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet, handler, velX3, velY3, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet, handler, velX4, velY4, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet, handler, velX5, velY5, duration));
		}
		if (player.getId() == ID.Player2) {
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet2, handler, velX, velY, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet2, handler, velX2, velY2, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet2, handler, velX3, velY3, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet2, handler, velX4, velY4, duration));
			handler.addObject(new SimpleBullet((int) x + 16, (int) y + 16, ID.SimpleBullet2, handler, velX5, velY5, duration));

		}
	}

	private void bulletDirection() {
		switch (player.getDirection()) {
		case 1:
			velX = bs1;
			velY = 0;
			velX2 = bs2;
			velY2 = bs2;
			velX3 = bs2;
			velY3 = -bs2;
			velX4 = bs3;
			velY4 = -bs4;
			velX5 = bs3;
			velY5 = bs4;
			break;

		case 3:
			velX = 0;
			velY = bs1;
			velX2 = bs2;
			velY2 = bs2;
			velX3 = -bs2;
			velY3 = bs2;
			velX4 = bs4;
			velY4 = bs3;
			velX5 = -bs4;
			velY5 = bs3;
			break;

		case 5:
			velX = -bs1;
			velY = 0;
			velX2 = -bs2;
			velY2 = -bs2;
			velX3 = -bs2;
			velY3 = bs2;
			velX4 = -bs3;
			velY4 = -bs4;
			velX5 = -bs3;
			velY5 = bs4;
			break;

		case 7:
			velX = 0;
			velY = -bs1;
			velX2 = -bs2;
			velY2 = -bs2;
			velX3 = bs2;
			velY3 = -bs2;
			velX4 = -bs4;
			velY4 = -bs3;
			velX5 = bs4;
			velY5 = -bs3;
			break;

		case 2:
			velX = bs2;
			velY = bs2;
			velX2 = bs1;
			velY2 = 0;
			velX3 = 0;
			velY3 = bs1;
			velX4 = bs3;
			velY4 = bs4;
			velX5 = bs4;
			velY5 = bs3;
			break;

		case 6:
			velX = -bs2;
			velY = -bs2;
			velX2 = 0;
			velY2 = -bs1;
			velX3 = -bs1;
			velY3 = 0;
			velX4 = -bs3;
			velY4 = -bs4;
			velX5 = -bs4;
			velY5 = -bs3;
			break;

		case 8:
			velX = bs2;
			velY = -bs2;
			velX2 = 0;
			velY2 = -bs1;
			velX3 = bs1;
			velY3 = 0;
			velX4 = bs4;
			velY4 = -bs3;
			velX5 = bs3;
			velY5 = -bs4;
			break;

		case 4:
			velX = -bs2;
			velY = bs2;
			velX2 = 0;
			velY2 = bs1;
			velX3 = -bs1;
			velY3 = 0;
			velX4 = -bs3;
			velY4 = bs4;
			velX5 = -bs4;
			velY5 = bs3;
			break;
		}
	}
}
