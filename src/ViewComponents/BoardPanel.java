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
	
	//original not faded icons
	ImageIcon _pineappleImageOrig;
	ImageIcon _appleImageOrig;
	ImageIcon _strawberryImageOrig;
	
	
	
	ImageIcon _pineappleImage;
	ImageIcon[] _pineAppleFadedImages;
	
	ImageIcon _appleImage;
	ImageIcon[] _appleFadedImages;
	
	ImageIcon _strawberryImage;
	ImageIcon[] _strawberryFadedImages;
	
	ImageIcon _emptyImage;
	ImageIcon _pacman;
	
	private int _fadeSession;//current index of fade out picture;
	

	// gameTools:
	final static int EMPTY = 0, BLOCK = 1, PACMAN = 2, GHOST1 = 3, GHOST2 = 4, GHOST3 = 5, PILL = 6, ENERGY = 7,
			PINEAPPLE = 8, APPLE = 9, STRAWBERRY = 10;

	
	// the controller updates later the board appearance
	private int[][] receivedBoard;

	public BoardPanel() {
		imagesSourceInit();
		setFocusable(true);
		setRequestFocusEnabled(true);
		
	}
/**
 * initial the image icons with a source
 */
	private void imagesSourceInit() {
		_blockImage = new ImageIcon(_lvl1BlockPath);
		_pillImage = new ImageIcon("images/pill.png");
		_energyImage = new ImageIcon("images/energy.png");
		_pineappleImageOrig = new ImageIcon("images/pineapple.png");
		_appleImageOrig = new ImageIcon("images/apple.png");
		_strawberryImageOrig = new ImageIcon("images/strawberry.png");
		_pineappleImage=_pineappleImageOrig;
		_appleImage=_appleImageOrig;
		_strawberryImage=_strawberryImageOrig;
		
		_emptyImage=new ImageIcon("images/empty.png");
		_pacman=new ImageIcon("images/pacmanDown.png");
		_pineAppleFadedImages=new ImageIcon[3];
		_appleFadedImages=new ImageIcon[3];
		_strawberryFadedImages=new ImageIcon[3];
		
		for(int i=0;i<3;i++){
			_pineAppleFadedImages[i]=new ImageIcon("images/pineFade"+i+".png");
			_appleFadedImages[i]=new ImageIcon("images/appleFade"+i+".png");
			_strawberryFadedImages[i]=new ImageIcon("images/strawberryFade"+i+".png");
		}
	}
/**
 * paint the board as graphic panel
 */
	public void paint(Graphics g) {

		Image offIm = createImage(800, 800);
		Graphics g2 = offIm.getGraphics();
		// this draw the board on the second graphic
		for (int i = 0; i < receivedBoard.length; i++) {//draw the suit image 
			for (int j = 0; j < receivedBoard.length; j++) {
				if (receivedBoard[i][j] == BLOCK) {
					
					_blockImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==PILL){
					_pillImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==ENERGY){
					_energyImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==PINEAPPLE){
					_pineappleImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==APPLE){
					_appleImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==STRAWBERRY){
					_strawberryImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==EMPTY){
					_emptyImage.paintIcon(this, g2, j * 25, i * 25);
				}
				else if(receivedBoard[i][j]==PACMAN){
					_pacman.paintIcon(this, g2, j * 25, i * 25);
				}
			}
		}
		g.drawImage(offIm, 0, 0, this);// update the graphic with the second updeted one
	}

	public void setBoardSetUP(int[][] board) {
		this.receivedBoard = board;
	}
	
	/**
	 * this method perform a single fade out session
	 * change to the next brightened picture
	 */
	public void singleFadeOut(){
		this._appleImage=_appleFadedImages[_fadeSession];
		this._pineappleImage=_pineAppleFadedImages[_fadeSession];
		this._strawberryImage=_strawberryFadedImages[_fadeSession];
		
	}

	public int getFadeSession() {
		return _fadeSession;
	}

	public void setFadeSession(int fadeSession) {
		this._fadeSession = fadeSession;
	}
	public void returnToOriginImage(){
		
	
	this._appleImage=_appleImageOrig;
	this._pineappleImage=_pineappleImageOrig;
	this._strawberryImage=_strawberryImageOrig;
	
	}
}
