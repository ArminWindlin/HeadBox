package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import alpha.Game.STATE;

public class HUD {

	public static float HEALTH1 = 100;
	public static float HEALTH2 = 100;
	private float greenValue = 0;
	private float blueValue = 0;

	static int score = 0;
	static int level = 0;
	public static boolean newGame = true;

	PrintStream printer;
	File file;

	public static int kills1;
	public static int kills2;

	static int highscore11 = 0;
	static int highscore12 = 0;
	static int highscore13 = 0;
	static int highscore21 = 0;
	static int highscore22 = 0;
	static int highscore23 = 0;

	private Handler handler;
	Game game;

	HUD(Handler handler, Game game) throws FileNotFoundException {
		this.game = game;
		this.handler = handler;

		// import file
		file = new File("res/Highscores.txt");
		// scan current highscrores
		Scanner scanner = new Scanner(file);
		highscore11 = scanner.nextInt();
		highscore12 = scanner.nextInt();
		highscore13 = scanner.nextInt();
		highscore21 = scanner.nextInt();
		highscore22 = scanner.nextInt();
		highscore23 = scanner.nextInt();
		// print on file
	}

	public void tick() {
		HEALTH1 = Game.clamp(HEALTH1, 0, 100);
		HEALTH2 = Game.clamp(HEALTH2, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);

		greenValue = HEALTH1 * 2;
		blueValue = HEALTH2 * 2;

		if (newGame) {
			score = 0;
			newGame = false;
		}
	}

	public void render(Graphics g, boolean p2) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int) greenValue, 0));
		g.fillRect((int) 15, (int) 15, (int) HEALTH1 * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);

		g.drawString("Kills:" + kills1, 20, 65);

		// only with 2 players
		if (p2) {
			g.setColor(Color.gray);
			g.fillRect(Game.WIDTH - 220, 15, 200, 32);
			g.setColor(new Color(75, 0, (int) blueValue));
			g.fillRect((int) Game.WIDTH - 220, (int) 15, (int) HEALTH2 * 2, 32);
			g.setColor(Color.white);
			g.drawRect(Game.WIDTH - 220, 15, 200, 32);

			g.setColor(Color.white);
			g.drawString("Kills:" + kills2, Game.WIDTH - 215, 65);
		}
		Font fnt1 = new Font("arial", 1, 20);
		Font fnt2 = new Font("arial", 1, 15);
		g.setFont(fnt1);
		g.drawString("Score: " + score, Game.WIDTH / 2 - 50, 30);
		g.setFont(fnt2);
		g.drawString("Level: " + level, Game.WIDTH / 2 - 25, 50);

		Font fnt = new Font("arial", 1, 50);
		g.setFont(fnt);
		if (HEALTH1 == 0) {
			game.gameState = STATE.End;
			level = 0;

			// Highscore calculator
			if (!p2) {
				if (score > highscore11) {
					highscore13 = highscore12;
					highscore12 = highscore11;
					highscore11 = score;
					reprintScore();
				} else if (score > highscore12) {
					highscore13 = highscore12;
					highscore12 = score;
					reprintScore();
				} else if (score > highscore13) {
					highscore13 = score;
					reprintScore();
				}
			} else if (p2) {
				if (score > highscore21) {
					highscore23 = highscore22;
					highscore22 = highscore21;
					highscore21 = score;
					reprintScore();
				} else if (score > highscore22) {
					highscore23 = highscore22;
					highscore22 = score;
					reprintScore();
				} else if (score > highscore23) {
					highscore13 = score;
					reprintScore();
				}
			}
		}
		if (HEALTH2 == 0) {
			game.gameState = STATE.End;
			level = 0;

			// Highscore calculator
			if (score > highscore21) {
				highscore23 = highscore22;
				highscore22 = highscore21;
				highscore21 = score;
				reprintScore();
			} else if (score > highscore22) {
				highscore23 = highscore22;
				highscore22 = score;
				reprintScore();
			} else if (score > highscore23) {
				highscore23 = score;
				reprintScore();
			}
		}
	}

	static void addScore(int add) {
		score += add;
	}

	public void resetScore() {
		score = 0;
	}

	public void reprintScore() {
		try {
			printer = new PrintStream(new File("res/Highscores.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printer.println(highscore11 + " " + highscore12 + " " + highscore13 + " " + highscore21 + " " + highscore22 + " " + highscore23);
	}
}
