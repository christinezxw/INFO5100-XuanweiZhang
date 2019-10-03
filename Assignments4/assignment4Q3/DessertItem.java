package assignment4Q3;

public abstract class DessertItem {
	protected String name;

	public DessertItem() {
		super();
	}

	public DessertItem(String name) {
		super();
		if (name.length() > DessertShop.maxNameLength) {
			throw new IllegalArgumentException("Dessert name too long!");
		}
		this.name = name;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public abstract int getCost();
	public abstract String getQuantity();
}
