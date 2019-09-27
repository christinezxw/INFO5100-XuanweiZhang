//this file contains Q8
public class PAYPALISHIRING {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		
		StringBuilder res = new StringBuilder();
		int n = s.length();
		int groupLen = 2 * numRows - 2;
		
		for (int i = 0; i < numRows; i++) {
		    for (int j = 0; j + i < n; j += groupLen) {
		    	res.append(s.charAt(i + j));
		    	if (i != 0 && i != numRows - 1 && j + groupLen - i < n) {
		    		res.append(s.charAt(j + groupLen - i));
		    	}
		    }
		}
		
		return res.toString();
	}
}
