import java.util.*;

public class SimpleEnough {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		sc.close();
		String [] dp = new String[n+1];
		dp[1] = "1";
		dp[2] = "101";
		dp[3] = "111";
		String ans = easy(n, dp);
		int count = 0;
		for(int i=l; i<=r; i++) {
			if(ans.charAt(i-1) == '1') {
				count++;
			}
		}
		System.out.println(count);
	}

	
	private static String easy(int n, String[] dp) {
		if(dp[n] != null) {
			return dp[n];
		}
		else {
			dp[n] = easy((int)n/2, dp) + n%2 + easy((int)n/2, dp);
			return dp[n];
		}
		
	}
}
