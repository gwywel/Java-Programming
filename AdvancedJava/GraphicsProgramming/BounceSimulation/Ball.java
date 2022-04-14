/*
* File: Ball.java
* Description: This program stores private instance variables that
* pertain to the Ball object (radius, a drag constant of a sphere,
* the density of the air surrounding the ball, the surface area of
* the ball, its initial velocity, its initial position on the
* y-axis, its position on the x-axis, the elasticity, and the
* gravity constant). The Ball object's position on the canvas is
* updated with a public method that is called from the
* MultiBounceApplication class. The Ball constructor uses
* parameters defined in the MultiBounceApplication class to
* create a variety of Ball objects with different properties that
* are applied and obtained using public getter methods (x,
* elasticity, radius, and y).
*/

public class Ball {

  /* private instance variables */

  // radius of ball, in window coordinate units
  private double radius;

  // air density (kg/m^3)
  private final double AIR_DENSITY = 1.225;

  // drag coefficient of a sphere (unitless)
  private final double DRAG = 0.47;

  // area of the ball
  private double area = 4 * Math.PI * (radius * radius);

  // initial velocity
  private double v = 0.01;

  // position on the y-axis
  private double y = 1.8;

  // position on the x-axis
  private double x;

  // velocity retained on impact
  private double elasticity;

  // gravity, a constant that relates to PAUSE between frames
  private static final double GRAVITY = -0.1*MultiBounceApplication.PAUSE/1000;

  // air resistance of ball
  private double airResistance = ((AIR_DENSITY * DRAG * area) / 2) * (v * v);

  /* public instance methods */

  // update the position and velocity of the ball
  public void update() {
    // if ball is falling off screen, negate velocity
    if (y-radius<0) {
      // rewind to previous frame to avoid another collision next frame
      v -= GRAVITY;
      y -= (v + airResistance);
      // negate velocity
      v *= -elasticity;
    }
    // update position and velocity
    y += v;
    v += GRAVITY;
  }

  // Ball constructor
  public Ball(double x, double elasticity, double radius) {
    this.x = x;
    this.elasticity = elasticity;
    this.radius = radius;
  }

  /* public getter methods */

  public double getX() {
    return x;
  }

  public double getElasticity() {
    return elasticity;
  }

  public double getRadius() {
    return radius;
  }

  public double getY() {
    return y;
  }

}
