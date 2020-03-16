import java.util.*;


public class LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a1 = sc.nextLine();
		String a2 = sc.nextLine();
		sc.close();
		
		int n1 = a1.length();
		int n2 = a2.length();
		
		int [][] dp = new int[n1+1][n2+1];
		
		for(int i = 0; i<=n1; i++) {
			for( int j = 0; j<=n2; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
					}else if(a1.charAt(i-1) == a2.charAt(j-1)) {
						dp[i][j] = 1+ dp[i-1][j-1];
					}else 
					{
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
			}
		}
		int num = dp[n1][n2];
		char ans[] = new char[num];
		while(n1 > 0 && n2 >0) {
			if(a1.charAt(n1-1) == a2.charAt(n2-1)) {
				ans[num-1] = a1.charAt(n1-1);
				num--;
				n1--;
				n2--;
			}else if(dp[n1-1][n2] > dp[n1][n2-1]){
				n1--;
			} else {
				n2--;
			}
			}
		System.out.println(ans);
	}
}
