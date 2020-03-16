import java.util.*;

public class DeleteBST {
	
	static class Node{
		int data;
		Node left, right;
		
		Node(int value){
			this.data = value;
			left = null;
			right = null;
		}
	}
	Node root;
	
	DeleteBST(){
		root = null;
	}
	
	private void insertTree(int value) {
		this.root = insert(this.root, value);
	}
	
	private Node insert(Node node, int value) {
		if(node == null) {
			node = new Node(value);
			return node;
		}else if(node.data > value) {
			node.left = this.insert(node.left, value);
		}else {
			node.right = this.insert(node.right, value);
		}
		return node;
	}
	
	
	private void delete(int value) {
		this.root = this.deleteRec(this.root, value);
	}
	
	private Node deleteRec(Node node, int value) {
		if(node == null) {
			return node;
		}else if(node.data > value) {
			node.left = this.deleteRec(node.left, value);
		}else if(node.data < value){
			node.right = this.deleteRec(node.right, value);
		}else{
			if (node.left == null) 
                return node.right; 
            else if (node.right == null) 
                return node.left; 
  
  
			node.data = this.minValue(node.right); 
			node.right = this.deleteRec(node.right, node.data); 
				
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


	private void preOrder() {
		this.RecPreOrder(this.root);
	}
	
	private void RecPreOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			this.RecPreOrder(root.left);
			this.RecPreOrder(root.right);
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
			DeleteBST tree = new DeleteBST();
			for(int i = 0; i<n; i++) {
				tree.insertTree(arr1[i]);
			}
			
//			tree.preOrder();
			System.out.println();
			for(int i = 0; i < m; i++) {
				tree.delete(arr2[i]);
			}
			
			tree.preOrder();
			t--;
		}
		sc.close();
	}
}
