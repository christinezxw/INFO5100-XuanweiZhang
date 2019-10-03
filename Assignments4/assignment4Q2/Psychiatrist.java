package assignment4Q2;

public class Psychiatrist {
	public void examine(Moody moodyObject) {
		System.out.println("How are you feeling today?");
		moodyObject.queryMood();
	}
	public void observe(Moody moodyObject) {
		moodyObject.expressFeelings();
		System.out.println("Observation: " + moodyObject.toString());
	}
}
