package PacmanMVC;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {

	private GameView _view;
	private GameModel _model;
	
	public GameController(GameView view,GameModel model){
		_view=view;
		_model=model;
		_view.loadBoard(model.currBoardSetUp());
		_view.setVisible(true);
		_view.setBoardListener(this);
	}
	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			_model.movePacman(KeyEvent.VK_LEFT);
			_view.reBoard();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			_model.movePacman(KeyEvent.VK_RIGHT);
			_view.reBoard();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			_model.movePacman(KeyEvent.VK_UP);
			_view.reBoard();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			_model.movePacman(KeyEvent.VK_DOWN);
			_view.reBoard();
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
