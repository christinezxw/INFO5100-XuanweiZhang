package assignment4Q1;

public class Shape {
	protected String name;
	protected double perimeter;
	protected double area;

	public Shape() {
		super();
	}
	
	public void draw() {
		System.out.println("Drawing " + getClass().getSimpleName());
	}

	public void getArea() {
		System.out.println(String.format("%.2f", area));
	}

	public void getPerimeter() {
		System.out.println(String.format("%.2f", perimeter));
	}

}
