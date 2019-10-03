package assignment4Q2;

public class Happy extends Moody {

	@Override
	protected String getMood() {
		return getClass().getSimpleName();
	}

	@Override
	protected void expressFeelings() {
		System.out.println("\nhehehe...hahahah...HAHAHAHAHA!!!");
	}
	
	public String toString() {
		return "Subject laughs a lot\n";
	}

}
