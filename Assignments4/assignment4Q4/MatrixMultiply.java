package assignment4Q4;

public class MatrixMultiply {

	public static void main(String[] args) {
		int[][] A = {{1,0,0},{-1,0,3}};
		int[][] B = {{7,0,0},{0,0,0},{0,0,1}};
		int[][] res = martrixMultiply(A, B);
		System.out.print("AB =\n");
		for (int i = 0; i < A.length; i++) {
			System.out.print("|");
			for (int j = 0; j < A[0].length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.print("|\n");
		}
		System.out.print("*\n");
		for (int i = 0; i < B.length; i++) {
			System.out.print("|");
			for (int j = 0; j < B[0].length; j++) {
				System.out.print(B[i][j] + " ");
			}
			System.out.print("|\n");
		}
		System.out.print("=\n");
		for (int i = 0; i < res.length; i++) {
			System.out.print("|");
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.print("|\n");
		}
		
	}
	
	public static int[][] martrixMultiply(int[][] A, int[][] B) {
		if (A[0].length != B.length) {
			throw new IllegalArgumentException("A B in unmatch size!");
		}

		int[][] res = new int[A.length][B[0].length];
		int sum = 0;
		for(int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				sum = 0;
				for (int n = 0; n < B.length; n++) {
					sum += A[i][n] * B[n][j];
				}
				res[i][j] = sum;
			}

		}
		return res;
	}

}
