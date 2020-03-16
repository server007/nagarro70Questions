import java.util.*;

public class BitonicSubarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(getAns(arr, n));
		}
	}

	private static long getAns(int[] arr, int n) {
		int [] f = new int[n];
		int[] b = new int[n];
		
		for(int i=0; i<n; i++) {
			f[i]=1;
			b[i]=1;
		}
		for(int i=1; i<n; i++) {
			if(arr[i] >= arr[i-1]) {
				f[i] = f[i-1]+1;
			}
		}
		for(int i=n-2; i>=0; i--) {
			if(arr[i] >= arr[i+1]) {
				b[i] = b[i+1]+1;
			}
		}
		
		long ans = 0;
		
		for(int i=0; i<n; i++) {
			ans = Math.max(ans, f[i]+b[i]-1);
		}
		
		return ans;
	}
}
