package checkers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Pieces extends Board {
	
	Image black_normal = new ImageIcon(getClass().getClassLoader().getResource("bn.png")).getImage();
	Image black_queen = new ImageIcon(getClass().getClassLoader().getResource("bq.png")).getImage();
	
	Image white_normal = new ImageIcon(getClass().getClassLoader().getResource("wn.png")).getImage();
	Image white_queen = new ImageIcon(getClass().getClassLoader().getResource("wq.png")).getImage();

	
	public static String[][] pecas =   {{"em", "bn", "em", "bn", "em", "bn", "em", "bn"},
									    {"bn", "em", "bn", "em", "bn", "em", "bn", "em"},
									    {"em", "bn", "em", "bn", "em", "bn", "em", "bn"},
									    {"em", "em", "em", "em", "em", "em", "em", "em"},
									    {"em", "em", "em", "em", "em", "em", "em", "em"},
									    {"wn", "em", "wn", "em", "wn", "em", "wn", "em"},
										{"em", "wn", "em", "wn", "em", "wn", "em", "wn"},
										{"wn", "em", "wn", "em", "wn", "em", "wn", "em"}};
	
	int x = 0, y = 0;
	public static int posX, posY;
	
	public static void displayPieces(Graphics2D g, int x, int y, Image piece) {
		
		g.drawImage(piece, x - 3, y - 3, 77, 77, null);
	
		}
	
		
	
	public void paintPieces(Graphics2D g) {
		
		g.setColor(new Color(0,0,0));
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				
					
					switch (pecas[i][j]) {
					
					case "bn":displayPieces(g, x + 15, y + 15, black_normal); break;
					case "bq":displayPieces(g, x + 15, y + 15, black_queen); break;
					
					case "wn":displayPieces(g, x + 15, y + 15, white_normal); break;
					case "wq":displayPieces(g, x + 15, y + 15, white_queen); break;

						
					}
					
				if (Board.selecionado) {
					
					g.setPaint(Board.selcolor);
					g.fillRect(Board.sel2 * Constants.POSITION_SIZE, Board.sel1 * Constants.POSITION_SIZE, Constants.POSITION_SIZE, Constants.POSITION_SIZE);
					
					for (int i2 = 0; i2 < 8; i2++) {
						
						for (int j2 = 0; j2 < 8; j2++) {
							
							if (lm[i2][j2]) {
								
								g.setStroke(new BasicStroke(2));
								g.setPaint(posmoves);
								g.fillRect(j2 * Constants.POSITION_SIZE, i2 * Constants.POSITION_SIZE, Constants.POSITION_SIZE, Constants.POSITION_SIZE);
								g.setPaint(posmoves_border);
								g.drawRect(j2 * Constants.POSITION_SIZE, i2 * Constants.POSITION_SIZE, Constants.POSITION_SIZE, Constants.POSITION_SIZE);
								
								for(int d = 0; d < Board.numchecados; d++) {
									
									switch (Board.checado[d]) {
									
									case "bn":displayPieces(g, (Board.checkY[d] * 100) + 15, (Board.checkX[d] * 100) + 15, black_normal); break;
									case "bq":displayPieces(g, (Board.checkY[d] * 100) + 15, (Board.checkX[d] * 100) + 15, black_queen); break;
									case "wn":displayPieces(g, (Board.checkY[d] * 100) + 15, (Board.checkX[d] * 100) + 15, white_normal); break;
									case "wq":displayPieces(g, (Board.checkY[d] * 100) + 15, (Board.checkX[d] * 100) + 15, white_queen); break;
	
										
									}
									
								}
								
							}
							
						}
						
					}
					
					switch (pecas[Board.sel1][Board.sel2]) {
					
					case "bn":displayPieces(g, posX, posY, black_normal); break;
					case "bq":displayPieces(g, posX, posY, black_queen); break;
					case "wn":displayPieces(g, posX, posY, white_normal); break;
					case "wq":displayPieces(g, posX, posY, white_queen); break;

						
					}
					
				}
				
				x += Constants.POSITION_SIZE;
				
			}
			
			x = 0;
			y += Constants.POSITION_SIZE;
			
		}
		
	}
	
}
