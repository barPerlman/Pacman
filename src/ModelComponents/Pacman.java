package ModelComponents;
import java.awt.Point;

public class Pacman extends GameTool {
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

	
	
	@Override
	public void visit(Fruit fruit) {
		
		
	}

	@Override
	public void visit(Pacman pacman) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Ghost ghost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FireBall fireBall) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(WaterSplash waterSplash) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * visitor,visited pattern implementation
	 */
	public void accept(GameTool gameTool) {
		gameTool.visit(this);
		
	}

	@Override
	public void eats(GameTool gameTool) {
		gameTool.accept(this);
		
	}
	
}
