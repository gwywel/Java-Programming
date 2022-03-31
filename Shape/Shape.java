public abstract class Shape implements Comparable<Shape>{
  private String name;
  public Shape(String name){
    this.name = name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public abstract double getArea();
  public abstract double getPerimeter();
  public int compareTo(Shape obj){
    double difference = getArea() - obj.getArea();
    if (difference < 0)
    return -1;
    else if (difference == 0)
    return 0;
    else
    return 1;
  }
}
