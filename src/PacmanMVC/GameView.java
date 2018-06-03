package PacmanMVC;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import ViewComponents.*;
public class GameView extends JFrame {
	private BoardPanel _boardPanel;
	private int _points;
	private int _secondsCounter;//count seconds since game started
	public GameView(){
		super("Pacman");
		_points=0;
		_secondsCounter=0;
		_boardPanel=new BoardPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setMinimumSize(screenSize);
		setMaximumSize(screenSize);
		setVisible(false);
	}
		
	public void loadBoard(int[][] board) {
		_boardPanel.setBoardSetUP(board);
		//setContentPane(boardPanel);
		add(_boardPanel);
		setVisible(true);
	}
	public void setBoardListener(KeyListener k) {
	this._boardPanel.addKeyListener(k);
	}
	public void reBoard() {
		_boardPanel.repaint();
	}
	
	public void addPoints(int n) {
		_points+=n;	
	}
	public BoardPanel getBoardPanel(){
		return _boardPanel;
	}

	public int get_secondsCounter() {
		return _secondsCounter;
	}

	public void set_secondsCounter(int _secondsCounter) {
		this._secondsCounter = _secondsCounter;
	}

	public BoardPanel get_boardPanel() {
		return _boardPanel;
	}

	public void set_boardPanel(BoardPanel _boardPanel) {
		this._boardPanel = _boardPanel;
	}

	public int get_points() {
		return _points;
	}

	public void set_points(int _points) {
		this._points = _points;
	}

}
