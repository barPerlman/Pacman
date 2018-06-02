package PacmanMVC;

import ModelComponents.Board;

public class GameModel {
	private Board _board;
	
	public GameModel() {
	 _board = new Board(1);
	}	
		
	
	public int[][] currBoardSetUp(){
		
		return _board.getBoard();
	}
	}