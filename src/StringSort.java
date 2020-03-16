import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    String [] arr = new String[n];
	    
	    for(int i = 0; i<n; i++){
	        arr[i] = in.next();
	    }
	    in.close();
	    Arrays.sort(arr);
	    
	    int mainindex = 0;
	    int index[] = new int[n];
	    int count = 0;
	    

	    for(int currindex = 1; currindex < n; currindex++) {
	    	if(arr[currindex].startsWith(arr[mainindex])) {
	    		count++;
	    	}
	    	else {
	    		index[mainindex] = count;
	    		count = 0;
	    		mainindex = currindex;

	    	}
	    }
	    index[mainindex] = count;
	    
	    List<String> ans = new ArrayList<String>();
	    
	    int i = 0;
	    while(i < n) {
	    	
	    	if(index[i] > 0) {
	    		List<String> tempList = new ArrayList<String>();
	    		for(int j = i ; j <= i+index[i]; j++) {
	    			tempList.add(arr[j]);
	    		}
	    		Collections.sort(tempList, Comparator.comparing(String::length));
	    		Collections.reverse(tempList);
	    		ans.addAll(tempList);
	    		i = i+index[i]+1;
	    	}
	    	else {
	    		ans.add(arr[i]);
	    		i++;
	    	}
	    	
	    }
	    ans.forEach(System.out::println);

	}
	
}
