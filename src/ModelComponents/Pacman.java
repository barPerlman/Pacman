package ModelComponents;
import java.awt.Point;

public abstract class Pacman implements Visited{
	private Point _pos;
	private int pointEarnsInEvent;//received points from interaction
	private boolean _isAlive;//status of life
	private int amountOfLives; //current amount of lives for Pacman
	
	public Pacman(int x, int y) {
		_pos=new Point(x, y);
		_isAlive=true;
	}

	public int get_posLine() {
		return _pos.x;
	}
	public int get_posColum() {
		return _pos.y;
	}

	public void set_pos(int L, int C) {
		_pos.setLocation(L, C);
	}

	
	
}
