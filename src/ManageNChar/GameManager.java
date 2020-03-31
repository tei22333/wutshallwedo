package ManageNChar;

import Render.GameTitle;
import Render.GameWindow;

public class GameManager {
	public static GameWindow frame;
	public static GameTitle gt;
	public static boolean ingame;
	
	public GameManager() {
		ingame = false;
		gt = new GameTitle();
		frame = new GameWindow(gt);
		
	}
	public static void rungame() {
		while(true) {
			try {
				Thread.sleep(35);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			frame.getCurrentScene().repaint();
		}
	}
}
