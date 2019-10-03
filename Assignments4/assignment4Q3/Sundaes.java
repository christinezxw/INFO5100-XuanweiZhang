package assignment4Q3;

public class Sundaes extends IceCream {
	private int cost;
	
	public Sundaes(String name, int cost, String toppingName, int toppingPrice) {
		super();
		this.name = toppingName + " Sundea with\n" + name;
		if (name.length() > DessertShop.maxNameLength) {
			throw new IllegalArgumentException("Dessert name too long!");
		}
		this.cost = cost + toppingPrice;
	}

	public int getCost() {
		return cost;
	}
	
}
