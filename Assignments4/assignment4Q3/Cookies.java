package assignment4Q3;

public class Cookies extends DessertItem {
	private int number;
	private int price;//per dozen
	@Override
	public int getCost() {
		return (int) Math.round(number * price / 12);
	}

	public Cookies(String name, int number, int price) {
		super(name);
		this.number = number;
		this.price = price;
	}

	@Override
	public String getQuantity() {
		return Integer.toString(number) + " @ " + DessertShop.cents2dollarsAndCentsmethod(price) + "/dz.\n";
	}
	
}
