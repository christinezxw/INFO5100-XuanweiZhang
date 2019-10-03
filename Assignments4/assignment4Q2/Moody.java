package assignment4Q2;

public abstract class Moody {
	protected abstract String getMood();
	protected abstract void expressFeelings();
	public void queryMood() {
		System.out.println("I feel " + this.getMood().toLowerCase() + " today!");
	}
}
