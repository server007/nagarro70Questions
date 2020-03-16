import java.util.*;

public class MaximumCircularSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(maxSum(arr, n));
		}
		sc.close();
	}

	private static int maxSum(int[] arr, int n) {
		
		int maxsum = 0;
		for(int i=0; i<n; i++) {
			int currsum = arr[i];
			int ind  = i+1;
			if(ind >= n) ind =0;
			while(ind != i && ind<n) {
				currsum += arr[ind];
				if(currsum > maxsum) {
					maxsum = currsum;
				}
				if( currsum <=0) {
					currsum = 0;
					break;
				}
				if(ind == n-1) {
					ind = 0;
				}else {
					ind++;
				}

			}
			
		}
		return maxsum;
	}
}
