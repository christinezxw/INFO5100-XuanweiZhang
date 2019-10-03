package assignment4Q5;

import java.util.ArrayList;
import java.util.List;

public class IDString {

	public static void main(String[] args) {
		String s = "DDI";
		System.out.println(idString(s));
	}
	
	public static List<Integer> idString(String s) {
		if (s.length() < 1 || s.length() > 10000) {
			throw new IllegalArgumentException("String s length unvalid!");
		}
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i <= s.length(); i++) {
			tempList.add(i);
		}
		for (int i = 0; i < s.length(); i++) {			
			switch(s.charAt(i)) {
			case 'I':
				res.add(tempList.get(0));
				tempList.remove(0);
				break;
			case 'D':
				res.add(tempList.get(tempList.size() - 1));
				tempList.remove(tempList.size() - 1);
				break;
			default:
				throw new IllegalArgumentException("String s countains more than I and D!");
			}
		}
		res.add(tempList.get(0));
		return res;
	}

}
