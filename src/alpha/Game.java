package alpha;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.Random;

import org.newdawn.slick.util.BufferedImageUtil;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 841792188720717681L;

	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;
	public static boolean paused = false;

	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private End end;
	private Settings settings;
	private Highscore highscore;
	private boolean p2;

	private int frames = 0;
	private int frames2 = 0;
	private int ts = 0;

	private BufferedImage background_image;
	private BufferedImage void_image;

	public enum STATE {
		Menu, Game, Settings, Highscore, End;
	}

	public STATE gameState = STATE.Menu;

	public static BufferedImage sprite_sheet;

	public Game() throws FileNotFoundException{
		BufferedImageLoader loader = new BufferedImageLoader();
		sprite_sheet = loader.loadImage("/headbox_sprite_sheet.png");

		handler = new Handler();
		menu = new Menu(this, handler, hud);
		end = new End(this, handler, hud);
		settings = new Settings(this, handler, hud);
		highscore = new Highscore(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addKeyListener(new KeyInputSettings(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(settings);

		AudioPlayer.load();

		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		background_image = ss.grabImage(0, 0, 1000, 750);
		void_image = ss.grabImage(500, 750, 245, 170);

		new Window(WIDTH, HEIGHT, "Game Verion 1", this);

		hud = new HUD(handler, this);
		spawner = new Spawn(handler, hud);
		r = new Random();

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		if (gameState == STATE.Game) {
			if (!paused) {
				handler.tick();
				hud.tick();
				spawner.tick();
			}
		} else if (gameState == STATE.Menu) {
			menu.tick();
			handler.tick();
		} else if (gameState == STATE.End) {
		}
		ts++;
		if (ts > 10) {
			frames2 = frames;
			ts = 0;
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(background_image, 0, 0, null);
		if (paused) {
			g.setColor(Color.red);
			g.drawString("PAUSED", 100, 100);
		}

		if (gameState == STATE.Game) {
			g.drawImage(void_image, 470, 360, null);
			p2 = menu.getPlayer2();
			handler.render(g);
			hud.render(g, p2);
			Font fntN = new Font("arial", 1, 10);
			g.setFont(fntN);
			g.setColor(Color.red);
			g.drawString("FPS: " + frames2, 0, HEIGHT - 30);
		} else if (gameState == STATE.Menu) {
			menu.render(g);
		} else if (gameState == STATE.End) {
			end.render(g, p2);
		} else if (gameState == STATE.Settings) {
			settings.render(g);
		} else if (gameState == STATE.Highscore) {
			highscore.render(g);
		}

		g.dispose();
		bs.show();
	}

	public static float clamp(float var, float min, float max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}
	

	public static void main(String args[]) throws FileNotFoundException{
		new Game();
	}

}
