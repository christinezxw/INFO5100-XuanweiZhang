package assignment4Q3;

import java.util.*;

public class Checkout {
	private Vector<DessertItem> dessertItemsList = new Vector<DessertItem>();
	
	public Checkout() {
		
	}
	
	public int numberOfItems() {
		return dessertItemsList.size();
	}
	
	public void enterItem(DessertItem item) {
		this.dessertItemsList.add(item);
	}
	
	public void clear() {
		this.dessertItemsList.clear();
	}
	
	public int totalCost() {
		int total = 0;
		for (DessertItem item : dessertItemsList) {
			total += item.getCost();
		}
		return total;//in cents
	}
	
	public int totalTax() {
		return (int) Math.round(totalCost() * DessertShop.taxRate);//in cents
	}
	
	@Override
	public String toString() {
		String res = "	"+DessertShop.name + "\n	------------------\n\n";
		for (DessertItem item : dessertItemsList) {
			res += item.getQuantity() + item.getName() + "		" + DessertShop.cents2dollarsAndCentsmethod(item.getCost()) + "\n";
		}
		res += "Tax			" + DessertShop.cents2dollarsAndCentsmethod(totalTax()) + "\nTotal Cost			" + DessertShop.cents2dollarsAndCentsmethod(totalCost() + totalTax());
		return res;
	}
}
