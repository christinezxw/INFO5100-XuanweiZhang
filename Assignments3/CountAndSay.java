//this file contains Q5
public class CountAndSay {
	public String countAndSay(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n should be equal to or greater than 1!");
		}else {
			StringBuilder res = new StringBuilder();
			StringBuilder temp;
			res.append(1);
			int cnt;
			char compare;
			int len;
			for (int i = 1; i < n; i ++) {
				temp = res;
				len = res.length();
				res = new StringBuilder();
				cnt = 1;
				compare = temp.charAt(0);
				for (int j = 1; j < len; j++) {
					if (temp.charAt(j) != compare) {
						res.append(cnt).append(compare);
						cnt = 1;
						compare = temp.charAt(j);
					}else {
						cnt ++;
					}
				}
				res.append(cnt).append(compare);
			}
			return res.toString();
		}
	}
	
}
