import java.util.Map;
import java.util.*;
import java.util.HashMap;

class ZerosOnes
{
	public static void maxLenSubarray(int[] arr)
	{
		
		Map<Integer, Integer> di = new HashMap<>();
		
		int ml = 0;
		int ei = -1;
		int sum = 0;
		di.put(0, -1);
		
		for (int i = 0; i < arr.length; i++)
		{
			
			sum += (arr[i] == 0)? -1: 1;

		
			if (di.containsKey(sum))
			{
				
				if (ml < i - di.get(sum))
				{
					ml = i - di.get(sum);
					ei = i;
				}
			}
			
			else {
				di.put(sum, i);
			}
		}


		if (ei != -1) {
			System.out.println((ei - ml + 1) +" "+
									   ei);
		}
		else {
			System.out.println("None");
		}
	}

	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			maxLenSubarray(arr);
		}
		sc.close();
		

	}
}