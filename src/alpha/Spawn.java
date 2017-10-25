package alpha;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();

	private int scoreKeep = 0;
	private int scoreKeep2 = 0;

	static int MedPackCount;

	private boolean emptyField = true;

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
		// check if all enemies from that lvl are dead
		emptyField = true;
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.SmartEnemy || handler.object.get(i).getId() == ID.ShootEnemy)
				emptyField = false;
		}

		// new lvl
		if (emptyField) {
			HUD.level++;
			HUD.score += 1000;
			emptyField = false;

			// spawn enemies
			// *

			// spawn normal enemies
			for (int i = 0; i < HUD.level; i++) {
				handler.addObject(new SmartEnemy(r.nextInt(50), r.nextInt(Game.HEIGHT - 32), ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(50) + (Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(50), ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(50) + (Game.HEIGHT - 32), ID.SmartEnemy, handler));
			}

			// spawn shoot enemies
			for (int i = 7; i < HUD.level; i++) {
				int k = r.nextInt(4);
				switch (k) {
				case 0:
					handler.addObject(new ShootEnemy(r.nextInt(50), r.nextInt(Game.HEIGHT - 32), ID.ShootEnemy, handler));
					break;
				case 1:
					handler.addObject(new ShootEnemy(r.nextInt(50) + (Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.ShootEnemy, handler));
					break;
				case 2:
					handler.addObject(new ShootEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(50), ID.ShootEnemy, handler));
					break;
				case 3:
					handler.addObject(new ShootEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(50) + (Game.HEIGHT - 32), ID.ShootEnemy, handler));
					break;
				}
			}

			// void spawn
			if (HUD.level < 3)
				handler.addObject(new SmartEnemy(570, 430, ID.SmartEnemy, handler));
			else
				handler.addObject(new ShootEnemy(570, 430, ID.ShootEnemy, handler));

			// spawn shotgun
			if (r.nextInt(4) == 2) {
				handler.addObject(new Shotgun(r.nextInt(Game.WIDTH - 200) + 100, r.nextInt(Game.HEIGHT - 200) + 100, ID.Shotgun, handler));
			}

			// spawn superBomb
			if (r.nextInt(8) == 2) {
				handler.addObject(new SuperBomb(r.nextInt(Game.WIDTH - 200) + 100, r.nextInt(Game.HEIGHT - 200) + 100, ID.SuperBomb, handler));
			}

			// spawn medpack
			if (HUD.level % 2 == 0) {
				if (MedPackCount < 2) {
					handler.addObject(new MedPack(r.nextInt(Game.WIDTH - 200) + 100, r.nextInt(Game.HEIGHT - 200) + 100, ID.MedPack, handler));
					MedPackCount++;
				}
			}
			// */
		}
	}
}
