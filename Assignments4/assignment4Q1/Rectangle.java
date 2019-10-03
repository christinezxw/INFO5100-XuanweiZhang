package assignment4Q1;

public class Rectangle extends Shape{
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void getArea() {
		this.area = width * height;
		super.getArea();
	}

	@Override
	public void getPerimeter() {
		perimeter = 2 * (width + height);
		super.getPerimeter();		
	}
}
