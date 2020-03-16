import java.util.*;

public class MinimumJumps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(minJumps(arr, n, 0, 0));
		
	}

	private static int minJumps(int[] arr, int n, int jumps, int initial) {
		if(initial >= n) {
			return jumps;
		
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i <= arr[initial]; i++) {
			ans = Math.min(ans, minJumps(arr, n, jumps+1, initial+i));
		}
		

		
		return ans;
	}
}
