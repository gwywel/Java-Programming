public class Rectangle extends Shape{
  private double width;
  private double height;
  public Rectangle(String name, double width, double height){
    super(name);
    this.width = width;
    this.height = height;
  }
  public Rectangle(double width, double height){
    this("Rectangle", width, height);
  }
  public double getArea(){
    double area = width * height;
    return area;
  }
  public double getHeight(){
    return height;
  }
  public double getWidth(){
    return width;
  }
  public String toString(){
    return "Rectangle width: " + width + "\nRectangle height: " + height
    + "\nRectangle perimeter: " + getPerimeter();
  }
  public double getPerimeter(){
    return width + width + height + height;
  }
}
