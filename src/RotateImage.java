import java.util.*;

//Given a 2D array of size N x N. 
//Rotate the array 90 degrees anti-clockwise. 


public class RotateImage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		
		for(int i =0; i< n; i++) {
			for(int j = 0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		int iter = n/2;
		for(int mat = 0; mat < iter; mat++) {
			for(int col = mat; col < n-1-mat; col++) {
				int tl = matrix[mat][col];
				int bl = matrix[n-1-col][mat];
				int tr = matrix[col][n-1-mat];
				int br = matrix[n-1-mat][n-1-col];
				
	
				matrix[mat][col] = tr;
				matrix[n-1-col][mat] = tl;
				matrix[col][n-1-mat] = br;
				matrix[n-1-mat][n-1-col] = bl;
				
			}
		}
		for(int i =0; i< n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}	
		
	}
}
