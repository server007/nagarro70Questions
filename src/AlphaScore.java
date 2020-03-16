import java.util.*;

//You are climbing up using stairs where a number is written on each stair.
//At each step we define the alpha score as sum of all the numbers 
//previously seen on the stairs which are smaller than the present number.
//Alpha score of the whole journey is defined as the sum of all the alpha 
//scores at each step. Print the alpha score of whole journey modulus 1000000007




public class AlphaScore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long [] arr = new long [n];
		for(int i =0; i< n; i++) {
			arr[i] = sc.nextLong();
		}
		sc.close();
		System.out.println(alphaScore(arr, n));
		
	}

	private static int alphaScore(long[] arr, int n) {
		
		return 0;
	}
}
