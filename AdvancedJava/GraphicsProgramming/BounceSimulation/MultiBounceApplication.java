/*
* File: MultiBounceApplication.java
* Description: This program sets up the window size and rescales
* the window coordinates so it is easier to determine the location
* of an object on the canvas. Ball and Rock objects are created
* within arrays and their positions on the canvas are determined
* by their position in the array and the length of the array to
* get an even space between all objects of the same type. The
* objects' properties other than the position on the x-axis are
* determined by the Math.random() function. The StdDraw class is
* used to clear, draw, and show these objects in the window.
* This class makes calls to public methods outside its class in
* other class files, in this case Ball and Rock in order to
* update the velocity and position of the objects.
*/

import java.util.ArrayList;

public class MultiBounceApplication {

  /* constants */

  // width and height of window in pixels
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;

  // rescaling of window coordinates
  public static final int X_MIN = -1;
  public static final int X_MAX = 1;
  public static final int Y_MIN = 0;
  public static final int Y_MAX = 2;

  // milliseconds between animation frames
  public static final int PAUSE = 16; // smaller = higher quality

  private static Ball[] balls = new Ball[5];

  private static Rock[] rocks = new Rock[3];

  /* main controls setup, animation, and printing position data */
  public static void main(String[] args) {

    double dx = 2.0 / balls.length;
    double axis = -0.9;

    // Ball objects
    for (int i = 0; i < balls.length; i++) {
      balls[i] = new Ball(axis, Math.random(), Math.random()*0.1);
      axis += dx;
    }

    dx = 2.0 / rocks.length;
    axis = -0.9;

    // Rock objects
    for (int i = 0; i < rocks.length; i++) {
      rocks[i] = new Rock(axis, Math.random()*0.15, Math.random()*0.05);
      axis += dx;
    }

    setup(); // set up canvas
    drawBalls(); // show initial configuration
    drawRocks();

    // animation
    while (true) { // update, draw, pause

      StdDraw.clear();

      for (int i = 0; i < balls.length; i++) {
        balls[i].update();
      }

      for (int i = 0; i < rocks.length; i++) {
        rocks[i].update();
      }

      drawBalls();
      drawRocks();

      StdDraw.pause(PAUSE);

      if (StdDraw.hasNextKeyTyped()) break; // keystroke stops animation
    }
    // exit after keystroke
    System.exit(0);
  }

  /* set up StdDraw canvas and establish coordinate system */
  private static void setup() {
    StdDraw.setCanvasSize(WIDTH, HEIGHT);
    StdDraw.setXscale(X_MIN, X_MAX);
    StdDraw.setYscale(Y_MIN, Y_MAX);
    StdDraw.enableDoubleBuffering();
  }

  /* draw balls at current location */
  public static void drawBalls() {
    for (int i = 0; i < balls.length; i++) {
      StdDraw.filledCircle(balls[i].getX(), balls[i].getY(), balls[i].getRadius());
      StdDraw.show();
    }
  }
  /* draw rocks at current location */
  public static void drawRocks() {
    for (int i = 0; i < rocks.length; i++) {
      StdDraw.filledEllipse(rocks[i].getX(), rocks[i].getY(), rocks[i].getSemiMajorAxis(), rocks[i].getSemiMinorAxis());
      StdDraw.show();
    }
  }

}
