package ModelComponents;

public interface Visitor {
	void visit(NicePacman pacman);
	void visit(AngryPacman pacman);
	void visit(SafePacman pacman);
}
