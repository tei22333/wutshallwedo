package Logic;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import ManageNChar.GameManager;
import Render.GameScreen;
import Render.GameTitle;
import Render.gitgud;
import Render.youwin;

public class Jojo extends HeroProperty implements HeroSkill {
	/*private int ATK,Hp;
	private String name;*/
	public int skillMode = 0;
	private static int x = 300;
	public boolean isrun = true;
	private Thread thread;
	private static boolean runningmode = true;
	private static boolean runningcker = true;
	public static BufferedImage jojopunch;
	public static BufferedImage jojostill;
	public Jojo(String name ,int hp, int atk) throws IOException {
		super(name, hp , atk);
		/*this.Hp = hp;
		this.ATK = atk;*/
		URL jojo = getClass().getResource("/jojo.png");
		jojostill = ImageIO.read(jojo);
		URL jojourl = getClass().getResource("/jojopunch.png");
		jojopunch = ImageIO.read(jojourl);
		GameScreen.jojoimg = jojostill;
		// TODO Auto-generated constructor stub
	}

	public void basicSkill(HeroProperty target) {
		target.takeDamage(this.getATK());
	}
	public void skill1(HeroProperty target) {
		target.takeDamage(30);
	}

	public void ult(HeroProperty target) {
		// TODO Auto-generated method stub
		target.takeDamage(100);
	}

	public void update() throws InterruptedException {
		if (runningmode) {
			x += SPEED;
		} else {
			x -= SPEED;
		}
		if (this.x > 800 && runningcker) {
			GameScreen.jojoimg = this.jojopunch;
			thread.sleep(1000);
			GameScreen.jojoimg = this.jojostill;
			//
			if (this.skillMode == 1) {
				skill1(GameScreen.dio);
			}
			else if (this.skillMode == 2){
				ult(GameScreen.dio);
			}
			else {
				basicSkill(GameScreen.dio);
			}
			//
			runningmode = false;
			runningcker = false;
			if (GameScreen.dio.getHp() <= 0) {
				thread.sleep(3000);
				thread.interrupt();
				GameScreen.dio.isrun = false;
				GameScreen.jojo.isrun = false;
				GameScreen.dio.getThread().interrupt();
				GameManager.frame.switchScene(new youwin());
			}
		}
		if (this.x == 300 && !runningcker) {
			runningmode = true;
			runningcker = true;
			GameScreen.isChallengerTurn = true;
			GameScreen.isPlayerTurn = false;
			Thread.sleep(1000);
			thread.interrupt();
			if (GameScreen.jojo.getHp() <= 0) {
				//GameScreen.dioimg 
				thread.sleep(3000);
				thread.interrupt();
				// GameScreen.jojo.isrun = false;
				GameScreen.dio.isrun = false;
				GameScreen.jojo.isrun = false;
				GameScreen.dio.getThread().interrupt();
				GameManager.frame.switchScene(new gitgud());
			}
		}
	}

	public void attacking() {
		threadInitialize();
		getThread().start();
	}

	public void threadInitialize() {
		if (thread != null) {
			thread.interrupt();
		}
		thread = new Thread(new Runnable() {
			public void run() {
				try {
					while (isrun) {
						Thread.sleep(100);
						update();
						// setText();
						// Thread.sleep(100000000);
					}
				} catch (InterruptedException x) {

				}
			}
		});
	}

	public int getX() {
		return this.x;
	}

	public Thread getThread() {
		return this.thread;
	}

	public void setX() {
		this.x += 100;
	}

	/*private int getHP() {
		return this.Hp;
	}

	public int getATK() {
		return this.ATK;
	}*/
}
