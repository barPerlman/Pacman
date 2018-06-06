package ModelComponents;
import java.awt.Point;

public class Pacman {
	private Point _pos;
	
	public Pacman(int x, int y) {
		_pos=new Point(x, y);
		
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
