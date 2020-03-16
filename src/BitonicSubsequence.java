import java.util.*;

public class BitonicSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(longestS(arr, n));
		}
		sc.close();
	}

	private static int longestS(int[] arr, int n) {
		int front[] = new int[n];
		int last[] = new int[n];
		for(int i=0; i<n; i++) {
			front[i] = 1;
			last[i] = 1;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					front[i] = Math.max(front[i], front[j]+1);
				}
			}
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=n-1; j>i; j--) {
				if(arr[i] > arr[j]) {
					last[i] = Math.max(last[i], last[j]+1);
				}
			}
		}
		
		int maxans = 0;
		
		for(int i=0; i<n; i++) {
			maxans = Math.max(maxans, front[i]+last[i]-1);
		}
		
		
		return maxans;
	}
}
