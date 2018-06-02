package PacmanMVC;

import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import ViewComponents.*;
public class GameView extends JFrame {
	private BoardPanel boardPanel;
	public GameView(){
		super("Pacman");
		boardPanel=new BoardPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setMinimumSize(new Dimension(800, 800));
		setMaximumSize(new Dimension(800, 800));
		setVisible(false);
	}
		
	public void loadBoard(int[][] board) {
		boardPanel.setBoardSetUP(board);
		//setContentPane(boardPanel);
		add(boardPanel);
		setVisible(true);
	}
	public void setBoardListener(KeyListener k) {
	this.boardPanel.addKeyListener(k);
	}
	public void reBoard() {
		boardPanel.repaint();
	}

}
