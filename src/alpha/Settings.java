package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import alpha.Game.STATE;

public class Settings extends MouseAdapter {

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private boolean player2;
	private HUD hud;
	static boolean music = false;
	static boolean sound = true;

	private BufferedImage button_image;
	private BufferedImage music_image;
	private BufferedImage sound_image;
	private BufferedImage no_music_image;
	private BufferedImage no_sound_image;

	public Settings(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		button_image = ss.grabImage(0, 925, 390, 80);
		music_image = ss.grabImage(1125, 0, 50, 50);
		sound_image = ss.grabImage(1175, 0, 50, 50);
		no_music_image = ss.grabImage(1225, 0, 50, 50);
		no_sound_image = ss.grabImage(1275, 0, 50, 50);
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// P1 UP button
		if (mouseOver(mx, my, 160, 175, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 1;
		}
		// P1 LEFT button
		if (mouseOver(mx, my, 110, 225, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 2;
		}
		// P1 DOWN button
		if (mouseOver(mx, my, 160, 225, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 3;
		}
		// P1 RIGHT button
		if (mouseOver(mx, my, 210, 225, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 4;
		}
		// P1 SHOOT button
		if (mouseOver(mx, my, 110, 275, 140, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 5;
		}

		// P2 UP button
		if (mouseOver(mx, my, 460, 175, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 6;
		}
		// P2 LEFT button
		if (mouseOver(mx, my, 410, 225, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 7;
		}
		// P2 DOWN button
		if (mouseOver(mx, my, 460, 225, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 8;
		}
		// P2 RIGHT button
		if (mouseOver(mx, my, 510, 225, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 9;
		}
		// P2 SHOOT button
		if (mouseOver(mx, my, 410, 275, 140, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 10;
		}

		// PAUSE button
		if (mouseOver(mx, my, 760, 175, 40, 40) && game.gameState == STATE.Settings) {
			KeyInputSettings.keyNr = 11;
		}

		// music button
		if (mouseOver(mx, my, 380, 430, 60, 60) && game.gameState == STATE.Settings) {
			if (music) {
				AudioPlayer.getMusic("music").stop();
				music = false;
			} else if (!music) {
				AudioPlayer.getMusic("music").loop();
				music = true;
			}
		}

		// sound button
		if (mouseOver(mx, my, 540, 430, 60, 60) && game.gameState == STATE.Settings) {
			if (sound)
				sound = false;
			else if (!sound)
				sound = true;
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

	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 40);
		Font fnt2 = new Font("arial", 1, 20);
		Font fnt3 = new Font("arial", 1, 50);

		g.drawImage(button_image, 300, 550, null);

		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Controls:", 405, 100);
		g.drawString("Music & Sound:", 350, 400);
		g.setFont(fnt2);
		g.drawString("Player 1:", 140, 160);
		g.drawString("Player 2:", 440, 160);
		g.drawString("Pause:", 740, 160);

		// Invalid Key
		if (KeyInputSettings.keyNr == 1000) {
			g.setColor(Color.red);
			g.setFont(fnt3);
			g.drawString("INVALID KEY!", 50, 100);
			g.setFont(fnt);
		}
		// P1 UP
		g.setColor(Color.white);
		g.fillRect(160, 175, 40, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS1, 170, 202);
		if (KeyInputSettings.keyNr == 1) {
			g.setColor(Color.red);
			g.drawRect(160, 175, 40, 40);
			g.drawRect(161, 176, 38, 38);
		}
		// P1 LEFT
		g.setColor(Color.white);
		g.fillRect(110, 225, 40, 40);
		g.setColor(Color.black);
		g.drawString(KeyInputSettings.keyS2, 120, 252);
		if (KeyInputSettings.keyNr == 2) {
			g.setColor(Color.red);
			g.drawRect(110, 225, 40, 40);
			g.drawRect(111, 226, 38, 38);
		}
		// P1 DOWN
		g.setColor(Color.white);
		g.fillRect(160, 225, 40, 40);
		g.setColor(Color.black);
		g.drawString(KeyInputSettings.keyS3, 170, 252);
		if (KeyInputSettings.keyNr == 3) {
			g.setColor(Color.red);
			g.drawRect(160, 225, 40, 40);
			g.drawRect(161, 226, 38, 38);
		}
		// P1 RIGTH
		g.setColor(Color.white);
		g.fillRect(210, 225, 40, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS4, 220, 252);
		if (KeyInputSettings.keyNr == 4) {
			g.setColor(Color.red);
			g.drawRect(210, 225, 40, 40);
			g.drawRect(211, 226, 38, 38);
		}
		// P1 SHOOT
		g.setColor(Color.white);
		g.fillRect(110, 275, 140, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS5, 120, 302);
		if (KeyInputSettings.keyNr == 5) {
			g.setColor(Color.red);
			g.drawRect(110, 275, 140, 40);
			g.drawRect(111, 276, 138, 38);
		}

		// P2 UP
		g.setColor(Color.white);
		g.fillRect(460, 175, 40, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS6, 470, 202);
		if (KeyInputSettings.keyNr == 6) {
			g.setColor(Color.red);
			g.drawRect(460, 175, 40, 40);
			g.drawRect(461, 176, 38, 38);
		}
		// P2 LEFT
		g.setColor(Color.white);
		g.fillRect(410, 225, 40, 40);
		g.setColor(Color.black);
		g.drawString(KeyInputSettings.keyS7, 420, 252);
		if (KeyInputSettings.keyNr == 7) {
			g.setColor(Color.red);
			g.drawRect(410, 225, 40, 40);
			g.drawRect(411, 226, 38, 38);
		}
		// P2 DOWN
		g.setColor(Color.white);
		g.fillRect(460, 225, 40, 40);
		g.setColor(Color.black);
		g.drawString(KeyInputSettings.keyS8, 470, 252);
		if (KeyInputSettings.keyNr == 8) {
			g.setColor(Color.red);
			g.drawRect(460, 225, 40, 40);
			g.drawRect(461, 226, 38, 38);
		}
		// P2 RIGTH
		g.setColor(Color.white);
		g.fillRect(510, 225, 40, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS9, 520, 252);
		if (KeyInputSettings.keyNr == 9) {
			g.setColor(Color.red);
			g.drawRect(510, 225, 40, 40);
			g.drawRect(511, 226, 38, 38);
		}
		// P2 SHOOT
		g.setColor(Color.white);
		g.fillRect(410, 275, 140, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS10, 420, 302);
		if (KeyInputSettings.keyNr == 10) {
			g.setColor(Color.red);
			g.drawRect(410, 275, 140, 40);
			g.drawRect(411, 276, 138, 38);
		}

		// PAUSE
		g.setColor(Color.white);
		g.fillRect(760, 175, 40, 40);
		g.setColor(Color.black);
		g.setFont(fnt2);
		g.drawString(KeyInputSettings.keyS11, 770, 202);
		if (KeyInputSettings.keyNr == 11) {
			g.setColor(Color.red);
			g.drawRect(760, 175, 40, 40);
			g.drawRect(761, 176, 38, 38);
		}

		// MUSIC
		g.setColor(Color.white);
		g.fillRect(380, 430, 60, 60);
		g.setColor(Color.black);
		g.setFont(fnt2);
		if (music)
			g.drawImage(music_image, 385, 435, null);
		else if (!music)
			g.drawImage(no_music_image, 385, 435, null);

		// SOUND
		g.setColor(Color.white);
		g.fillRect(540, 430, 60, 60);
		g.setColor(Color.black);
		g.setFont(fnt2);
		if (sound)
			g.drawImage(sound_image, 545, 435, null);
		else if (!sound)
			g.drawImage(no_sound_image, 545, 435, null);

		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawRect(300, 550, 390, 80);
		g.drawString("Menu", 445, 605);
	}
}
