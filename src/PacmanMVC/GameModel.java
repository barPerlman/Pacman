package PacmanMVC;

import java.awt.event.KeyEvent;

import ModelComponents.Board;

public class GameModel {
	private Board _board;
	public static int _points;
	public GameModel() {
	 _board = new Board(1);
	 _points=0;
	}	
		
	
	public int[][] currBoardSetUp(){
		
		return _board.getBoard();
	}
	
	
	
	
	public void movePacman(int n) {
		switch (n) {
		case KeyEvent.VK_DOWN: _board.MovePacDown();
		break;
		case KeyEvent.VK_UP: _board.MovePacUp();
		break;
		case KeyEvent.VK_LEFT: _board.MovePacLeft();
		break;
		case KeyEvent.VK_RIGHT: _board.MovePacRight();
		break;
		
		
		}
		
	}
}

