package PacmanMVC;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class GameController implements KeyListener,ActionListener {

	private GameView _view;
	private GameModel _model;
	private Timer _gameTimer;//the timer of the game
	
	
	
	public GameController(GameView view,GameModel model){
		_view=view;
		_model=model;
		_view.loadBoard(model.currBoardSetUp());
		_view.setVisible(true);
		_view.setBoardListener(this);
	}
	

	public void keyPressed(KeyEvent e) {
		
		//events of key press for pacman moving
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
		//event of start game-press space
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			
			
			//start gameTimer if its the first time space pressed
			if(!(_view.getBoardPanel().getIsGameStarted())){//first space press
				//disappear the panel of "get ready"
				
				//initial and start timer
				this._gameTimer=new Timer(1000,this);
				_gameTimer.start();
			}
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


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==_gameTimer){//delay has been reached
			//raise seconds counter
			_view.set_secondsCounter(_view.get_secondsCounter()+1);
			
			boolean tFruitTime=updateAndCheckFruitTime();//check if its fruit time
			if(tFruitTime){
				_model.get_board().set_secondsFlicked(0);//zeroize counter for flick seconds
				_model.get_board().randomizeFruitsLocation();//set fruits location
				_view.reBoard();
				//raise counter
				_model.get_board().set_secondsFlicked(_model.get_board().get_secondsFlicked()+1);
				
			}
			else if(_view.get_secondsCounter()>10){
				if(_model.get_board().get_secondsFlicked()<=4){
					flickFruits();
					_model.get_board().set_secondsFlicked(_model.get_board().get_secondsFlicked()+1);
				}
					
				}
			}
		}
		
	
	/**
	 * checks if need to put and flick fruits on board
	 * @return
	 */
public boolean updateAndCheckFruitTime(){
	if(_view.get_secondsCounter()>=10){//fruitsAre drawble(after 10 secs)
		if(_view.get_secondsCounter()%10==0){//time to start draw fruits
			
			_model.get_board().set_isFruitsTime(true);
			return true;
		}
		_model.get_board().set_isFruitsTime(false);
	}
	return false;
}
/**
 * flickering fruits on board
 */
public void flickFruits(){
		_model.get_board().flickeringFruits();
		_view.reBoard();
	
	
}

}
