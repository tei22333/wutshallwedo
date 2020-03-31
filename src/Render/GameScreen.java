package Render;

//import Logic.Timer;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

import ManageNChar.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Dio;
import Logic.Jojo;
import Logic.UploadException;

public class GameScreen extends JPanel {
	public static JLabel click;
	private static boolean PauseStatus, isEnd = false, cker1, cker2;
	public static boolean isPlayerTurn = false, isChallengerTurn, gameMode;
	public static int sp = 0;
	private int countTime = 10;
	private static JLabel basicSkill,skill1,ult;
	public static Dio dio;
	public static Jojo jojo;
	private static String message = "", message2 = "";
	public static BufferedImage jojoimg,dioimg;
	// private Timer timer = new Timer(this);

	public GameScreen() throws IOException {
		if (gameMode) {
			jojo = new Jojo("jojo",50,10);
			dio = new Dio("dio",100,10);
		}
		else {
			jojo = new Jojo("jojo",50, 10);
			dio = new Dio("dio",300, 10);
		}
		this.setLayout(null);
		click = new JLabel();
		JLabel press = new JLabel();
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(1280, 720));
		this.PauseStatus = false;
		this.isPlayerTurn = true;
		this.isChallengerTurn = !this.isPlayerTurn;
		this.cker1 = true;
		basicSkill = new JLabel();
		skill1 = new JLabel();
		ult = new JLabel();
		skill1.setVisible(false);
		ult.setVisible(false);
		URL skill1Url = getClass().getResource("/skill1.png");
		ImageIcon skillimg = new ImageIcon(skill1Url);
		skill1.setIcon(skillimg);
		URL ultUrl = getClass().getResource("/ult.png");
		ImageIcon ultimg = new ImageIcon(ultUrl);
		ult.setIcon(ultimg);
		URL st2url = getClass().getResource("/colorstart.png");
		ImageIcon cst = new ImageIcon(st2url);
		URL bsbt = getClass().getResource("/basicskill.png");
		ImageIcon bs = new ImageIcon(bsbt);
		URL bpbt = getClass().getResource("/bluepress.png");
		ImageIcon bp = new ImageIcon(bpbt);
		press.setIcon(bp);
		press.setVisible(false);
		basicSkill.setIcon(bs);
		// basicSkill.setVisible(false);
		basicSkill.setBounds(0, 300, bs.getIconWidth(), bs.getIconHeight());
		skill1.setBounds(0, 400, skillimg.getIconWidth(), skillimg.getIconHeight());
		ult.setBounds(0, 500, ultimg.getIconWidth(), ultimg.getIconHeight());
		press.addMouseListener(new MouseListener() {


			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				sp++;
				message = "Current Sp = " + sp;
			}
		});
		basicSkill.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				message2 = "";
				message = "";
				jojo.skillMode = 0;
				jojo.attacking();
				basicSkill.setVisible(false);
				skill1.setVisible(false);
				ult.setVisible(false);
				if (!isEnd) {
					dio.attacking();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		press.setBounds(500, 400, bp.getIconWidth(), bp.getIconHeight());
		skill1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				message2 = "";
				message = "";
				jojo.skillMode = 1;
				jojo.setSP(-20);
				jojo.attacking();
				basicSkill.setVisible(false);
				skill1.setVisible(false);
				ult.setVisible(false);
				if (!isEnd) {
					dio.attacking();
				}
			}
		});
		ult.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				message2 = "";
				message = "";
				jojo.skillMode = 2;
				jojo.setSP(-150);
				jojo.attacking();
				basicSkill.setVisible(false);
				skill1.setVisible(false);
				ult.setVisible(false);
				if (!isEnd) {
					dio.attacking();
				}
			}
		});
		click.setIcon(cst);
		click.setBounds(500, 400, cst.getIconWidth(), cst.getIconHeight());
		click.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				// click.setVisible(false);
				// press.setVisible(true);
				if (isPlayerTurn) {
					click.setVisible(false);
					press.setVisible(true);
					Timer counter = new Timer();
					counter.schedule(new TimerTask() {
						int seconds = 10;

						@Override
						public void run() {
							message2 = "Time remain = " + countTime;
							seconds--;
							if (seconds < 10) {
								countTime = seconds;
							}
							if (seconds == 0) {
								countTime = 10;
								isPlayerTurn = false;
								press.setVisible(false);
								click.setVisible(true);
								jojo.setSP(sp);
								basicSkill.setVisible(true);
								click.setVisible(false);
								message = "SP you got : " + sp;
								message2 = "Select your skill";
								if(jojo.getSP() >= 20) {
									skill1.setVisible(true);
								}
								if(jojo.getSP() >= 150) {
									ult.setVisible(true);
								}
								// write opponent turn
								counter.cancel();
							}
						}
					}, 0, 1000);
				}

			}
		});
		basicSkill.setVisible(false);
		this.add(basicSkill);
		this.add(click);
		this.add(press);
		this.add(skill1);
		this.add(ult);
	}

	public static boolean PauseStatus() {
		return PauseStatus;
	}

	public static boolean isPlayerturn() {
		return isPlayerTurn;
	}

	public static boolean isChallengerTurn() {
		return isChallengerTurn;
	}

	public void draw(Graphics2D g2d) {
		g2d.setFont(new Font("Tahoma", Font.BOLD, 20));
		g2d.setColor(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		this.draw(g2d);
		try {
			URL url = getClass().getResource("/backgr.jpg");
			BufferedImage img = ImageIO.read(url);
			// Image img = new Image("Arena.png");
			g.drawImage(img, 0, 0, null);
			g.drawImage(this.jojoimg, this.jojo.getX(), 400, null);
			g.drawImage(this.dioimg, this.dio.getX(), 400, null);
			g.setFont(new Font("Tahoma", Font.BOLD, 40));
			g.setColor(Color.WHITE);
			g.drawString(message2, 550, 700);
			g2d.drawString(message, 550, 200);
		} catch (IOException e) {
			try {
				throw new UploadException("cant load image");
			} catch (UploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		g.drawString("DIO's HP =" + dio.getHp(), 900, 100);
		g.drawString("Jojo's SP = " + jojo.getSP(), 100, 150);
		g.drawString("Dio's ATK = " + dio.getATK(), 900, 150);
		g.drawString("Jojo's HP = " + jojo.getHp(), 100, 100);
		g.drawString("Jojo's ATK = " + jojo.getATK(), 100, 200);
	}
}
