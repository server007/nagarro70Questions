import java.util.*;


public class TreeTopView {
	
		static class Node{
			int value;
			Node left, right;
			
			Node(int value){
				this.value = value;
				left = null;
				right = null;
			}
		}

	public Node insertLevelOrder(ArrayList<Integer> arr ,Node root, int i, int n) {
		if(i < n) {
			Node temp = new Node((int)arr.get(i));
			root = temp;
			if(root.value == -1) {
				arr.add(2*i+1, -1);
				arr.add(2*i+2, -1);
			}
			root.left = insertLevelOrder(arr, root.left, 2*i+1, n);
			root.right = insertLevelOrder(arr, root.right, 2*i+2, n);
		}
		return root;
	}
	
	public void traverseLeft(Node node) {
		if(node != null) {
			traverseLeft(node.left);
			if(node.value != -1) {
			System.out.print(node.value + " ");
			}
		}
				
	}
	
	public void traverseRight(Node node) {
		if(node != null) {
			if(node.value != -1) {
				System.out.print(node.value + " ");
				}
			traverseRight(node.right);	
		}
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		String[] tokens = s.split("\\s+");
		int n = tokens.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i =0;i < n; i++) {
			arr.add(Integer.parseInt(tokens[i]));
		}
		for(int j = 0; j<=2*n+2; j++) arr.add(-1);
		
				
		TreeTopView tree = new TreeTopView();
	    Node root = null;
	    root = tree.insertLevelOrder(arr ,root, 0, n);
	    tree.traverseLeft(root);
	    tree.traverseRight(root.right);
	    
	}
}
