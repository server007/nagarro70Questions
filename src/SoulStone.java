import java.util.*;

public class SoulStone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int ans = soul(s);
		System.out.println(ans);
		sc.close();
	}

	private static int soul(String s) {
		int n = s.length();
		int dp [][] = new int[n][n];
		for(int i=1; i<n; i++) {
			if(s.charAt(0) == s.charAt(i)){
				dp[0][i] = 1;
			}
		}
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(s.charAt(i) == s.charAt(j) && dp[i][j] <(j-i))
				{
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		

		return dp[n-2][n-1];
	}
}
