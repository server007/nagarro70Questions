//Given a text 'str' and a wildcard pattern 'pattern',
//The wildcard pattern can include the characters ‘?’ and ‘ * ’. 
//‘?’ – matches any single character 
//‘*’ – Matches any sequence of characters (including the empty sequence) 
//Find out if the given text matches the pattern.

import java.util.*;

public class WildcardPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String pat = sc.next();
		sc.close();
		System.out.println(matches(str, pat));
	}

	private static int matches(String str, String pat) {
		System.out.println(str + " " + pat);
		if(pat.isEmpty() && str.isEmpty() == false) {
			return 0;
			}
		if(str.isEmpty() && pat.isEmpty() == false) {
			for(int i = 0; i<pat.length(); i++) {
				if(pat.charAt(i) != '*') return 0;
			}
			return 1;
		}
	    if(str.isEmpty() && pat.isEmpty()) {
//	    	System.out.println("here");
	    	return 1;
	    }
		else if(pat.charAt(0) == '?') {
			return matches(str.substring(1), pat.substring(1));
		}
		else if(pat.charAt(0) == '*') {
			if(pat.length() > str.length()) {
				return matches(str, pat.substring(1));
			}
			else if(pat.length() == str.length()) {
//				if(pat.charAt(1) == str.charAt(0)) return matches(str.substring(1), pat.substring(1));
				return matches(str.substring(1), pat.substring(1));
			}
			else {
				int patlen = pat.length();
				int strlen = str.length();
				int i = 0;
				while(strlen - i > patlen) {
					i++;
				}
				return matches(str.substring(i), pat);
			}		
		}
		else {
			if(str.charAt(0) == pat.charAt(0)) {
				return matches(str.substring(1), pat.substring(1));
			} else {
				return 0;
			}
			
		}
	}
}
