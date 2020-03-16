import java.util.*;

public class NextGreater {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t > 0) {
			int n = scn.nextInt();
			long[] arr = new long[n];
			int[] ans = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextLong();
				ans[i] = -1;
				}
			nextLarger(arr, n, ans);
			t--;
		}
		scn.close();

	}

	public static void nextLarger(long[] arr, int n, int[] ans) {
		for(int i = n-2; i>=0; i--) {
			int j = i+1;
			while(j != -1 && arr[j] <= arr[i]) {
				j = ans[j];
			}
			ans[i] = j;
		}
		for(int i = 0; i<n; i++) {
			if(ans[i] != -1) System.out.println(arr[i]+","+arr[ans[i]]);
			else System.out.println(arr[i] + "," +-1);
		}
	}
}