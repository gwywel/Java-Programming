/*
* File: Molecule.java
* Description: This program contains private instance variables used in the
* constructors of molecule objects. Both regular molecules and greenhouse
* gases are constructed using calls from the Atmosphere class. Greenhouse
* gases have the same properties as regular molecules with the addition of
* absorbProbability and photonVelocity, which control the chance a greenhouse
* gas will absorb a photon and the degree to which its velocity is increased
* respectively. The updatePosition() method detects collisions with walls and
* calculates the resulting position, as well as new properties of greenhouse
* gases after each frame. Collisions between molecules are handled by the
* handleParticleCollisions() method, which calculates the velocity resulting
* from an elastic collision. To prevent bugs, this method also 'rewinds' and
* 'un-rewinds' time before and after collisions, so one molecule cannot become
* stuck inside another. A public getter method getSpeed() returns the speed of
* the molecule invoking the method, which is used in updating histogram counts
* in Atmosphere.java.
*/

public class Molecule {

	// private instance variables
	private double x = 0;
	private double y = 0;
	private final double M;
	private final double R;
	private final boolean GG;

	// ivar initializations to constructors
	private double xv;
	private double yv;
	private double absorbProbability;
	private double photonVelocity;

	/* define constructors and public instance methods */

	// construct regular molecule
	public Molecule(double x, double y, double radius, double mass, double xv,
	double yv) {
		this.x = x;
		this.y = y;
		this.R = radius;
		this.M = mass;
		this.xv = xv;
		this.yv = yv;
		GG = false;
	}

	// construct greenhouse gas
	public Molecule(double x, double y, double radius, double mass, double xv,
	double yv, double absorbProbability, double photonVelocity) {
		this.x = x;
		this.y = y;
		this.R = radius;
		this.M = mass;
		this.xv = xv;
		this.yv = yv;
		this.absorbProbability = absorbProbability;
		this.photonVelocity = photonVelocity;
		GG = true;
	}

	// updates position based on contact with the window borders; updates greenhouse gas properties
	public void updatePosition() {
		y += yv;
		x += xv;
		if (y+R > 1 || y-R < 0) {
			if (y+R > 1) {
				y -= ((y + R) - 1) * 2;
			}
			if (y-R < 0) {
				y += -1 * (y - R) * 2;
			}
			yv = -yv;
		}
		if (x+R > 1 || x-R < 0) {
			if (x-R < 0) {
				x += -1 * (x - R) * 2;
			}
			if (x+R > 1) {
				x -= ((x + R) - 1) * 2;
			}
			xv = -xv;
		}
		if (GG) {
			if (Math.random() <= absorbProbability) {
				xv *= photonVelocity;
				yv *= photonVelocity;
			}
		}
	}

	// detects collisions between particles and calculates resulting velocities
	public void handleParticleCollisions(Molecule[] allMolecules) {
		for (int i = 0; i < allMolecules.length; i++) {

			// if this molecule is not the one we are looking at
			if (this != allMolecules[i]) {

				// calculate distance between molecules
				double dist = Math.sqrt((allMolecules[i].x - this.x) *
				(allMolecules[i].x - this.x) + (allMolecules[i].y - this.y) *
				(allMolecules[i].y - this.y));

				// if the distance between molecules is less than the sum of their radii
				if (dist < (this.R + allMolecules[i].R)) {

					// calculate time to rewind collision
					double time = (this.R + allMolecules[i].R - dist) / (this.getSpeed()
					+ allMolecules[i].getSpeed());

					this.x -= time * this.xv;
					this.y -= time * this.yv;
					allMolecules[i].x -= time * allMolecules[i].xv;
					allMolecules[i].y -= time * allMolecules[i].yv;

					double dotProduct = ((this.xv - allMolecules[i].xv) *
					(this.x - allMolecules[i].x) + (this.yv - allMolecules[i].yv) *
					(this.y - allMolecules[i].y)) / ((this.x - allMolecules[i].x) *
					(this.x - allMolecules[i].x) + (this.y - allMolecules[i].y) *
					(this.y - allMolecules[i].y));

					// calculate elastic collision
					double xvNew1 = this.xv - (2 * allMolecules[i].M) /
					(this.M + allMolecules[i].M) * dotProduct * (this.x - allMolecules[i].x);
					double yvNew1 = this.yv - (2 * allMolecules[i].M) /
					(this.M + allMolecules[i].M) * dotProduct * (this.y - allMolecules[i].y);
					double xvNew2 = allMolecules[i].xv - (2 * this.M) /
					(this.M + allMolecules[i].M) * dotProduct * (allMolecules[i].x - this.x);
					double yvNew2 = allMolecules[i].yv - (2 * this.M) /
					(this.M + allMolecules[i].M) * dotProduct * (allMolecules[i].y - this.y);

					this.xv = xvNew1;
					this.yv = yvNew1;
					allMolecules[i].xv = xvNew2;
					allMolecules[i].yv = yvNew2;

					// un-rewind time to collision and update
					this.x += time * this.xv;
					this.y += time * this.yv;
					allMolecules[i].x += time * allMolecules[i].xv;
					allMolecules[i].y += time * allMolecules[i].yv;
				}
			}
		}
	}

	// returns the current speed of the molecule
	public double getSpeed() {
		return Math.sqrt((xv * xv) + (yv * yv));
	}

	// draws molecule as circle on canvas
	public void draw() {
		StdDraw.setPenColor(GG ? StdDraw.RED : StdDraw.BLUE);
		StdDraw.filledCircle(x,y,R);
	}

}
