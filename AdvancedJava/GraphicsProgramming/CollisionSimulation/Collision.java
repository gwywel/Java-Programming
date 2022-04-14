/*
* File: Collision.java
* Description: This program shows two animated blocks of differing mass and velocity colliding.
* The final velocities are calculated upon collision and the animation ends once both blocks are off-screen.
* The position of each block is recorded in an ArrayList and outputted to a two-column csv file.
*/
import java.util.ArrayList;
import java.lang.Math;

public class Collision {

	/* constants */

	// width and height of window in pixels
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;

	// rescaling of window coordinates
	public static final int X_MIN = -1;
	public static final int X_MAX = 1;
	public static final int Y_MIN = -1;
	public static final int Y_MAX = 1;

	// size of blocks in window coordinates
	public static final double BLOCK_WIDTH = 0.2;
	public static final double BLOCK_HEIGHT = 0.1;

	// animation constants
	public static final int PAUSE = 16; // milliseconds between frames
	public static final double BUFFER = 0.001; // small quantity to avoid bugs


	/* class variables */

	// starting x-coordinates for each block (y will always be 0)
	private static double x1 = -.5;
	private static double x2 = .5;

	// block masses (in unspecified units)
	private static double m1 = 1; // originally 1
	private static double m2 = 3; // originally 3

	// block starting velocities (# represents half-screens per second)
	private static double v1 = 0.5*PAUSE/1000; // originally 0.5
	private static double v2 = -0.2*PAUSE/1000; // originally -0.2

	// TODO: declare ArrayList(s) to store position information
	private static ArrayList<Double> block1 = new ArrayList<Double>();
	private static ArrayList<Double> block2 = new ArrayList<Double>();

	/* main controls setup, animation, and printing position data */
	public static void main(String[] args) {
		// setup canvas and show blocks at initial positions
		setup();
		drawBlocks();

		// TODO: write while condition to stop animation when blocks leave screen
		while ( (Math.abs(x1 + (BLOCK_WIDTH/2)) < (X_MAX + BLOCK_WIDTH) ) ||
		(Math.abs(x2 + (BLOCK_WIDTH/2)) < (X_MAX + BLOCK_WIDTH) ) ) {
			update();
			drawBlocks();
			StdDraw.pause(PAUSE);
		}

		// wait for keystroke after blocks have left screen
		while (!StdDraw.hasNextKeyTyped()) {
			StdDraw.pause(PAUSE);
		}

		// output locations of both blocks in csv format before exiting program
		printPositions();
		System.exit(0);
	}

	/* set up StdDraw canvas and establish coordinate system */
	private static void setup() {
		StdDraw.setCanvasSize(WIDTH, HEIGHT);
		StdDraw.setXscale(X_MIN, X_MAX);
		StdDraw.setYscale(Y_MIN, Y_MAX);
		StdDraw.enableDoubleBuffering();
	}

	/* draw blocks at current locations, labeled with their masses */
	private static void drawBlocks() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(x1, 0, BLOCK_WIDTH/2, BLOCK_HEIGHT/2);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledRectangle(x2, 0, BLOCK_WIDTH/2, BLOCK_HEIGHT/2);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x1, 0, ""+m1);
		StdDraw.text(x2, 0, ""+m2);
		StdDraw.show();
	}

	/* TODO: update position and velocities of blocks */
	private static void update() {
		// add velocity to position
		x1 += v1;
		x2 += v2;
		double t = 0;
		if ((x2 - x1) < BLOCK_WIDTH) {
			// calculate time t before collision
			t = ( ( (x1 + BLOCK_WIDTH/2) - (x2 - BLOCK_WIDTH/2) ) / (v1 + v2) ) + BUFFER;
			x1 -= t * v1;
			x2 -= t * v2;
			// calculate new velocities following collision
			double v1New = (v1 * (m1 - m2) + (2 * m2 * v2)) / (m1 + m2);
			v2 = (v2 * (m2 - m1) + (2 * m1 * v1)) / (m1 + m2);
			v1 = v1New;
		}
		// move positions back to time after collision
		x1 += t * v1;
		x2 += t * v2;
		// add positions to arrayLists
		block1.add(x1);
		block2.add(x2);
	}

	/* TODO: print out the locations of both blocks in csv format */
	private static void printPositions() {
		double table[][] = new double[block1.size()][2];
		for (int i = 0; i < block1.size(); i++) {
			// put information in table
			table[i][0] = block1.get(i);
			table[i][1] = block2.get(i);
			// print information in format: time t, x1, x2
			System.out.println(i + ", " + table[i][0] + ", " + table[i][1]);
		}
	}

}
