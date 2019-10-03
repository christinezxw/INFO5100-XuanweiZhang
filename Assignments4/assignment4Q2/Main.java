package assignment4Q2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Psychiatrist psychiatrist = new Psychiatrist();
		Moody sad = new Sad();
		Moody happy = new Happy();
		psychiatrist.examine(happy);
		psychiatrist.observe(happy);
		psychiatrist.examine(sad);
		psychiatrist.observe(sad);
	}

}
