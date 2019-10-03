package assignment4Q3;

public class Candy extends DessertItem {
	private double weight;//pound
	private int price;//per pound
	@Override
	public int getCost() {
		return (int)Math.round(weight * price);
	}

	public Candy(String name,double weight, int price) {
		super(name);
		this.weight = weight;
		this.price = price;
	}

	@Override
	public String getQuantity() {
		return Double.toString(weight) + " lbs. @ " + DessertShop.cents2dollarsAndCentsmethod(price) + "/lb.\n";
	}
}
