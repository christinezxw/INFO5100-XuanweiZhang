//this file contains Q6
import java.util.*;

public class ReverseStringByWord {
	public String reverseStringByWord(String origin) {
		Stack<String> stack = new Stack<String>();
		String res = new String();
		String[] words = origin.split(" "); 
		for (int i = 0; i < words.length; i ++) {
			stack.push(words[i]);
		}
		for (int i = 0; i < words.length; i ++) {
			res += stack.pop();
			res += " ";
		}
		return res;
	}
	
	
}
