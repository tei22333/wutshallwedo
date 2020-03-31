package Render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.UploadException;
import ManageNChar.GameManager;

public class HardOrEz extends JPanel {
	private static JLabel Ez;
	private static JLabel Hard;

	public HardOrEz() {
		Ez = new JLabel();
		Hard = new JLabel();
		this.setDoubleBuffered(true);
		//do it to setbounds the button
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1280, 720));
		URL nexturl = getClass().getResource("/ezbtn.png");
		ImageIcon nextimg = new ImageIcon(nexturl);
		URL next0url = getClass().getResource("/hardbtn.png");
		ImageIcon next0img = new ImageIcon(next0url);
		Ez.setIcon(nextimg);
		Hard.setIcon(next0img);
		Ez.setBounds(150, 650, nextimg.getIconWidth(), nextimg.getIconHeight());
		Hard.setBounds(1000, 650, next0img.getIconWidth(), next0img.getIconHeight());
		this.add(Hard);
		this.add(Ez);
		// seticon hard
		Ez.addMouseListener(new MouseListener() {

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
				GameScreen.gameMode = true;
				GameManager.frame.switchScene(new HowToPlay());
			}
		});
		Hard.addMouseListener(new MouseListener() {

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
				GameScreen.gameMode = false;
				GameManager.frame.switchScene(new HowToPlay());
			}
		});
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		URL bg = getClass().getResource("/difficulty.png");
		BufferedImage bg1;
		try {
			bg1 = ImageIO.read(bg);
			g.drawImage(bg1, 0, 0, null);
			URL HON = getClass().getResource("/diff.png");
			BufferedImage HONimg = ImageIO.read(HON);
			g.drawImage(HONimg, 475, 70, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				throw new UploadException("cant load image");
			} catch (UploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
