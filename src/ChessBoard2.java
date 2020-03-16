import java.util.Scanner;

public class ChessBoard2 {
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		boolean[] arr = prime(n);
		printPaths(0,0,n-1, "", arr, false);
		System.out.println();
		System.out.println(ChessBoard1.count);
	}

	private static void printPaths(int i, int j, int n, String s, boolean[] arr, boolean flag) {
		if(i>n || j>n) return;
		if(i==n && j==n) {
			ChessBoard1.count++;
			System.out.print("{0-0}"+s+" ");
			return;
		}
		
		if(arr[i] || arr[j]) {
			
		}
		
		
		printPaths(i+2, j+1, n, s+"K"+ "{"+ (int)(i+2)+"-"+(int)(j+1)+"}", arr, flag);
		printPaths(i+1, j+2, n, s+"K"+ "{"+ (int)(i+1)+"-"+(int)(j+2)+"}", arr, flag);
		
		
		if(i==n || i==0 || j==0 || j==n) {
			
			for(int m=1; m+j<=n; m++) {
				printPaths(i, j+m, n, s+"R"+ "{"+ i+"-"+(int)(j+m)+"}", arr);
			}	
			for(int m=1; m+i<=n; m++) {
				printPaths(i+m, j, n, s+"R"+ "{"+ (int)(i+m)+"-"+j+"}", arr);
			}
			
		}
		
		if(i == j) {
			for(int m= 1; i+m<=n; m++) {
				printPaths(i+m, j+m, n, s+"B"+ "{"+ (int)(i+m)+"-"+(int)(j+m)+"}", arr);
				
			}
			
		}
		
	}
	public static boolean [] prime(int n){
		boolean[] arr = new boolean[n+1];
		 for(int i=2;i<n;i++) 
	            arr[i] = true; 
	          
	        for(int p = 2; p*p <=n; p++) 
	        { 
	            if(arr[p] == true) 
	            { 
	                for(int i = p*p; i <= n; i += p) 
	                    arr[i] = false; 
	            } 
	        } 
		return arr;
	}
	
}
