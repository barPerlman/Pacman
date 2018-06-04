package ModelComponents;

public abstract class GameTool implements Visitor,Visited{
	public abstract void eats(GameTool gameTool);
}
