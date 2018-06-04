package ModelComponents;
//visitor interface
public interface Visitor {

	public void visit(Fruit fruit);
	public void visit(Pacman pacman);
	public void visit(Ghost ghost);
	public void visit(FireBall fireBall);
	public void visit(WaterSplash waterSplash);
	
}
