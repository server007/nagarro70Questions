//Given a Binary Tree, write a program that returns the size 
//of the largest subtree which is also a Binary Search Tree (BST)
//Input Format
//The first line of input will contain an integer n.
//The next line will contain n integers denoting the 
//the preorder traversal of the BT. The next line will 
//contain n more integers denoting the inorder traversal of the BT.





import java.util.Scanner;

public class LargestBst {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		} 
	}
	
	private Node root;
	private int size;
	
	public void add(int[] in, int[] pre) {
		this.root = adding(in, pre, 0, 0, in.length-1);
	}
	
	private Node adding(int [] in, int[] pre, int preStart, int inStart, int inEnd) {
		if(inStart > inEnd || preStart > pre.length-1) return null;
		Node r = new Node(pre[preStart], null, null);
		this.size++;
		
		int ind = 0;
		for(int i=inStart; i<=inEnd; i++) {
			if(r.data == in[i]) {
				ind = i;
			}
		}
		
		r.left = adding(in, pre, preStart+1, inStart, ind-1);
		r.right = adding(in, pre, preStart+ind-inStart+1, ind+1, inEnd);
		return r;
	}
	
	public void max() {
		this.max(this.root);
	}
	
	private void max(Node node) {
		if(node == null) {
			return;
		}
		this.max(node.right);
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
		}
	}
	
	public void display() {
		this.display(this.root);
	}
	
	private void display(Node node) {
		if(node.left != null) {
			System.out.print(node.left.data+"=>");
		}else {
			System.out.print("END=>");
		}
		System.out.print(node.data);
		if(node.right != null) {
			System.out.print("<="+node.right.data);
		}else {
			System.out.print("<=END");
		}
		System.out.println();
		
		if(node.left != null) {
			this.display(node.left);
		}
		if(node.right != null) {
			this.display(node.right);
		}
	}
	
//	public boolean isBST() {
//		return this.isBST(this.root,Integer.MIN_VALUE, Integer.MAX_VALUE );
//	}
//	
//	private boolean isBST(Node node, int min, int max) {
//		if(node == null) {
//			return true;
//		}
//		if(node.data < min || node.data > max) {
//			return false;
//		} else if(!this.isBST(node.left,min, node.data)) {
//			return false;
//		} else if(!this.isBST(node.right, node.data, max)) {
//			return false;
//		}else {
//			return true;
//		}
//	}
	
	
	public int isBST() {
		return this.isBST(this.root,Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
	}
	
	private int isBST(Node node, int min, int max, int s) {
		if(node == null) {
			return s;
		}
		if(node.data < min || node.data > max) {
			return s;
		}
		return Math.max(this.isBST(node.left,min, node.data, s+1),
				this.isBST(node.right, node.data, max, s+1));
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LargestBst tree = new LargestBst();
		int n = sc.nextInt();
		int [] pre = new int[n];
		int [] in = new int[n];
		for(int i=0; i<n; i++) {
			pre[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			in[i] = sc.nextInt();
		}
		
		tree.add(in, pre);
		System.out.println(tree.isBST());
		sc.close();
		
	}
}
