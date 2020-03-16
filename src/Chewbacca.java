import java.util.*;

public class Chewbacca {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		String ans = "";
		boolean flag = true;
		for(int i = 0 ; i < s.length(); i++) {
			int y = s.charAt(i) - '0';
			if(y==9 && flag) {
				ans = ans+y;
				flag = false;
				continue;
			}
			else if(y > 4) {
				y = 9 - y;
			}
			if(y != 0) flag = false;
			if(flag) continue;
			ans = ans + y;

		}
		if(ans =="") System.out.println(0);
		else {
		System.out.println(ans);}
		input.close();
	}
}
