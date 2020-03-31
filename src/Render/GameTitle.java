package Render;

import java.applet.AudioClip;
import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.awt.image.BufferedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JPanel;

import ManageNChar.GameManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameTitle extends JPanel {
	public static JLabel sbtn;
	private static JLabel cbtn;
	private static final String MEDIA_URL = "/Sakuzyo - IMP.mp3";
	public static AudioClip sound;
	public GameTitle() {
		sbtn = new JLabel();
		cbtn = new JLabel();
		playAudio();
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(1280, 720));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(350, 700, 0, 0));
		sbtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
		cbtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
		ClassLoader cloader = RenderableImage.class.getClassLoader();

		URL sturl = getClass().getResource("/bottom.png");
		ImageIcon stImg = new ImageIcon(sturl);
		sbtn.setIcon((Icon) stImg);
		this.add(sbtn);
		URL churl = getClass().getResource("/Exitbtn.png");
		ImageIcon chImg = new ImageIcon(churl);
		cbtn.setIcon(chImg);
		this.add(cbtn);
		cbtn.addMouseListener(new MouseListener() {

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
				System.exit(0);
			}
		});
		sbtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				// sbtn.setIcon(stImg);
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
				// sbtn.setIcon(st2);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				GameManager.frame.switchScene(new HardOrEz());

			}
		});
	}

	private void playAudio() {
		javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip(
				this.getClass().getResource(MEDIA_URL).toString());
		sound.setCycleCount(javafx.scene.media.AudioClip.INDEFINITE);
		sound.setVolume(0.1f);
		sound.play();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			URL url = getClass().getResource("/blackground1.gif");
			BufferedImage img = ImageIO.read(url);
			// Image img = new Image("Arena.png");
			g.drawImage(img, 0, 0, null);
			URL nameUrl = getClass().getResource("/title.png");
			BufferedImage name = ImageIO.read(nameUrl);
			g.drawImage(name, 130, 70, null);
		} catch (IOException e) {
			System.out.println("cant load");
		}
	}

}
