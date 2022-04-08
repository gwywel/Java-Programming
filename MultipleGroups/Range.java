public class Range implements NumberGroup
{
	//add instance variable
	private int min;
	private int max;
	//add a constructor
	public Range(int min, int max){
		this.min = min;
		this.max = max;
	}
	//add a contains method
	public boolean contains(int x){
		return min <= x && x <= max;
	}
	//add a toString method
	public String toString(){
		return "The range is " + (max - min);
	}
}
