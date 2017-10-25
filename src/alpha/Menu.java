package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import alpha.Game.STATE;

public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private boolean player2;
	private HUD hud;

	private BufferedImage headbox_image;
	private BufferedImage button_image;

	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		headbox_image = ss.grabImage(0, 750, 490, 100);
		button_image = ss.grabImage(0, 925, 390, 80);
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// 1 Player button
		if (mouseOver(mx, my, 300, 250, 390, 80) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Game;
			player2 = false;
			handler.addObject(new Player(Game.WIDTH / 3 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
		}
		// 2 Player button
		else if (mouseOver(mx, my, 300, 350, 390, 80) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Game;
			player2 = true;
			handler.addObject(new Player(Game.WIDTH / 3 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player2, handler));
		}
		// End Menu button
		else if (mouseOver(mx, my, 300, 450, 390, 80) && game.gameState == STATE.End) {
			HUD.HEALTH1 = 100;
			HUD.HEALTH2 = 100;
			HUD.kills1 = 0;
			HUD.kills2 = 0;
			game.gameState = STATE.Menu;
			HUD.newGame = true;
		}
		// Settings button
		else if (mouseOver(mx, my, 300, 450, 390, 80) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Settings;
		}
		// Settings Menu button
		else if (mouseOver(mx, my, 300, 550, 390, 80) && game.gameState == STATE.Settings) {
			game.gameState = STATE.Menu;
			KeyInputSettings.keyNr = 0;
		}
		// Highscore button
		else if (mouseOver(mx, my, 300, 550, 390, 80) && game.gameState == STATE.Menu) {
			game.gameState = STATE.Highscore;
		}
		// Highscore Menu button
		else if (mouseOver(mx, my, 300, 550, 390, 80) && game.gameState == STATE.Highscore) {
			game.gameState = STATE.Menu;
		}

		AudioPlayer.getSOund("menu_sound").play();
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
		Font fnt = new Font("arial", 1, 100);
		Font fnt2 = new Font("arial", 1, 40);
		Font fntN = new Font("arial", 1, 10);

		g.drawImage(headbox_image, 240, 105, null);
		g.drawImage(button_image, 300, 250, null);
		g.drawImage(button_image, 300, 350, null);
		g.drawImage(button_image, 300, 450, null);
		g.drawImage(button_image, 300, 550, null);

		// g.setColor(new Color(140, 140, 140));
		g.drawRect(300, 250, 390, 80);
		g.drawRect(300, 350, 390, 80);
		g.drawRect(300, 450, 390, 80);
		g.drawRect(300, 550, 390, 80);
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawString("1 Player", 420, 306);
		g.drawString("2 Player", 420, 406);
		g.drawString("Settings", 420, 506);
		g.drawString("Highscore", 400, 606);

		g.setFont(fntN);
	}

	public boolean getPlayer2() {
		return player2;
	}
}
