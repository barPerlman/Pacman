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


	public Board get_board() {
		return _board;
	}


	public void set_board(Board _board) {
		this._board = _board;
	}


	public static int get_points() {
		return _points;
	}


	public static void set_points(int _points) {
		GameModel._points = _points;
	}
}

