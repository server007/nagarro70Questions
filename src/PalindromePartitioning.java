import java.util.*;

public class PalindromePartitioning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String s = sc.next();
			int ans = getMin(s);
			System.out.println(ans);
		}
		sc.close();
	}

	private static int getMin(String s) {
		int n = s.length();
		if(n==0) return 0;
		boolean [][] dp = new boolean[n][n];
		
		int [] ans = new int[n];
		
		for(int i=1; i<n; i++) {
			int res = i;
			for(int j=0; j<i+1; j++) {
				if(s.charAt(i) == s.charAt(j) && (i < j+2 || dp[i-1][j+1])) {
					dp[i][j] = true;
					int temp = 0;
					if(j!=0) temp = 1+ans[j-1];
					res = Math.min(res, temp);
				}
			}
			ans[i] = res;
		}
		return ans[n-1];
		
	}
}
