package ViewComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	String _lvl1BlockPath = "images/block25.png";
	ImageIcon _blockImage;
	ImageIcon _pillImage;
	ImageIcon _energyImage;
	ImageIcon _pineappleImage;
	ImageIcon _appleImage;
	ImageIcon _strawberryImage;
	ImageIcon _emptyImage;
	
	// gameTools:
	final static int EMPTY = 0, BLOCK = 1, PACMAN = 2, GHOST1 = 3, GHOST2 = 4, GHOST3 = 5, PILL = 6, ENERGY = 7,
			PINEAPPLE = 8, APPLE = 9, STRAWBERRY = 10;

	
	// the controller updates later the board appearance
	private int[][] receivedBoard;

	public BoardPanel() {
		_blockImage = new ImageIcon(_lvl1BlockPath);
		_pillImage = new ImageIcon("images/pill.png");
		_energyImage = new ImageIcon("images/energy.png");
		_pineappleImage = new ImageIcon("images/pineapple.png");
		_appleImage = new ImageIcon("images/apple.png");
		_strawberryImage = new ImageIcon("images/strawberry.png");
		_emptyImage=new ImageIcon("images/empty.png");
		
		
		
	}

	public void paint(Graphics g) {

		Image offIm = createImage(800, 800);
		Graphics g2 = offIm.getGraphics();
		// this draw the board on the second graphic
		for (int i = 0; i < receivedBoard.length; i++) {
			for (int j = 0; j < receivedBoard.length; j++) {
				if (receivedBoard[i][j] == BLOCK) {
					// g.fillRect(i*25, j*25, 25, 25);
					_blockImage.paintIcon(this, g2, i * 25, j * 25);
				}
				else if(receivedBoard[i][j]==PILL){
					_pillImage.paintIcon(this, g2, i * 25, j * 25);
				}
				else if(receivedBoard[i][j]==ENERGY){
					_energyImage.paintIcon(this, g2, i * 25, j * 25);
				}
				else if(receivedBoard[i][j]==PINEAPPLE){
					_pineappleImage.paintIcon(this, g2, i * 25, j * 25);
				}
				else if(receivedBoard[i][j]==APPLE){
					_appleImage.paintIcon(this, g2, i * 25, j * 25);
				}
				else if(receivedBoard[i][j]==STRAWBERRY){
					_strawberryImage.paintIcon(this, g2, i * 25, j * 25);
				}
				else if(receivedBoard[i][j]==EMPTY){
					_emptyImage.paintIcon(this, g2, i * 25, j * 25);
				}
			}
		}
		g.drawImage(offIm, 0, 0, this);// update the graphic with the second updeted one
	}

	public void setBoardSetUP(int[][] board) {
		this.receivedBoard = board;
	}

}
