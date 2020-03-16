import java.util.*;

public class SortLinkListMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			ll.add(sc.nextInt());
		}
		sc.close();
//		int a[] = {3,1,2,4,5};
//		mergeSort(ll,ll.getFirst(), ll.getLast());
	}

	private static void mergeSort(LinkedList<Integer> ll,int l, int r) {
		if(l < r) {
			int m = (l+r)/2;
			mergeSort(ll, l, m);
			mergeSort(ll, m+1, r);
			
			merge(ll, l, m, r);
		}
	}
	
	private static void merge(LinkedList<Integer> ll, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i=0; i< n1; ++i) {
			L[i] = ll[l+i];
		}
		for(int j=0; j<n2; ++j) {
			R[j] = ll[m+j+1];
		}
		
		int i=0, j=0;
		int k=l;
		while(i<n1 && j<n2) {
			if(L[i] <= R[j]) {
				ll[k] = L[i];
				i++;
			}
			else {
				ll[k] = R[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			ll[k] = L[i];
			i++;
			k++;
		}
		while(j<n2) {
			ll[k] = R[j];
			j++;
			k++;
		}
	}
}
