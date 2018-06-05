package ModelComponents;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class GameTimer implements ActionListener{

	
	private static GameTimer instance;
	private Timer gameTimer;
	private List <ListenerToTimer> listenersToTimer;
	 
	public static GameTimer getInstance(){
		if(instance==null){
			instance=new GameTimer();
		}
		return instance;
	}
	private GameTimer() {
		gameTimer=new Timer(1000, this);
		listenersToTimer=new ArrayList<>();
		gameTimer.start();
	}
	public void addListener(ListenerToTimer listener){
		listenersToTimer.add(listener);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		for(ListenerToTimer listener:listenersToTimer){
			listener.timerAction();
		}
		
	}

}
