package checkers;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {
	
	Board board;
	ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("wq.png"));
	
	public Frame() {
		
		board = new Board();
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(board);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Checkers");
		this.setIconImage(icon.getImage());
		this.addMouseListener(null);
		
	}
	
}
