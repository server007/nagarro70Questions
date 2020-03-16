import java.util.*;

public class LongestPalindromicSubstring {
	
	private static int expandHere(String s, int left, int right) {
		if(s == null || left > right) return 0;
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right-left-1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0) {
			String s = sc.next();
			if(s==null || s.length() < 1) {
				System.out.println("");
				continue;
			}
			int start = 0;
			int end = 0;
			
			
			for(int i=0; i<s.length(); i++) {
				int len1 = expandHere(s, i, i);
				int len2 = expandHere(s, i, i+1);
				
				int len = Math.max(len1, len2);
				if(len > end-start) {
					start = i - ((len-1)/2);
					end = i+(len/2);
				}
			}
			if(end+1-start == s.length()) {
				System.out.println(s.substring(start+1, end));
			}else {
				System.out.println(s.substring(start, end+1));
				}
			t--;
		}
		sc.close();	
	}
}
