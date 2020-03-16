import java.util.*;
public class SimpleEnough1 {
	static HashMap<Integer, String> hm = new HashMap<Integer, String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		sc.close();
		hm.put(1, "1");
		hm.put(2, "101");
		hm.put(3, "111");
		String ans = get(n);
		System.out.println(ans.substring(l-1,r));


	}

	private static String get(int n) {
		System.out.println(n);
		if(hm.containsKey(n)) {
			return hm.get(n);
		}else {
			hm.put(n, hm.get((int)n/2) + n%2 + hm.get((int)n/2));
			return hm.get(n);
		}
		
	}
}
