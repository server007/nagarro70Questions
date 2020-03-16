import java.util.*;

//Print the answer for each testcase in a new line. 
//If the sum of any of the subset is zero,
//then print “Yes” (without quotes) else print “No”(without quotes).


public class SubsetSumEasy {
	
	private static boolean subSet(int[] arr, int n, int sum, boolean check) {
		if(n <= 0) return false;
		if((check==true && sum==0) || sum+arr[0]==0 || arr[n-1]==0) return true;
		return (subSet(arr, n-1, sum+arr[n-1], true) || subSet(arr, n-1, sum, check));

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	
		while(t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			if(subSet(arr, n, 0, false)) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		
		sc.close();	
	}

}
