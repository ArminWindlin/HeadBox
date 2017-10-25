package alpha;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import alpha.Game.STATE;

public class KeyInputSettings extends KeyAdapter {

	private Handler handler;
	Game game;

	static int keyNr = 0;
	private int tempI;
	private String tempS;

	static int key1 = 87;
	static int key2 = 65;
	static int key3 = 83;
	static int key4 = 68;
	static int key5 = 32;
	static int key6 = 73;
	static int key7 = 74;
	static int key8 = 75;
	static int key9 = 76;
	static int key10 = 10;
	static int key11 = 80;
	static int key12 = 27;

	static String keyS1 = "W";
	static String keyS2 = "A";
	static String keyS3 = "S";
	static String keyS4 = "D";
	static String keyS5 = "SPACE";
	static String keyS6 = "I";
	static String keyS7 = "J";
	static String keyS8 = "K";
	static String keyS9 = "L";
	static String keyS10 = "ENTER";
	static String keyS11 = "P";
	static String keyS12 = "ESC";

	public KeyInputSettings(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (keyNr != 0) {
			switch (key) {
			case KeyEvent.VK_Q:
				tempI = 81;
				tempS = "Q";
				setKey();
				break;
			case KeyEvent.VK_W:
				tempI = 87;
				tempS = "W";
				setKey();
				break;
			case KeyEvent.VK_E:
				tempI = 69;
				tempS = "E";
				setKey();
				break;
			case KeyEvent.VK_R:
				tempI = 82;
				tempS = "R";
				setKey();
				break;
			case KeyEvent.VK_T:
				tempI = 84;
				tempS = "T";
				setKey();
				break;
			case KeyEvent.VK_Z:
				tempI = 90;
				tempS = "Z";
				setKey();
				break;
			case KeyEvent.VK_U:
				tempI = 85;
				tempS = "U";
				setKey();
				break;
			case KeyEvent.VK_I:
				tempI = 73;
				tempS = "I";
				setKey();
				break;
			case KeyEvent.VK_O:
				tempI = 79;
				tempS = "O";
				setKey();
				break;
			case KeyEvent.VK_P:
				tempI = 80;
				tempS = "P";
				setKey();
				break;
			case KeyEvent.VK_A:
				tempI = 65;
				tempS = "A";
				setKey();
				break;
			case KeyEvent.VK_S:
				tempI = 83;
				tempS = "S";
				setKey();
				break;
			case KeyEvent.VK_D:
				tempI = 68;
				tempS = "D";
				setKey();
				break;
			case KeyEvent.VK_F:
				tempI = 70;
				tempS = "F";
				setKey();
				break;
			case KeyEvent.VK_G:
				tempI = 71;
				tempS = "G";
				setKey();
				break;
			case KeyEvent.VK_H:
				tempI = 72;
				tempS = "H";
				setKey();
				break;
			case KeyEvent.VK_J:
				tempI = 74;
				tempS = "J";
				setKey();
				break;
			case KeyEvent.VK_K:
				tempI = 75;
				tempS = "K";
				setKey();
				break;
			case KeyEvent.VK_L:
				tempI = 76;
				tempS = "L";
				setKey();
				break;
			case KeyEvent.VK_Y:
				tempI = 89;
				tempS = "Y";
				setKey();
				break;
			case KeyEvent.VK_X:
				tempI = 88;
				tempS = "X";
				setKey();
				break;
			case KeyEvent.VK_C:
				tempI = 67;
				tempS = "C";
				setKey();
				break;
			case KeyEvent.VK_V:
				tempI = 86;
				tempS = "V";
				setKey();
				break;
			case KeyEvent.VK_B:
				tempI = 66;
				tempS = "B";
				setKey();
				break;
			case KeyEvent.VK_N:
				tempI = 78;
				tempS = "N";
				setKey();
				break;
			case KeyEvent.VK_M:
				tempI = 77;
				tempS = "M";
				setKey();
				break;
			case KeyEvent.VK_SPACE:
				tempI = 32;
				tempS = "SPACE";
				setKey();
				break;
			case KeyEvent.VK_ENTER:
				tempI = 10;
				tempS = "ENTER";
				setKey();
				break;
			case KeyEvent.VK_0:
				tempI = 48;
				tempS = "0";
				setKey();
				break;
			case KeyEvent.VK_1:
				tempI = 49;
				tempS = "1";
				setKey();
				break;
			case KeyEvent.VK_2:
				tempI = 50;
				tempS = "2";
				setKey();
				break;
			case KeyEvent.VK_3:
				tempI = 51;
				tempS = "3";
				setKey();
				break;
			case KeyEvent.VK_4:
				tempI = 52;
				tempS = "4";
				setKey();
				break;
			case KeyEvent.VK_5:
				tempI = 53;
				tempS = "5";
				setKey();
				break;
			case KeyEvent.VK_6:
				tempI = 54;
				tempS = "6";
				setKey();
				break;
			case KeyEvent.VK_7:
				tempI = 55;
				tempS = "7";
				setKey();
				break;
			case KeyEvent.VK_8:
				tempI = 56;
				tempS = "8";
				setKey();
				break;
			case KeyEvent.VK_9:
				tempI = 57;
				tempS = "9";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD0:
				tempI = 96;
				tempS = "0";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD1:
				tempI = 97;
				tempS = "1";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD2:
				tempI = 98;
				tempS = "2";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD3:
				tempI = 99;
				tempS = "3";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD4:
				tempI = 100;
				tempS = "4";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD5:
				tempI = 101;
				tempS = "5";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD6:
				tempI = 102;
				tempS = "6";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD7:
				tempI = 103;
				tempS = "7";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD8:
				tempI = 104;
				tempS = "8";
				setKey();
				break;
			case KeyEvent.VK_NUMPAD9:
				tempI = 105;
				tempS = "9";
				setKey();
				break;
			case KeyEvent.VK_UP:
				tempI = 38;
				tempS = "UP";
				setKey();
				break;
			case KeyEvent.VK_LEFT:
				tempI = 37;
				tempS = "LEFT";
				setKey();
				break;
			case KeyEvent.VK_DOWN:
				tempI = 40;
				tempS = "DOWN";
				setKey();
				break;
			case KeyEvent.VK_RIGHT:
				tempI = 39;
				tempS = "LEFT";
				setKey();
				break;
			case KeyEvent.VK_COMMA:
				tempI = 44;
				tempS = ",";
				setKey();
				break;
			case KeyEvent.VK_PERIOD:
				tempI = 46;
				tempS = ".";
				setKey();
				break;
			case KeyEvent.VK_MINUS:
				tempI = 45;
				tempS = "-";
				setKey();
				break;
			default:
				keyNr = 1000;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

	}

	private void setKey() {
		switch (keyNr) {
		case 1:
			key1 = tempI;
			keyS1 = tempS;
			break;
		case 2:
			key2 = tempI;
			keyS2 = tempS;
			break;
		case 3:
			key3 = tempI;
			keyS3 = tempS;
			break;
		case 4:
			key4 = tempI;
			keyS4 = tempS;
			break;
		case 5:
			key5 = tempI;
			keyS5 = tempS;
			break;
		case 6:
			key6 = tempI;
			keyS6 = tempS;
			break;
		case 7:
			key7 = tempI;
			keyS7 = tempS;
			break;
		case 8:
			key8 = tempI;
			keyS8 = tempS;
			break;
		case 9:
			key9 = tempI;
			keyS9 = tempS;
			break;
		case 10:
			key10 = tempI;
			keyS10 = tempS;
			break;
		case 11:
			key11 = tempI;
			keyS11 = tempS;
			break;
		case 12:
			key12 = tempI;
			keyS12 = tempS;
			break;
		}
	}

}
