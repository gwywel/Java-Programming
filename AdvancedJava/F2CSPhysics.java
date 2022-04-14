/*
* File: F2CSPhysics.java
* Description: This program updates the velocity of two objects in freefall
* depending on the six arguments inputted by the user: the mass and air
* resistance of each object, the duration of the simulation, and the length of
* a single time step. The program outputs a 2-column table of each object's
* velocity at each time-step, starting at zero velocity.
*/

public class F2CSPhysics {

  // gravitational acceleration in m/s/s
  public static final double G = 9.8;

  public static void main(String[] args) {
    // read in arguments
    double m1 = Double.parseDouble(args[0]); // mass of object 1 (kg)
    double c1 = Double.parseDouble(args[1]); // drag constant of object 1 (kg/s)
    double m2 = Double.parseDouble(args[2]); // mass of object 2 (kg)
    double c2 = Double.parseDouble(args[3]); // drag constant of object 2 (kg/s)
    double stopTime = Double.parseDouble(args[4]); // simulation duration (s)
    double dt = Double.parseDouble(args[5]); // time between steps (s)

    double t = 0.0;
    double v1 = 0.0;
    double v2 = 0.0;
    System.out.println(v1 + "," + v2); // print initial velocities
    while (t <= stopTime) { // determine how many lines to output
      // calculate new velocities
      v1 += (((m1 * G) - (c1 * v1)) * dt) / m1;
      v2 += (((m2 * G) - (c2 * v2)) * dt) / m2;
      System.out.println(v1 + "," + v2); // print new velocities
      t += dt; // increment total time elapsed by step-time
    }
  }
}
