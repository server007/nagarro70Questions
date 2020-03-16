//Find the largest rectangular area possible 
//in a given histogram where the largest 
//rectangle can be made of a number of contiguous bars.
//
//Sample Input
//5
//1 2 3 4 5
//Sample Output
//9

import java.util.*;

public class HistogramArea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long height [] = new long[n];
		for(int i = 0; i<n; i++) {
			height[i] = sc.nextLong();
		}
		sc.close();
		long ans = maxArea(height, n);
		System.out.println(ans);
	}

	private static long maxArea(long[] height, int n) {
		Stack<Integer> st = new Stack<Integer>();
		long maxArea = 0;
		long currArea = 0;
		int i;
		
		for(i = 0; i<n;) {
			if(st.isEmpty() || height[st.peek()] <= height[i]) {
				st.push(i++);
			}else {
				int top = st.pop();
				if(st.isEmpty()) {
					currArea = height[top]*i;
				}
				else {
					currArea = height[top]*(i-st.peek()-1);
				}
				if(currArea > maxArea) {
					maxArea = currArea;
				}
			}
		}
		while(!st.isEmpty()) {
			int top = st.pop();
			if(st.isEmpty()) {
				currArea = height[top]*i;
			}
			else {
				currArea = height[top]*(i-st.peek()-1);
			}
		
		if(currArea > maxArea) {
			maxArea = currArea;
		}
		}
		return maxArea;
	}
}
 