package ModelComponents;
import java.awt.Point;

public class Pacman {
	private Point _pos;
	
	public Pacman() {
		_pos=new Point(0, 0);
		
	}

	public Point get_posLine() {
		return _pos;
	}
	public Point set_posColum() {
		return _pos;
	}

	public void set_pos(int x, int y) {
		_pos.setLocation(x, y);
	}
	
}
