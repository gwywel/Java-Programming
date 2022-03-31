import java.util.ArrayList;
public class ShapeTester{
  public static void main(String[]args){
    Ellipse ellipse = new Ellipse("Ellipse", 2.5, 3.0);
    System.out.println(ellipse);

    Rectangle rectangle = new Rectangle("Rectangle", 1.0, 8.0);
    System.out.println(rectangle);

    Circle circle = new Circle(4.5);
    System.out.println(circle);

    Square square = new Square(2.0);
    System.out.println(square);

    Rectangle rectangle2 = new Rectangle("Rectangle 2", 2.0, 4.0);

    ArrayList<Shape> list = new ArrayList<Shape>();
    list.add(square);
    list.add(circle);
    list.add(rectangle);
    list.add(ellipse);

    for (Shape s : list)
    System.out.println("Name: " + s.getName() + "\nArea: " + s.getArea());
  }
}
