import java.util.*;

public class UpperLower {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0;i<n;i++) {
        	arr[i] = sc.nextInt();
        }
        
        int q = sc.nextInt();
   
        for(int i = 0;i < q;i++){
            int x = sc.nextInt();
            int ind = binarySearch(arr, x, n-1);
            System.out.println(ind);
        
            if(ind == -1) {
                System.out.println(-1 + " "+ -1);
                }
            else {
	            int l = ind;
	            int u = ind;
	            while(l >=0 && arr[l]==x){
	                l--;
	            }
	            l++;
	            while(u <n && arr[u]==x ){
	                u++;
	            }
	            u--;
	            System.out.println(l + " " + u);
	            }
        }
        sc.close();
    }
    private static int binarySearch(int [] arr, int x, int n){
        int start = 0;
        int end = n;
        while(start <= end){
        	
        	int mid = (start+end)/2;
        	System.out.println(arr[mid] + "  " + start + "  " + end);
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x){
                start = mid+1;
            }else end = mid-1;
        }
        return -1;
    }
}