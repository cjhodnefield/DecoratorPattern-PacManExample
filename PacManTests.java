// Example of the Decorator Pattern
// Used as part of a presentation for MPCS 51050: Object-Oriented Architecture
// Rules reference: https://en.wikipedia.org/wiki/Pac-Man

import java.util.ArrayList;

public class PacManTests {

	public static void main(String[] args) {
		// The game engine would keep track of certain
		// state mechanics that are not implemented here,
		// so this is largely a simulation for demo purposes
		
		// Initialize an array with the four ghosts
		ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
		ghosts.add(new RedGhostDecorator(new ConcreteGhost("Blinky", new int[] {1, 1})));
		ghosts.add(new PinkGhostDecorator(new ConcreteGhost("Pinky", new int[] {1, 2})));
		ghosts.add(new CyanGhostDecorator(new ConcreteGhost("Inky", new int[] {2, 1})));
		ghosts.add(new OrangeGhostDecorator(new ConcreteGhost("Clyde", new int[] {2, 2})));
		
		// Start of the game
		System.out.println("The game begins:");
		printGhosts(ghosts);
		System.out.println("===============================================");
		
		// Pac-Man eats a power pellet
		System.out.println("Pac-Man eats a power pellet:");
		blueGhosts(ghosts);
		printGhosts(ghosts);
		System.out.println("===============================================");

		// Pac-Man eats Blinky
		System.out.println("Pac-Man eats Blinky:");
		ghosts.set(0, ghosts.get(0).peel().peel());
		printGhosts(ghosts);
		System.out.println("===============================================");
		
		// Blinky returns to the center
		System.out.println("Blinky returns to the center:");
		ghosts.set(0, new RedGhostDecorator(ghosts.get(0)));
		printGhosts(ghosts);
		System.out.println("===============================================");
		
		// The power pellet effect expires
		System.out.println("The power pellet effect expires:");
		ghosts.set(1, ghosts.get(1).peel());
		ghosts.set(2, ghosts.get(2).peel());
		ghosts.set(3, ghosts.get(3).peel());
		printGhosts(ghosts);
	}
	
	public static void printGhosts(ArrayList<Ghost> ghosts) {
		for (Ghost e: ghosts) {
			System.out.println(e.name() + " is a " + e);
		}
	}
	
	public static void blueGhosts(ArrayList<Ghost> ghosts) {
		for (Ghost e: ghosts) {
			ghosts.set(ghosts.indexOf(e), new BlueGhostDecorator(e));
		}
	}
}