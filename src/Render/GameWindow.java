package Render;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWindow extends JFrame{
	private JPanel currentFrame;
	public GameWindow(JPanel frame) {
		super("sucks Arena");
		ClassLoader cloader = RenderableImage.class.getClassLoader();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentFrame = frame;
		getContentPane().add(currentFrame);
		pack();
		this.setVisible(true);
		this.currentFrame.requestDefaultFocus();
	}
	public JPanel getCurrentScene() {
		return currentFrame;
	}
	public void switchScene(JPanel frame) {
		getContentPane().remove(currentFrame);
		getContentPane().removeAll();
		this.currentFrame = frame;
		getContentPane().add(currentFrame);
		getContentPane().validate();
		pack();
		currentFrame.requestFocus();
	}
}
