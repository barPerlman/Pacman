package Ghosts;

import Pacman.AngryPacman;
import Pacman.NicePacman;
import Pacman.SafePacman;

public interface Visitor {
	void visit(NicePacman pacman);
	void visit(AngryPacman pacman);
	void visit(SafePacman pacman);
}
