import java.util.*;

public class OptimalGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr [] = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int count = ans(arr, 0, n-1, 0, true);
		System.out.println(count);
	}

	private static int ans(int[] arr, int i, int n, int sum, boolean turn) {
		if( i > n) return sum;
		if(turn) {
			return Math.max(ans(arr, i+1, n, sum+arr[i], false), ans(arr, i, n-1, sum+arr[n], false));
		}
		else {
			return Math.min(ans(arr, i+1, n, sum, true), ans(arr, i, n-1, sum, true));
		}
	}
}
