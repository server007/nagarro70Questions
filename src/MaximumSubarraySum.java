import java.util.*;
public class MaximumSubarraySum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            long [] arr = new long[n];
            for(int i = 0;i < n; i++){
                arr[i] = sc.nextLong();
            }
            System.out.println(maxSum(arr, n));
            t--;
        }
        sc.close();
    }

    private static long maxSum(long [] arr, int n){
        long currsum = 0;
        long maxsum = 0;
        for(int i = 0; i < n; i++){
            currsum += arr[i];
            if(currsum < 0){
                currsum = 0;
            }
            if(currsum > maxsum){
                maxsum = currsum;
            }
            
        }
        return maxsum;
    }
}