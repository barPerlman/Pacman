package Pacman;

import Ghosts.Visitor;

public interface Visited {
	void accept(Visitor v);
}
