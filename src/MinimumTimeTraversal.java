import java.util.*;

public class MinimumTimeTraversal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int startx = sc.nextInt();
			int starty = sc.nextInt();
			int endx= sc.nextInt();
			int endy = sc.nextInt();
			
			if(n==0) {
				int ans = Math.abs(starty-endy) + Math.abs(startx-endx);
				System.out.println(ans);
				continue;
			}
			int [] fx = new int[n];
			int [] fy = new int[n];
			int [] sx = new int[n];
			int [] sy = new int[n];
			
			for(int i=0; i<n; i++) {
				fx[i] = sc.nextInt();
				fy[i] = sc.nextInt();
				sx[i] = sc.nextInt();
				sy[i] = sc.nextInt();
			}
			sc.close();
			int ans = minimumTime(startx, starty, endx, endy, fx, fy, sx, sy, n, 0);
			System.out.println(ans);
		}
	}

	private static int minimumTime(int startx, int starty, int endx, int endy, int[] fx, int[] fy, int[] sx, int[] sy,
			int n, int time) {
		if(startx==endx && starty==endy) {
			return time;
		}
		
		return 0;
	}
}
