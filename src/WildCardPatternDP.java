import java.util.*;

public class WildCardPatternDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String pat = sc.next();
		sc.close();
		if(isMatch(str, pat)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static boolean isMatch(String str, String pat) {
		char [] s = str.toCharArray();
		char [] p = pat.toCharArray();
		
		boolean flag = false;
		int ind = 0;
		
		for(int i=0; i<p.length; i++) {
			
			if(p[i] == '*') {
				if(flag) {
					p[ind++] = p[i];
					flag = false;
				}	
			}else {
					p[ind++] = p[i];
					flag = true;
				}
			
		}
		if(ind == 0) return true;
		
		boolean [][] dp = new boolean [s.length+1][ind+1];
		
		dp[0][0] = true;
		if(ind > 0 && p[0] == '*') {
			dp[0][1] = true;
		}
		
		
		for(int i=1; i<s.length+1; i++) {
			for(int j=1; j<ind+1; j++) {
				if(p[j-1]==s[i-1] || p[j-1] == '?') {
					dp[i][j] = dp[i-1][j-1];
				}
				else if(p[j-1] == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		
		return dp[str.length()][ind];
	}
}



