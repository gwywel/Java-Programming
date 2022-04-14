/*
* File: Rock.java
* Description: This program stores private instance variables that
* pertain to the Rock object (semiMajorAxis, semiMinorAxis, the
* initial velocity, the initial position on the y-axis, the
* intial position on the x-axis, the elasticity (a final
* variable to account for the invariability of the elasticity of
* rocks as opposed to balls), and the gravity constant). The
* Rock object's position on the canvas is updated with a public
* method that is called from the MultiBounceApplication class.
* The Rock constructor uses parameters define in the
* MultiBounceApplication class to create a variety of Rock
* objects with different properties that are applied and obtained
* using public getter methods (x, semiMajorAxis, semiMinorAxis,
* elasticity, and y).
*/

public class Rock {

	/* private instance variables */

	// ellipse axes
	private double semiMajorAxis;
	private double semiMinorAxis;

	// initial velocity
	private double v = 0;

	// position on the y-axis
	private double y = 1.8;

	// position on the x-axis
	private double x;

	// velocity retained on impact
	private final double ELASTICITY = 0.1;

	// gravity, a constant that relates to PAUSE between frames
	private static final double GRAVITY = -0.1*MultiBounceApplication.PAUSE/1000;

	// update the position and velocity of the rock
	public void update() {
		// if rock is falling off screen, negate velocity
		if (y-semiMinorAxis<0) {
			// rewind to previous frame to avoid another collision next frame
			v -= GRAVITY;
			y -= v;
			// negate velocity
			v *= -ELASTICITY;
		}
		// update position and velocity
		y += v;
		v += GRAVITY;
	}

	// Rock constructor
	public Rock(double x, double semiMajorAxis, double semiMinorAxis) {
		this.x = x;
		this.semiMajorAxis = semiMajorAxis;
		this.semiMinorAxis = semiMinorAxis;
	}

	/* public getter methods */

	public double getX() {
		return x;
	}

	public double getElasticity() {
		return ELASTICITY;
	}

	public double getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public double getSemiMinorAxis() {
		return semiMinorAxis;
	}

	public double getY() {
		return y;
	}

}
