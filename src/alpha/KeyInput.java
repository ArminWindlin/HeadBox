package alpha;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import alpha.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	Game game;

	private boolean vcY = false;
	private boolean vcX = false;
	private boolean vcY2 = false;
	private boolean vcX2 = false;

	private int speed = 3;

	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// key events for player 1

				if (key == KeyInputSettings.key1) {
					if (tempObject.getVelY() == speed)
						vcY = true;
					tempObject.setVelY(-speed);

				}
				if (key == KeyInputSettings.key3) {
					if (tempObject.getVelY() == -speed)
						vcY = true;
					tempObject.setVelY(speed);
				}
				if (key == KeyInputSettings.key4) {
					if (tempObject.getVelX() == -speed)
						vcX = true;
					tempObject.setVelX(speed);
				}
				if (key == KeyInputSettings.key2) {
					if (tempObject.getVelX() == speed)
						vcX = true;
					tempObject.setVelX(-speed);
				}
				if (key == KeyInputSettings.key5) {
					Player tempObject1 = (Player) tempObject;
					tempObject1.shot();
				}

			}
			if (tempObject.getId() == ID.Player2) {
				// key events for player 1

				if (key == KeyInputSettings.key6) {
					if (tempObject.getVelY() == speed)
						vcY2 = true;
					tempObject.setVelY(-speed);
				}
				if (key == KeyInputSettings.key8) {
					if (tempObject.getVelY() == -speed)
						vcY2 = true;
					tempObject.setVelY(speed);
				}
				if (key == KeyInputSettings.key7) {
					if (tempObject.getVelX() == speed)
						vcX2 = true;
					tempObject.setVelX(-speed);
				}
				if (key == KeyInputSettings.key9) {
					if (tempObject.getVelX() == -speed)
						vcX2 = true;
					tempObject.setVelX(speed);
				}
				if (key == KeyInputSettings.key10) {
					Player tempObject1 = (Player) tempObject;
					tempObject1.shot();
				}
			}
		}
		if (key == KeyInputSettings.key11) {
			if (game.gameState == STATE.Game) {
				if (Game.paused)
					Game.paused = false;
				else
					Game.paused = true;
			}
		}
		if (key == KeyInputSettings.key12)
			System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// key events for player 1

				if (key == KeyInputSettings.key1) {
					if (vcY) {
						tempObject.setVelY(speed);
						vcY = false;
					} else
						tempObject.setVelY(0);
				}
				if (key == KeyInputSettings.key3) {
					if (vcY) {
						tempObject.setVelY(-speed);
						vcY = false;
					} else
						tempObject.setVelY(0);
				}
				if (key == KeyInputSettings.key4) {
					if (vcX) {
						tempObject.setVelX(-speed);
						vcX = false;
					} else
						tempObject.setVelX(0);
				}
				if (key == KeyInputSettings.key2) {
					if (vcX) {
						tempObject.setVelX(speed);
						vcX = false;
					} else
						tempObject.setVelX(0);
				}
			}
			if (tempObject.getId() == ID.Player2) {
				// key events for player 1

				if (key == KeyInputSettings.key6) {
					if (vcY2) {
						tempObject.setVelY(speed);
						vcY2 = false;
					} else
						tempObject.setVelY(0);
				}
				if (key == KeyInputSettings.key8) {
					if (vcY2) {
						tempObject.setVelY(-speed);
						vcY2 = false;
					} else
						tempObject.setVelY(0);
				}
				if (key == KeyInputSettings.key9) {
					if (vcX2) {
						tempObject.setVelX(speed);
						vcX2 = false;
					} else
						tempObject.setVelX(0);
				}
				if (key == KeyInputSettings.key7) {
					if (vcX2) {
						tempObject.setVelX(-speed);
						vcX2 = false;
					} else
						tempObject.setVelX(0);
				}
			}
		}
	}


}
