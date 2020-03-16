import java.util.*;

//Take as input str, a string. Assume that
//value of a=1, b=2, c=3, d=4, …. z=26. 
//Write a recursive function 
//(return type Arraylist) to print all 
//possible codes for the string.
//E.g. for “1123” possible codes are 
//aabc, kbc, alc, aaw, kw

public class RecursionCodesOfString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		sc.close();
		ArrayList<String> ans = codesOfString("", x);
		System.out.println(ans.toString());
		
	}
	

	private static ArrayList<String> codesOfString(String prefix, String x) {
		ArrayList<String> ans = new ArrayList<String>();
		if(x.length() == 0) {
			ans.add(prefix);
			return ans;
		}
		if(x.charAt(0) == '0') return ans;
		ans.addAll(codesOfString(prefix + (char)(x.charAt(0) - '1' + 'a'),
				x.substring(1)));
		if(x.length() >=2 && x.charAt(0) == '1') {
			ans.addAll(codesOfString(prefix + (char)(10 + x.charAt(1) - '1' + 'a'),
					x.substring(2)));
		}
		if(x.length() >=2 && x.charAt(0) == '2') {
			ans.addAll(codesOfString(prefix + (char)(20 + x.charAt(1) - '1' + 'a'),
					x.substring(2)));
		}
		
		return ans;
	}


}
