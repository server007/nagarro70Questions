import java.util.Scanner;

public class DeleteBSTnew {
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int value){
			this.data = value;
			left = null;
			right = null;
		}
	}
	
	

	private Node root = null;
	private int size;
	
	
	public void insertTree(int value) {
		this.root = insert(this.root, value);
	}
	
	private Node insert(Node node, int value) {
		if(node == null) {
			node = new Node(value);
			return node;
		}else if(node.data > value) {
			node.left = insert(node.left, value);
		}else {
			node.right = insert(node.right, value);
		}
		return node;
	}
	
	public void delete(int value) {
		this.root = deleteRec(this.root, value);
	}
	
	private Node deleteRec(Node node, int value) {
		if(node == null) {
			return node;
		}else if(node.data < value) {
			deleteRec(node.left, value);
		}else if(node.data >value){
			deleteRec(node.right, value);
		}else{
			if (node.left == null) 
                return node.right; 
            else if (node.right == null) 
                return node.left; 
  
  
			node.data = minValue(node.right); 
			node.right = deleteRec(node.right, node.data); 
				
			}
		return node;
}
	
	int minValue(Node node) 
    { 
        int minv = node.data; 
        while (node.left != null) 
        { 
            minv = node.left.data; 
            node = node.left; 
        } 
        return minv; 
    } 
	
	public void preOrder() {
		RecPreOrder(this.root);
	}
	
	private void RecPreOrder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			RecPreOrder(node.left);
			RecPreOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0) {
			int n = sc.nextInt();
			int arr1 [] = new int[n];
			for(int i = 0; i < n; i++) {
				arr1[i] = sc.nextInt();
			}
			
			int m = sc.nextInt();
			int arr2 [] = new int[m];
			for(int i = 0;i <m; i++) {
				arr2[i] = sc.nextInt();
			}
			DeleteBSTnew tree = new DeleteBSTnew();
			for(int i = 0; i<n; i++) {
				tree.insertTree(arr1[i]);
			}
			
			for(int i = 0; i < m; i++) {
				tree.delete(arr2[i]);
			}
			
			tree.preOrder();
			t--;
		}
		sc.close();
	}
		
}
	
	
	
	
	
	