import java.util.*;

//You are provided an integers N. You need to count
//all possible distinct binary strings of length N
//such that there are no consecutive 1’s.



public class BinaryString {
	
	static int countStrings(int n) {
		//end 0
		int a [] = new int[n];
		//end 1
		int b [] = new int[n];
		
		a[0] = b[0] = 1;
		for(int i = 1; i< n; i++) {
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}
		
		return a[n-1]+b[n-1];
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            System.out.println(countStrings(n));
            t--;
        }
        sc.close();
	}
}
