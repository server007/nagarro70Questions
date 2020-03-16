import java.util.*;
public class GrandTemple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x [] = new int [n];
		int y [] = new int[n];
		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(maxArea(x, y, n));
	}

	private static long maxArea(int[] x, int[] y, int n) {
		Arrays.sort(x);
		Arrays.sort(y);
		
		long maxx = 0;
		long maxy = 0;
		
		for(int i=0; i<n-1; i++) {
			if(x[i+1]-x[i] > maxx) {
				maxx = x[i+1]-x[i];
			}
		}
		for(int i=0; i<n-1; i++) {
			if(y[i+1]-y[i] > maxy) {
				maxy = y[i+1]-y[i];
			}
		}
		maxx--;
		maxy--;
		long ans = maxx*maxy;
		return ans;
	}
}
