package assignment4Q3;

public class IceCream extends DessertItem {
	private int cost;
	@Override
	public int getCost() {
		return cost;
	}
	public IceCream() {
		
	}
	public IceCream(String name, int cost) {
		super(name);
		this.cost = cost;
	}
	@Override
	public String getQuantity() {
		return "";
	}

}
