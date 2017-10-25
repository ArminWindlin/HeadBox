package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import alpha.Game.STATE;

public class End extends MouseAdapter {

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private boolean player2;
	private HUD hud;

	private BufferedImage button_image;

	public End(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		button_image = ss.grabImage(0, 925, 390, 80);
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// Menu button
		if (mouseOver(mx, my, 300, 450, 390, 80) && game.gameState == STATE.End) {
		}
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

	public void render(Graphics g, boolean p2) {
		Font fnt = new Font("arial", 1, 40);
		Font fnt2 = new Font("arial", 1, 30);

		g.drawImage(button_image, 300, 450, null);

		g.setFont(fnt);
		g.setColor(Color.white);
		if (p2) {
			if (HUD.HEALTH1 == 0) {
				g.setColor(Color.blue);
				g.drawString("Player 2 wins!", 350, 120);
				g.setColor(Color.white);
				HighscoreString(2, g);
			} else {
				g.setColor(Color.green);
				g.drawString("Player 1 wins!", 350, 120);
				g.setColor(Color.white);
				HighscoreString(2, g);
			}
			g.setFont(fnt2);
			g.drawString("Kills Player 1: ", 380, 350);
			g.drawString("Kills Player 2: ", 380, 400);
			g.setColor(Color.red);
			g.drawString("" + hud.kills1, 600, 350);
			g.drawString("" + hud.kills2, 600, 400);
			g.setColor(Color.white);
			g.setFont(fnt);
		} else {
			g.drawString("GAME OVER", 360, 120);
			HighscoreString(1, g);
		}
		for (int i = 0; i < handler.object.size(); i++) {
			handler.removeObject(handler.object.get(i));
		}

		g.drawString("Your Score: " + hud.score, 325, 200);
		g.setColor(Color.black);
		g.drawRect(300, 450, 390, 80);
		g.drawString("Menu", 445, 505);
	}

	private void HighscoreString(int i, Graphics g) {
		Font fnt2 = new Font("arial", 1, 40);
		g.setFont(fnt2);
		g.setColor(Color.YELLOW);

		if (i == 1) {
			if (HUD.score == HUD.highscore11)
				g.drawString("New Highscore!", 325, 250);
			else if (HUD.score == HUD.highscore12)
				g.drawString("Second best score!", 325, 250);
			else if (HUD.score == HUD.highscore13)
				g.drawString("Third best score!", 325, 250);
		} else if (i == 2) {
			if (HUD.score == HUD.highscore21)
				g.drawString("New Highscore!", 325, 250);
			else if (HUD.score == HUD.highscore22)
				g.drawString("Second best score!", 325, 250);
			else if (HUD.score == HUD.highscore23)
				g.drawString("Third best score!", 325, 250);
		}
		
		g.setColor(Color.white);

	}
}
