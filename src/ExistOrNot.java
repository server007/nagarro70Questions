import java.util.*;

public class ExistOrNot
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		for(int m = 0; m<t; m++){
//            if(sc.hasNextInt()){
			int n = sc.nextInt();
            
			int [] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();	
			}
			Arrays.sort(arr);
			
			int q = sc.nextInt();
			for(int i = 0; i< q; i++) {
				int item = sc.nextInt();
				binarySearch(arr, 0, n-1, item); 
			}
					
//		}
		t--;
		}
		sc.close();
	}

	private static void binarySearch(int[] arr, int start, int end, int item) {
		// TODO Auto-generated method stub
		int mid = (start+end)/2;
		if(start>end){
			System.out.println("No");
		}
		else if(arr[mid]==item){
			System.out.println("Yes");
		}
		else if(arr[mid]>item){
		end = mid-1;
		binarySearch(arr, start, end, item);
		}
		else{
		start = mid+1;
		binarySearch(arr, start, end, item);
		}
		}
	
	

}