package ModelComponents;

import java.awt.Point;
import java.util.Random;

public class Board {
	int[][] _currBoard;
	private Pacman _pacman;
	//fruits instances
	private Fruit _pineapple;
	private Fruit _apple;
	private Fruit _strawberry;
	private Fruit[] _fruits;
	private boolean _isFruitsTime;//is it time to draw fruits
	private int _secondsFlicked;//tells how many seconds the fruits flicked 
	private int _secondsFadeOut;//tells how many seconds the fruits are faded out 
	private boolean _gameStarted;//true if space pressed-tells if game started
	
	
	final static int SIZE=32;
	//gameTools:
	final static int EMPTY=0,BLOCK=1,PACMAN=2,GHOST1=3,GHOST2=4,GHOST3=5,
			PILL=6,ENERGY=7,PINEAPPLE=8,APPLE=9,STRAWBERRY=10;
	
	public Board(int level){
		_pacman = new Pacman(15,12);
		_currBoard=new int[32][32];
		generateLevelBoard(level);
		
		initBoardLvl1();//initialize the board with level 1 appearance
	}

/**
 * generate fit board and instances to each level
 * @param level
 */
	private void generateLevelBoard(int level) {
		switch(level){
			case 1://level 1
				//fruits initials:
				_pineapple=new Fruit(PINEAPPLE,100,2);
				_apple=new Fruit(APPLE,200,2);
				_strawberry=new Fruit(STRAWBERRY,300,0);
				_fruits=new Fruit[3];
				_fruits[0]=_pineapple;
				_fruits[1]=_apple;
				_fruits[2]=_strawberry;
				initBoardLvl1();
				break;
			
			default:
				System.out.println("wrong level input");
		}
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
				{1,1,1,1,1,1,0,0,0,1,6,1,6,6,6,6,6,6,6,1,6,6,1,0,0,0,0,1,1,1,1,1},
				{1,1,1,1,1,1,0,0,0,1,6,1,6,6,6,1,6,6,6,1,6,6,1,0,0,0,0,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,6,6,1,1,1,1,1,6,6,6,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,6,1,1,1,1,1,1,6,1,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,0,0,0,1,6,1,6,1,0,0,0,0,1,6,1,6,1,0,0,0,0,1,1,1,1,1},
				{1,1,1,1,1,1,0,0,0,1,6,1,6,1,0,0,0,0,1,6,1,6,1,0,0,0,0,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,6,1,1,1,1,1,1,6,1,6,1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,6,6,6,6,6,1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1,6,1,6,1,1,1,1,6,1,1,1,1,1,1,1,6,1,1,1,1,1,1},
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
		_currBoard[15][12]=PACMAN;
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
			//update the location of the fruit
			if(_fruits[tGameTool-8].get_remainFruits()>0){
			_fruits[tGameTool-8].set_position(new Point(tX, tY));
			_fruits[tGameTool-8].setOnBoard(true);//now its on board
			_currBoard[tX][tY]=tGameTool;//update board with the fruit
			}
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
		if(_currBoard[0].length>tPacCol+1 && _currBoard[tPacLine][tPacCol+1]!=BLOCK) {
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine][tPacCol+1]=PACMAN;
		_pacman.set_pos(tPacLine, tPacCol+1);
		}
	}
	public void MovePacLeft() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		if(0<=tPacCol-1 && _currBoard[tPacLine][tPacCol-1]!=BLOCK) {
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine][tPacCol-1]=PACMAN;
		_pacman.set_pos(tPacLine, tPacCol-1);}
	}
	public void MovePacDown() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		if(_currBoard.length>tPacLine+1 && _currBoard[tPacLine+1][tPacCol]!=BLOCK) {
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine+1][tPacCol]=PACMAN;
		_pacman.set_pos(tPacLine+1, tPacCol);}
	}
	public void MovePacUp() {
		int tPacLine = _pacman.get_posLine();
		int tPacCol = _pacman.get_posColum();
		if(0<=tPacLine-1 && _currBoard[tPacLine-1][tPacCol]!=BLOCK) {
		_currBoard[tPacLine][tPacCol]=EMPTY;
		_currBoard[tPacLine-1][tPacCol]=PACMAN;
		_pacman.set_pos(tPacLine-1, tPacCol);}
	}
	/**
	 * flicker fruits on board (change their visibility on board) one time
	 * from in board to not and the opposite
	 */
	public void flickeringFruits(){
		for(int i=0;i<3;i++){
			Fruit tCurrFruit=_fruits[i];
			
			if(tCurrFruit.get_remainFruits()>0){
			//change visibility status
			boolean tVisibilityStatus=_fruits[i].isOnBoard();
			
			_fruits[i].setOnBoard(!tVisibilityStatus);
			int tX=(int) _fruits[i].get_position().getX();
			int tY=(int) _fruits[i].get_position().getY();
			if(tVisibilityStatus){
				_currBoard[tX][tY]=EMPTY;
				_fruits[i].setOnBoard(false);
			}
			else if(!(tCurrFruit.get_isEaten())){//fruits are not on board and should be
				_currBoard[tX][tY]=_fruits[i].get_fruitType();//set into board
			}
			}
		}
	}
	/**
	 * remove all fruits from board
	 */
	public void removeFruitsFromBoard(){
		Fruit tCurrFruit;
		for(int i=PINEAPPLE;i<=STRAWBERRY;i++){
			tCurrFruit=_fruits[i-8];
			if(tCurrFruit.get_remainFruits()>0){
			int tRow=(int)tCurrFruit.get_position().getX();
			int tCol=(int)tCurrFruit.get_position().getY();
			removeCharacterFromBoardCell(tRow, tCol);
			tCurrFruit.setOnBoard(false);
			}
		}
	}


	public boolean is_isFruitsTime() {
		return _isFruitsTime;
	}


	public void set_isFruitsTime(boolean _isFruitsTime) {
		this._isFruitsTime = _isFruitsTime;
	}
	public int get_secondsFlicked() {
		return _secondsFlicked;
	}


	public void set_secondsFlicked(int _secondsFlicked) {
		this._secondsFlicked = _secondsFlicked;
	}


	public int get_secondsFadeOut() {
		return _secondsFadeOut;
	}


	public void set_secondsFadeOut(int _secondsFadeOut) {
		this._secondsFadeOut = _secondsFadeOut;
	}
	public boolean getIsGameStarted(){
		return _gameStarted;
	}
	public void setIsgameStarted(boolean isStarted){
		this._gameStarted=isStarted;
	}
}
