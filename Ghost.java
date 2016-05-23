// Example of the Decorator Pattern
// Used as part of a presentation for MPCS 51050: Object-Oriented Architecture
// Rules reference: https://en.wikipedia.org/wiki/Pac-Man

// Component
interface Ghost {
	public String name();
	public int[] coord();
	public String identity();
	public String moves();
	public void hitsPacMan();
	public Ghost peel();
	public String toString();
}

// Abstract Decorator
abstract class GhostDecorator implements Ghost {
	protected Ghost decoratedGhost;
	
	public GhostDecorator(Ghost decoratedGhost) {
		this.decoratedGhost = decoratedGhost;
	}
	
	public String name() {
		return decoratedGhost.name();
	}
	
	public int[] coord() {
		return decoratedGhost.coord();
	}
	
	public String identity() {
		return decoratedGhost.identity();
	}
	
	public void hitsPacMan() {
		// Pac-Man loses a life
	}
	
	public Ghost peel() {
		return decoratedGhost;
	}
	
	public String toString() {
		//return identity() + " and he " + howItMoves();
		return identity() + " and he " + moves();
	}
}

// Concrete component
class ConcreteGhost implements Ghost {
	private String name;
	private int[] coord;
	
	public ConcreteGhost(String name, int[] coord) {
		this.name = name;
		this.coord = coord;
	}
	
	public String name() {
		return name;
	}
	
	public int[] coord() {
		return this.coord;
	}
	
	public String identity() {
		return "ghost";
	}
	
	public String moves() {
		return "returns to the center";
	}
	
	public void hitsPacMan() {
		// Nothing happens
	}
	
	// Returns null because this will never be
	// called by the game engine
	public Ghost peel() {
		return null;
	}
	
	public String toString() {
		//return " pair of ghostly eyes and he " + howItMoves();
		return identity() + " and he " + moves();
	}
}

// Concrete decorators
class RedGhostDecorator extends GhostDecorator {
	public RedGhostDecorator(Ghost decoratedGhost) {
		super(decoratedGhost);
	}

	public String identity() {
		return "red " + super.identity();
	}
	
	public String moves() {
		return "chases";
	}
}

class PinkGhostDecorator extends GhostDecorator {
	public PinkGhostDecorator(Ghost decoratedGhost) {
		super(decoratedGhost);
	}
	
	public String identity() {
		return "pink " + super.identity();
	}
	
	public String moves() {
		return "ambushes";
	}
}

class CyanGhostDecorator extends GhostDecorator {
	public CyanGhostDecorator(Ghost decoratedGhost) {
		super(decoratedGhost);
	}
	
	public String identity() {
		return "cyan " + super.identity();
	}
	
	public String moves() {
		return "is fickle";
	}
}

class OrangeGhostDecorator extends GhostDecorator {
	public OrangeGhostDecorator(Ghost decoratedGhost) {
		super(decoratedGhost);
	}
	
	public String identity() {
		return "orange " + super.identity();
	}
	
	public String moves() {
		return "feigns ignorance";
	}
}

class BlueGhostDecorator extends GhostDecorator {
	public BlueGhostDecorator(Ghost decoratedGhost) {
		super(decoratedGhost);
	}
	
	public String identity() {
		return "blue " + super.identity();
	}
	
	public String moves() {
		return "runs away";
	}

	public void hitsPacMan() {
		// This ghost is eaten
	}
}