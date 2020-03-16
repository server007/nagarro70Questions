import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class ValentineMagic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [] boys = new int[n];
		int [] girls = new int[m];
		
		for(int i = 0; i<n; i++) {
			boys[i] = sc.nextInt();
		}
		for(int i = 0; i<m; i++) {
			girls[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(boys);
		Arrays.sort(girls);
		
		int [][] arr = new int[n][m];
		
		for(int i=0; i<m; i++) {
			arr[n-1][i] = Math.abs(boys[n-1] - girls[i]);
		}
		
		int prevmin = Integer.MAX_VALUE;
		for(int i=n-1; i<m; i++) {
			prevmin = Math.min(prevmin, arr[n-1][i]);
		}
		System.out.println(prevmin);
		int c=1;
		
		for(int i= n-2; i>=0; i--) {
			int currmin = Integer.MAX_VALUE;
			c++;
			
			
			for(int j=m-c; j>=i; j--) {
//				System.out.println("I " + i + " J " + j);
				arr[i][j] = prevmin + Math.abs(boys[i]-girls[j]);
				currmin = Math.min(currmin, Math.abs(boys[i]-girls[j]));
			}
			prevmin = currmin;
			System.out.println("cur "+currmin + "for i" + i);
		}
		
//		int ans = Integer.MAX_VALUE;
//		for(int i=0; i<m-n; i++) {
//			ans = Math.min(ans, arr[0][i]);
//		}
		System.out.println(prevmin);
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + "     ");
			}
			System.out.println();
		}
				
	
	}
}

//3 5
//1 2 5
//8 100 7 61 32



//3 5
//7 32 100
//7 8 32 61 100
