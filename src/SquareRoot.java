//You are given an integer n. Find the square root of the number.
//Input Format
//An integer T, denoting the number of test cases. Each test case contains an integer N.
//Constraints
//1<=T<=10^5 1<=N<=10^12
//Output Format
//Output a floating point number which is square root of the integer N.
//(Note: Print the answer upto 4 decimal places only).





import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class SquareRoot {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0) {
			double n = sc.nextDouble();
			
			DecimalFormat df = new DecimalFormat("####0.0000");
			df.setRoundingMode(RoundingMode.DOWN);
		
			System.out.println(df.format(Math.sqrt(n)));
			
			t--;
		}
		
		
		sc.close();
	}

}
