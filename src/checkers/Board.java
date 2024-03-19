package checkers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener, MouseMotionListener {
	
	Board() {
		this.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}
	
	public static boolean[][] lm = new boolean[8][8];
	public static Color selcolor = new Color(243, 185, 95);
	public static Color posmoves = new Color(100, 255, 95);
	public static Color posmoves_border = new Color(50, 100, 40);
	boolean nafrente = false;
	
	boolean white_turn = true;
	
	public void paint(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		
		int x = 0, y = 0;
		boolean cor1ligado = true;
		
		Color cor1 = new Color(209,139,71);
		Color cor2 = new Color(255,206,158);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (cor1ligado) {
					g.setPaint(cor2);
					cor1ligado = false;
				} else {g.setPaint(cor1); cor1ligado = true;}
				
				g.fillRect(x, y, Constants.POSITION_SIZE, Constants.POSITION_SIZE);
				x += Constants.POSITION_SIZE;
				
			}
			
			if (cor1ligado) {
				g.setPaint(cor2);
				cor1ligado = false;
			} else {g.setPaint(cor1); cor1ligado = true;}
			
			x = 0;
			y += Constants.POSITION_SIZE;
			
			Pieces pieces = new Pieces();
			pieces.paintPieces(g);

		}
		
	}
	
	public static boolean selecionado = false;
	public static int sel1, sel2, numchecados = 0;
	public static boolean check;
	public static String checador = new String();
	public static String[] checado = new String[8];
	public static int[] checkX = new int[8];
	public static int[] checkY = new int[8];
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if (selecionado) {
			
			if (Pieces.pecas[sel1][sel2] == "wn" && sel1 != 0) {
				
				try {
					if (Pieces.pecas[sel1 - 1][sel2 - 1] == "em" && sel2 != 0) lm[sel1 - 1][sel2 - 1] = true;
				}catch(Exception ex) {}
				
				try {
					if (Pieces.pecas[sel1 - 1][sel2 + 1] == "em" && sel2 != 7) lm[sel1 - 1][sel2 + 1] = true;
				}catch(Exception ex) {}
				
				System.out.println(sel1 + " " + sel2);
				
			repaint();
			
		} else if (Pieces.pecas[sel1][sel2] == "bn" && sel1 != 7) {
			

				try {
					if (Pieces.pecas[sel1 + 1][sel2 - 1] == "em" && sel2 != 0) lm[sel1 + 1][sel2 - 1] = true;
				}catch(Exception ex) {}
				
				try {
					if (Pieces.pecas[sel1 + 1][sel2 + 1] == "em" && sel2 != 7) lm[sel1 + 1][sel2 + 1] = true;
				}catch(Exception ex) {}
			
				
			
			repaint();
			
		}
	
		
		Pieces.posX = e.getX() - (Constants.POSITION_SIZE / 2) + 15;
		Pieces.posY = e.getY() - (Constants.POSITION_SIZE / 2) + 15;

		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (selecionado) {
			
			
			if (e.getY()/100 != sel1 || e.getX()/100 != sel2) {
				
				for(int i = 0; i < 8; i++) {
					
					for(int j = 0; j < 8; j++) {
						
						System.out.print(lm[i][j] + " ");
						
					}
					
					System.out.println();
					
				}
			
				Pieces.pecas[e.getY()/100][e.getX()/100] = Pieces.pecas[sel1][sel2];
				Pieces.pecas[sel1][sel2] = "em";
					
				
				
			}
			selecionado = false;
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					lm[i][j] = false;
				}
			}
			
			sel1 = 10;
			sel2 = 10;
			repaint();
			
		} else if (!selecionado && Pieces.pecas[e.getY()/100][e.getX()/100] != "em"){
			selecionado = true;
			sel1 = e.getY()/100; 
			sel2 = e.getX()/100;

		}
		
		System.out.println(Pieces.pecas[e.getY()/100][e.getX()/100]);
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
}
