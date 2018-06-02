package PacmanMVC;

import java.awt.Dimension;

import javax.swing.JFrame;
import ViewComponents.*;
public class GameView extends JFrame {
	BoardPanel boardPanel;
	
	public GameView(){
		super("Pacman");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setMinimumSize(new Dimension(800, 800));
		setMaximumSize(new Dimension(800, 800));
		
		setVisible(false);
	}
		
	public void loadBoard(int[][] board) {
		boardPanel=new BoardPanel();
		boardPanel.setBoardSetUP(board);
		boardPanel.repaint();
		setVisible(true);
	}
		// TODO Auto-generated method stub

}
