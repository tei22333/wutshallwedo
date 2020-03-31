package Logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import ManageNChar.GameManager;
import Render.GameScreen;
import Render.GameTitle;
import Render.gitgud;
import Render.youwin;

public class Dio extends HeroProperty implements HeroSkill {
	/*private int ATK,Hp;
	private String name;*/
	public int x = 900;
	private static Thread thread;
	public static boolean isrun = true;
	private static boolean runningmode = true;
	private static boolean runningcker = true;
	public static BufferedImage diopunch, diostill;
	private static int coolDown = 0;

	public Dio(String name, int hp, int atk) throws IOException {
		super(name, hp, atk);
		/*this.Hp = hp;
		this.ATK = atk;*/
		URL dioUrl = getClass().getResource("/dio.png");
		diostill = ImageIO.read(dioUrl);
		URL diopunchUrl = getClass().getResource("/diopunch.png");
		diopunch = ImageIO.read(diopunchUrl);
		GameScreen.dioimg = diostill;
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
						GameScreen.jojo.getThread().join();
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

	private void update() throws InterruptedException {
		if (runningmode) {
			x -= SPEED;
		} else {
			x += SPEED;
		}
		if (this.x < 400 && runningcker) {
			GameScreen.dioimg = this.diopunch;
			thread.sleep(1000);
			if (this.coolDown == 1) {
				skill1(GameScreen.jojo);
			}
			else if (coolDown == 3){
				ult(GameScreen.jojo);
				coolDown = 0;
			}
			else {
				basicSkill(GameScreen.jojo);
			}
			coolDown++;
			GameScreen.dioimg = this.diostill;
			// random skill
			//
			runningmode = false;
			runningcker = false;
			if (GameScreen.jojo.getHp() <= 0) {
				thread.sleep(3000);
				thread.interrupt();
				GameScreen.jojo.isrun = false;
				GameScreen.dio.isrun = false;
				GameScreen.dio.getThread().interrupt();
				GameScreen.jojo.getThread().interrupt();
				GameManager.frame.switchScene(new gitgud());
			}
		}
		if (this.x == 900 && !runningcker) {
			runningmode = true;
			runningcker = true;
			GameScreen.isChallengerTurn = false;
			GameScreen.isPlayerTurn = true;
			Thread.sleep(1000);
			GameScreen.click.setVisible(true);
			thread.interrupt();
			GameScreen.sp = 0;
			if (GameScreen.dio.getHp() <= 0) {
				GameScreen.jojo.isrun = false;
				GameScreen.dio.isrun = false;
				GameManager.frame.switchScene(new youwin());
			}

		}
	}
}
