package assignment4Q1;

public class Circle extends Shape{
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	@Override
	public void getArea() {
		this.area = 3.1415 * radius * radius;
		super.getArea();
	}

	@Override
	public void getPerimeter() {
		perimeter = 2 * 3.1415 * radius;
		super.getPerimeter();		
	}
	
}
