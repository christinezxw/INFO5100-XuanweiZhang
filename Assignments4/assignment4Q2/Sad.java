package assignment4Q2;

public class Sad extends Moody {

	@Override
	protected String getMood() {
		return getClass().getSimpleName();
	}

	@Override
	protected void expressFeelings() {
		System.out.println("\n'wah' 'boo hoo' 'weep' 'sob' 'weep'");
	}
	
	public String toString() {
		return "Subject cries a lot\n";
	}

}
