//this file contains Q7
import java.util.*;

public class MatrixInSpiral {
	public int[] spiralOrder(int[][] matrix) {
		List<Integer> resList = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return null;
		}
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		int up = 0;
		int down = rowNum - 1;
		int left = 0;
		int right = colNum - 1;
		while (resList.size() < rowNum * colNum) {
			for (int i = left; i <= right && resList.size() < rowNum * colNum; i ++) {
				resList.add(matrix[up][i]);
			}
			
			for (int i = up + 1; i <= down - 1 && resList.size() < rowNum * colNum; i ++) {
				resList.add(matrix[i][right]);
			}
			
			for (int i = right; i >= left && resList.size() < rowNum * colNum; i --) {
				resList.add(matrix[down][i]);
			}
			
			for (int i = down - 1; i >= up + 1 && resList.size() < rowNum * colNum; i --) {
				resList.add(matrix[i][left]);
			}
			
			up++;
			down--;
			left++;
			right--;
		}
		
		
		int[] res = new int[resList.size()];
		for (int i =0; i < resList.size(); i++) {
			res[i] = resList.get(Integer.valueOf(i));
		}
		return res;
	}
}
