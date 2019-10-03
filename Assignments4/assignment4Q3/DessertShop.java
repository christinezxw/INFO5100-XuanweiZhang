package assignment4Q3;

public class DessertShop {
	static double taxRate = 0.065;
	static String name = "M & M Dessert Shop";
	static int maxNameLength = 50;
	
	public static String cents2dollarsAndCentsmethod(int cents) {
		return String.format("%.2f", cents / 100.0);
	}
	
	
}
