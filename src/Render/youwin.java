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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ManageNChar.GameManager;

public class youwin extends JPanel{
	public youwin() {
		this.setDoubleBuffered(true);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1280, 720));
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			URL url = getClass().getResource("/youwin3.png");
			BufferedImage img = ImageIO.read(url);
			// Image img = new Image("Arena.png");
			g.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			System.out.println("cant load");
		}
	}
}
