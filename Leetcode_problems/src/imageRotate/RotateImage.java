package imageRotate;

public class RotateImage {
	public static void rotateImage(int[][] image) {
		int temp = 0;
		int len = image.length;
		int halfLen = len / 2;
		int last = len - 1;
		
		//flip top to bottom
		for (int i = 0; i < halfLen; i++) {
			for (int j = 0; j < len; j++) {
				temp = image[i][j];
				image[i][j] = image[last][j];
				image[last][j] = temp;
			}
			last--;
		}
		
		//flip across diagonal
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] image = {{1, 2, 3, 4, 20}, 
						 {5, 6, 7, 8, 19}, 
						 {9, 34, 11, 12, 3},
						 {13, 14, 15, 16, 4},
						 {83, 72, 54, 56, 90}};
		int len = image.length;
		
		for (int i = 0; i < len; i++) {
			System.out.println();
			for (int j = 0; j < len; j++) {
				System.out.print(image[i][j] + " ");
			}
		}
		
		rotateImage(image);
		
		System.out.print("\n     ⬇️");
		
		for (int i = 0; i < len; i++) {
			System.out.println();
			for (int j = 0; j < len; j++) {
				System.out.print(image[i][j] + " ");
			}
		}
		
	}
}
