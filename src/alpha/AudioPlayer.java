package alpha;

import java.util.Map;
import java.util.HashMap;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	public static void load() {

		try {
			soundMap.put("menu_sound", new Sound("res/Water_Impact_1.ogg"));

			soundMap.put("pistol_shot", new Sound("res/m4a1-1.ogg"));

			soundMap.put("shotgun_shot", new Sound("res/Shotgun.ogg"));
			
			soundMap.put("silence", new Sound("res/sil.ogg"));
			
			soundMap.put("explosion", new Sound("res/explosion.ogg"));

			musicMap.put("music", new Music("res/Beat_Your_Competition.ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public static Music getMusic(String key) {
		return musicMap.get(key);
	}

	public static Sound getSOund(String key) {
		if (Settings.sound)
			return soundMap.get(key);
		else 
			return soundMap.get("silence");
	}
	
	

}
