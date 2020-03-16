//You are given an array of length N, where 
//ith element of array denotes the price of a 
//stock on ith. Find the span of stock's price on ith day, 
//for every 1<=i<=N.
//A span of a stock's price on a given day, i,
//is the maximum number of consecutive days
//before the (i+1)th day, for which stock's price 
//on these days is less than or equal to that on the ith day.
//
//Sample Input
//1
//5
//1 2 4 3 5
//Sample Output
//1 2 3 1 5 



// key is to store index in stack instead of value

import java.util.*;
public class StockSpan {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            long arr [] = new long[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextLong();
            }
            Stack<Integer> st = new Stack<Integer>();
            long span [] = new long[n];
            span[0] = 1;
            st.push(0);
            for(int i = 1; i<n; i++) {
            	while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
            		st.pop();
            	}
            	span[i] = (st.empty()) ? (i + 1) : (i - st.peek()); 
            	st.push(i);
            }
            for(int i = 0; i<n; i++) {
            	System.out.print(span[i] + " ");
            }
            t--;
        }
        sc.close();
    }
}
