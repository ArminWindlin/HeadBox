package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import alpha.Game.STATE;

public class Highscore extends MouseAdapter {

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;

	private BufferedImage button_image;

	public Highscore(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		button_image = ss.grabImage(0, 925, 390, 80);
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height)
				return true;
			else
				return false;
		} else
			return false;
	}

	public void tick() {
	}

	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 40);
		Font fnt2 = new Font("arial", 1, 20);
		Font fnt3 = new Font("arial", 1, 50);

		g.drawImage(button_image, 300, 550, null);

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("1 Player", 100, 100);
		g.drawString("1:", 350, 100);
		g.drawString("2:", 350, 150);
		g.drawString("3:", 350, 200);
		g.drawString("" + HUD.highscore11, 410, 100);
		g.drawString("" + HUD.highscore12, 410, 150);
		g.drawString("" + HUD.highscore13, 410, 200);
		g.drawString("2 Player", 100, 350);
		g.drawString("1:", 350, 350);
		g.drawString("2:", 350, 400);
		g.drawString("3:", 350, 450);
		g.drawString("" + HUD.highscore21, 410, 350);
		g.drawString("" + HUD.highscore22, 410, 400);
		g.drawString("" + HUD.highscore23, 410, 450);
		g.setFont(fnt2);

		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawRect(300, 550, 390, 80);
		g.drawString("Menu", 445, 605);
	}
}
