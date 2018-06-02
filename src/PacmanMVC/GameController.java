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

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){

		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			_model.set2();
			_view.reBoard();
		
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
		}
		System.out.println("hi");
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
