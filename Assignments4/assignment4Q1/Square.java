package assignment4Q1;

public class Square extends Shape{
	private double side;

	public Square(double side) {
		super();
		this.side = side;
	}

	@Override
	public void getArea() {
		this.area = side * side;
		super.getArea();
	}

	@Override
	public void getPerimeter() {
		perimeter = 4 * side;
		super.getPerimeter();		
	}
}
