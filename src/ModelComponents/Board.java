package ModelComponents;

import java.util.Random;

public class Board {
	int[][] _currBoard;
	private Pacman _pacman;
	final static int SIZE=32;
	//gameTools:
	final static int EMPTY=0,BLOCK=1,PACMAN=2,GHOST1=3,GHOST2=4,GHOST3=5,
			PILL=6,ENERGY=7,PINEAPPLE=8,APPLE=9,STRAWBERRY=10;
	
	public Board(int level){
		_pacman = new Pacman(15, 15);
		_currBoard=new int[32][32];
		switch(level){
			case 1:
				initBoardLvl1();
				break;
			
			default:
				System.out.println("wrong level input");
		}
		
		initBoardLvl1();//initialize the board with level 1 appearance
	}
	
	
	public void initBoardLvl1(){
		int [][] lvl1Board={
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,7,6,6,6,6,6,6,6,6,1,6,6,6,6,6,6,6,6,6,6,7,1,1,1,1,1},
				{1,1,1,1,1,1,6,1,1,1,6,1,1,1,6,1,6,1,1,1,6,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,1,1,1,6,1,1,1,6,1,6,1,1,1,6,1,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,1,1,1,6,1,6,1,1,1,1,1,6,1,6,1,1,6,6,6,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,1,6,6,6,1,6,6,6,1,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,1,1,6,1,6,1,1,1,6,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,1,6,1,6,6,6,6,6,6,6,1,6,6,1,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,1,6,1,6,6,6,1,6,6,6,1,6,6,1,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,6,6,1,1,1,1,1,6,6,6,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,6,1,1,1,1,6,6,1,1,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,1,6,1,6,1,6,6,1,6,6,1,1,6,1,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,1,6,1,6,1,6,6,1,6,6,1,1,6,1,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,6,1,6,6,1,6,6,1,1,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,1,6,1,6,6,1,6,6,6,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,6,1,6,6,1,6,1,1,1,1,1,1,1,6,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,6,6,1,1,1,1,6,6,6,6,1,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,6,6,6,6,6,6,6,6,6,6,1,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,6,1,1,1,1,6,6,6,6,6,1,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,1,1,1,1,6,1,6,6,1,1,1,1,1,6,1,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,1,6,6,6,6,1,6,6,6,6,1,6,6,6,1,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,1,6,1,1,1,1,1,1,6,6,1,6,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,6,6,6,6,6,6,6,6,6,6,6,1,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,1,6,1,1,1,1,1,1,6,1,6,1,6,1,6,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,1,1,1,6,1,1,1,1,1,1,6,1,6,1,6,1,6,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,6,1,1,1,1,1,1,6,1,6,6,6,1,6,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,6,1,1,1,1,1,1,6,1,1,1,1,1,6,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
				};
		_currBoard=lvl1Board;
	}
	
	//put the gameTool in the (x,y) cell in board
	public void addCharacterToBoardCell(int x,int y,int gameTool){	
		_currBoard[x][y]=gameTool;
	}
	//remove the game tool from the (x,y) cell in board
	public void removeCharacterFromBoardCell(int x,int y){
		_currBoard[x][y]=EMPTY;
	}
	public int[][] getBoard(){
		return _currBoard;
	}
	//randomize fruits location and insert into board
	public void randomizeFruitsLocation(){
		int tX,tY;
		Random rand=new Random();
		//randomize for each fruit
		for(int tGameTool=PINEAPPLE;tGameTool<=STRAWBERRY;tGameTool++){
		//locate current fruit into empty place
			do{
				tX=rand.nextInt(31);
				tY=rand.nextInt(31);
			}while(_currBoard[tX][tY]!=EMPTY);
		
			_currBoard[tX][tY]=tGameTool;	
		}
	}
	
	//swap between gameTools inside the board
	public void swap(int x1,int y1,int gameTool1,int x2,int y2,int gameTool2){
		//cases to check: gameTool 1 is the eater and 2 is eaten or they are equal
	}
	//checks if swap between two given characters is valid
	public boolean isLegalSwap(int gameTool1,int gameTool2){
		if(gameTool1==BLOCK||gameTool2==BLOCK){
			return false;
		}
		return true;
	}
	
	public void MovePacRight() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine][tPacCol+1]=PACMAN;
		_pacman.set_pos(tPacLine, tPacCol+1);
	}
	public void MovePacLeft() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine][tPacCol-1]=PACMAN;
		_pacman.set_pos(tPacLine, tPacCol-1);
	}
	public void MovePacDown() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine+1][tPacCol]=PACMAN;
		_pacman.set_pos(tPacLine+1, tPacCol);
	}
	public void MovePacUp() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine-1][tPacCol]=PACMAN;
		_pacman.set_pos(tPacLine-1, tPacCol);
	}
	
}
