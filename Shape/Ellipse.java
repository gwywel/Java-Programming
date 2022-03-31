public class Ellipse extends Shape{
  private double semiMajorAxis;
  private double semiMinorAxis;
  public Ellipse(String name, double semiMajorAxis, double semiMinorAxis){
    super(name);
    this.semiMajorAxis = semiMajorAxis;
    this.semiMinorAxis = semiMinorAxis;
  }
  public Ellipse(double semiMajorAxis, double semiMinorAxis){
    this("Ellipse", semiMajorAxis, semiMinorAxis);
  }
  public double getArea(){
    return Math.PI * semiMajorAxis * semiMinorAxis;
  }
  public String toString(){
    return "Ellipse semi major axis: " + semiMajorAxis
    + "\nEllipse semi minor axis: " + semiMinorAxis
    + "\nEllipse perimeter: " + getPerimeter();
  }
  public double getPerimeter(){
    return 2 * Math.PI * Math.sqrt((Math.pow(semiMajorAxis,2)
    + Math.pow(semiMinorAxis,2)) / 2);
  }
}
