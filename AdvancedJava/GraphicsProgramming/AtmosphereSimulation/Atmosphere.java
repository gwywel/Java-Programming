/*
* File: Atmosphere.java
* Description: This program sets the width and height of the application window
* and initializes a series of constants. An array of molecules is declared and
* populated with N-N_GG molecules and N_GG greenhouse gases. The update() method
* updates the positions and velocities of all molecules in the array using method
* calls to Molecule.java, and increases the count of the histogram array and
* displays each update in the window.
*/

public class Atmosphere {

	// application width/height/scale
	public static final int WIDTH = 500; // width of simulator window (500 pixels)
	public static final int HEIGHT = 500; // height of simulator window (500 pixels)
	public static final int PAUSE = 16; // milliseconds between frames (16)

	// particle constants
	public static final int N = 200; // total number of particles (200)
	public static final double RADIUS = 0.01; // radius of regular particle (1% of window)
	public static final double M = 1; // mass of regular particle
	public static final double V_MAX = 0.5*PAUSE/1000; // max velocity (0.5 windows/sec)
	public static final int N_GG = 3; // number of greenhouse gas molecules (3)
	public static final double RADIUS_GG = 0.015; // size of greenhouse gas (1.5% of window)
	public static final double M_GG = 2.25; // mass of greenhouse gas
	private static final double PHOTON_PROB = 0.3*PAUSE/1000; // 0.3 photons absorbed/sec in expectation
	private static final double PHOTON_ACC = 2; // instantaneous 2x velocity increase

	// class variable for array of molecules
	public static Molecule[] molecules = new Molecule[N];

	// histogram constants and class variable
	public static final boolean DISPLAY_HIST = true;
	public static final int N_BINS = 10;
	public static int[] histogram = new int[N_BINS];

	// main calls setup and runs animation loop
	public static void main(String[] args) {
		// graphical and object setup
		setupCanvas();
		constructMolecules();

		// never-ending animation loop
		while (true) {
			display(); // show current state
			update(); // update state
			StdDraw.pause(PAUSE); // pause before next frame
		}
	}

	// set up window dimensions and scale
	private static void setupCanvas() {
		if (!DISPLAY_HIST) {
			StdDraw.setCanvasSize(WIDTH, HEIGHT);
			StdDraw.setYscale(0,1);
		} else {
			StdDraw.setCanvasSize(WIDTH, (int)(1.5*HEIGHT));
			StdDraw.setYscale(-0.5,1);
		}
		StdDraw.setXscale(0,1);
		StdDraw.enableDoubleBuffering();
	}

	// populate the molecules array with molecules and greenhouse gases
	private static void constructMolecules() {
		for (int i = 0; i < N_GG; i++) {
			molecules[i] = new Molecule(Math.random(), Math.random(), RADIUS_GG, M_GG,
			(Math.random() * (V_MAX + V_MAX) - V_MAX), (Math.random() *
			(V_MAX + V_MAX) - V_MAX), PHOTON_PROB, PHOTON_ACC);
		}
		for (int i = N_GG; i < N; i++) {
			molecules[i] = new Molecule(Math.random(), Math.random(), RADIUS, M,
			(Math.random() * (V_MAX + V_MAX) - V_MAX), (Math.random() *
			(V_MAX + V_MAX) - V_MAX));
		}
	}

	// update positions/velocities of all particles; update histogram counts
	private static void update() {
		// reset histogram
		for (int i = 0; i < N_BINS; i++ ) {
			histogram[i] = 0;
		}
		// update positions/velocities
		for (int i = 0; i < molecules.length; i++) {
			molecules[i].updatePosition();
			molecules[i].handleParticleCollisions(molecules);
		}
		// update histogram counts
		for (int i = 0; i < molecules.length; i++) {
			int molSpeed = (int) (molecules[i].getSpeed() * N_BINS / (2 * V_MAX));
			if (molSpeed >= 0 && molSpeed <= 9) histogram[molSpeed]++;
		}
	}

	// draw all particles and (if selected) histogram
	private static void display() {
		StdDraw.clear();
		drawParticles();
		if (DISPLAY_HIST) drawHist();
		StdDraw.show();
	}

	// call draw method for each particle
	private static void drawParticles() {
		for (int i=0; i<N; i++) {
			molecules[i].draw();
		}
	}

	// display histogram as a bar graph
	private static void drawHist() {
		StdDraw.setPenColor(); // default black
		StdDraw.line(0, 0, 1, 0); // line separating simulation from histogram
		double binWidth = 1.0/N_BINS; // width of bin
		double histScale=0.5/N; // height of a single molecule
		for (int i=0; i<N_BINS; i++) {
			double binHeight = histogram[i]*histScale; // height of current bin
			StdDraw.filledRectangle((i+0.5)/N_BINS,-0.5+binHeight/2,binWidth/2,binHeight/2);
		}
	}

}
