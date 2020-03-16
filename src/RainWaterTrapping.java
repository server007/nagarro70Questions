//You are given an input array whose each element
//represents the height of a line towers. The width
//of every tower is 1. It starts raining. Water is
//filled between the gap of towers if possible. You need
//to find how much water filled between these given towers.
import java.util.*;


public class RainWaterTrapping {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			for(int i =0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = totalArea(arr, n);
			System.out.println(ans);
			t--;
		}
		sc.close();
	}

	private static int totalArea(int[] arr, int n) {
		LinkedList<Integer> que = new LinkedList<Integer>();
		int totalArea = 0;
		for(int i = 0; i<n; i++) {
			if(!que.isEmpty()) {
				if(arr[i] < que.getFirst()) {
					que.add(arr[i]);
				}else {
					int x = que.poll();
					while(!que.isEmpty()) {
						totalArea += x-que.poll();
					}
				}
			}else {
				que.add(arr[i]);
			}
		while(!que.isEmpty()) {
			
		}
		
		} 
		
		return totalArea;
	}
}
