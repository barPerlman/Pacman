package PacmanMVC;

public class GameController {

	GameView view;
	GameModel model;
	
	public GameController(GameView view,GameModel model){
		this.view=view;
		this.model=model;
		view.loadBoard(model.currBoardSetUp());
	}
	
}
