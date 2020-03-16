import java.util.*;


//
//A set of parenthesis are duplicate if same 
//sub expression is surrounded by multiple parenthesis.
//In the given sample input, 
//((a+b)+((c+d))), the subexpression 
//"c+d" is surrounded by two pairs of brackets


public class CheckDuplicateParenthesis {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		sc.close();
		int lf = 0;
		int rf = 0;
		boolean ans = false;
		
		for(int i = 0; i<x.length(); i++) {
			
			if(x.charAt(i) == '(') {
				if( rf == 1) {
					rf = 0;
					lf = 0;
				}
				lf++;
				}
			
			else if(x.charAt(i) == ')') { 
				if( lf == 1) {
					lf = 0;
					rf = 0;
				}
				rf++;
				}
			else {
				if(lf == 1 || rf == 1) {
					lf = 0;
					rf = 0;
				}
			}
			if(lf > 1 && rf > 1) {
				ans = true;
				break;
			}
			
			
		}
		System.out.println(ans);	
	}
}
