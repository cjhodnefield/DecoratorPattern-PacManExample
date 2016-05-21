// Example of the Decorator Pattern
// Used as part of a presentation for MPCS 51050: Object-Oriented Architecture
// Rules reference: https://en.wikipedia.org/wiki/Pac-Man

// Component
interface Ghost {
	public String name();
	public int[] coord();
	public String identity();
	public String howItMoves();
	public Ghost peel();
	public String toString();
}

// Abstract Decorator
abstract class GhostDecorator implements Ghost {
	protected Ghost decoratedGhost;
	
	public GhostDecorator(Ghost decoratedEntity) {
		this.decoratedGhost = decoratedEntity;
	}
	
	public String name() {
		return decoratedGhost.name();
	}
	
	public int[] coord() {
		return decoratedGhost.coord();
	}
	
	public Ghost entity() {
		return decoratedGhost;
	}
	
	public String identity() {
		return decoratedGhost.identity();
	}
	
	public Ghost peel() {
		return null;
	}
	
	public String toString() {
		return identity() + " and he " + howItMoves();
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
	
	public String howItMoves() {
		return "returns to the center";
	}
	
	public Ghost peel() {
		return null;
	}
	
	public String toString() {
		return " pair of ghostly eyes and he " + howItMoves();
	}
}

class RedGhostDecorator extends GhostDecorator {
	public RedGhostDecorator(Ghost decoratedEntity) {
		super(decoratedEntity);
	}

	public String identity() {
		return "red " + super.identity();
	}
	
	public String howItMoves() {
		return "chases";
	}
}

class PinkGhostDecorator extends GhostDecorator {
	public PinkGhostDecorator(Ghost decoratedEntity) {
		super(decoratedEntity);
	}
	
	public String identity() {
		return "pink " + super.identity();
	}
	
	public String howItMoves() {
		return "ambushes";
	}
}

class CyanGhostDecorator extends GhostDecorator {
	public CyanGhostDecorator(Ghost decoratedEntity) {
		super(decoratedEntity);
	}
	
	public String howItMoves() {
		return "is fickle";
	}
	
	public String identity() {
		return "cyan " + super.identity();
	}
}

class OrangeGhostDecorator extends GhostDecorator {
	public OrangeGhostDecorator(Ghost decoratedEntity) {
		super(decoratedEntity);
	}
	
	public String howItMoves() {
		return "feigns ignorance";
	}
	
	public String identity() {
		return "orange " + super.identity();
	}
}

class BlueGhostDecorator extends GhostDecorator {
	public BlueGhostDecorator(Ghost decoratedGhost) {
		super(decoratedGhost);
	}
	
	public String howItMoves() {
		return "runs away";
	}
	
	public String identity() {
		return "blue ghost";
	}
	
	public Ghost peel() {
		return decoratedGhost;
	}
}