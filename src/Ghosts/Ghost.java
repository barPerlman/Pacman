package Ghosts;

public abstract class Ghost implements Visitor{
	
	private int ghostName;//ghost name
	private int timeToAct; //time of the current ghost type to act
	private int weapon; //type of wepon
	static final int FIREBALL=32,WATERSPLASH=64; //weapons
	static final int GINKEY=77,INKY=88,BLINKY=99; //ghosts name
	//ginkey=green,inkey=yellow,blinky=red
	
	public Ghost(int name,int delay,int weapon){
		ghostName=name;
		timeToAct=delay;
		this.weapon=weapon;
	}
	
	
}
