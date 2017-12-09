package matrixReshape566;

/*
 * How to maintain row-traversal order when
 * reshape rows are smaller than preRows:
 * 	
 */
public class Solution {
	
	public static int[][] matrixReshape(int[][] matrixPre, int rows, int cols) {
		int preRows = matrixPre.length;
		int preCols = matrixPre[0].length;
		int[][] reshaped = new int[rows][cols];
	
		if (preRows * preCols != rows * cols) {
			System.out.println("A " + preRows + " by " + preCols + " matrix cannot be reshaped as a " + rows + " by " + cols + " matrix.");
			return matrixPre;
		} else {
			
			for (int i = 0; i < rows * cols; i++) {
				reshaped[i / cols][i % cols] = matrixPre[i / preCols][i % preCols];
			}
			
		}
		return reshaped;
		
	}
	
	public static void printNice(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		System.out.print("{");
		
		for (int i = 0; i < rows; i++) {
			System.out.print("{");
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			if (i != rows - 1) {
				System.out.println("}");
			} else {
				System.out.print("}");
			}
		}
		System.out.println("}");
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4},
						  {5, 6, 7, 8}};
		
		int[][] reshaped = matrixReshape(matrix, 8, 1);
		
		
		printNice(matrix);
		System.out.println();
		printNice(reshaped);
	}
}
