
/**
 * this class define a fruit object
 */


package ModelComponents;
import java.awt.Point;
import javax.swing.text.Position;

public class Fruit {
	private int _fruitType;//tells what kind of fruit is it
	private int _pointsValue;//amount of points pacman earns when eats this
	private boolean isOnBoard;//is visible on board
	private Point _position;
	private boolean _isEaten;
	final static int EMPTY=0,BLOCK=1,PACMAN=2,GHOST1=3,GHOST2=4,GHOST3=5,
			PILL=6,ENERGY=7,PINEAPPLE=8,APPLE=9,STRAWBERRY=10;
	//constructor
	public Fruit(int fruitType,int pointsValue){
		
		this._fruitType=fruitType;
		this._pointsValue=pointsValue;
		this.isOnBoard=false;
	}
//setters and getters
	public int get_fruitType() {
		return _fruitType;
	}

	public void set_fruitType(int _fruitType) {
		this._fruitType = _fruitType;
	}

	public int get_pointsValue() {
		return _pointsValue;
	}

	public void set_pointsValue(int _pointsValue) {
		this._pointsValue = _pointsValue;
	}

	public boolean isOnBoard() {
		return isOnBoard;
	}

	public void setOnBoard(boolean isOnBoard) {
		this.isOnBoard = isOnBoard;
	}

	public Point get_position() {
		return _position;
	}

	public void set_position(Point _position) {
		this._position = _position;
	}
	public boolean get_isEaten() {
		return _isEaten;
	}
	public void set_isEaten(boolean _isEaten) {
		this._isEaten = _isEaten;
	}
	
	
	
	
}
