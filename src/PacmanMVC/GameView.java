package PacmanMVC;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import ViewComponents.*;
public class GameView extends JFrame {
	private BoardPanel boardPanel;
	private int _points;
	public GameView(){
		super("Pacman");
		_points=0;
		boardPanel=new BoardPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setMinimumSize(screenSize);
		setMaximumSize(screenSize);
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
	
	public void addPoints(int n) {
		_points+=n;	
	}

}
