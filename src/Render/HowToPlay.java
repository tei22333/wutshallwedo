package Render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ManageNChar.GameManager;

public class HowToPlay extends JPanel{
	private static BufferedImage how,how1,how2,how3;
	private static int page = 1;
	public HowToPlay() {
		this.setDoubleBuffered(true);
		//this.setLayout(null);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1280, 720));
		JLabel nextbtn = new JLabel();
		URL next = getClass().getResource("/nextbtn.png");
		ImageIcon nextimg = new ImageIcon(next);
		try {
			URL url1 = getClass().getResource("/gamescreen1x.png");
			URL url2 = getClass().getResource("/gamescreen2x.png");
			URL url3 = getClass().getResource("/gamescreen3x.png");
			how = ImageIO.read(url1);
			how2 = ImageIO.read(url2);
			how3 = ImageIO.read(url3);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		nextbtn.setIcon(nextimg);
		nextbtn.setBounds(600, 600, nextimg.getIconWidth(), nextimg.getIconHeight());
		nextbtn.addMouseListener(new MouseListener() {
			
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
				setImage();
			}
		});
		this.add(nextbtn);
	}
	private void setImage() {
		page++;
		if(page == 1) {
			how = how1;
		}
		else if(page == 2) {
			this.how = how2;
		}
		else if(page == 3){
			this.how = how3;
		}
		else {
			page = 1;
			try {
				GameManager.frame.switchScene(new GameScreen());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.how, 0, 0, null);
	}
}
