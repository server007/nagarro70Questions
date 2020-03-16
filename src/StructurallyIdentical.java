import java.util.*;
class StructurallyIdentical{

	static Scanner scn = new Scanner(System.in);
	static String s1="";
	static String s2="";
	public static void main(String[] args) {
		StructurallyIdentical m = new StructurallyIdentical();
		BinaryTree bt1 = m.new BinaryTree();
		BinaryTree bt2 = m.new BinaryTree();
		System.out.println(bt1.structurallyIdentical(bt2));
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public boolean structurallyIdentical(BinaryTree other) {
			return this.structurallyIdentical(this.root, other.root);
		}

		public void traverses1(Node node){
			if(node != null){
				traverses1(node.left);
				StructurallyIdentical.s1 = StructurallyIdentical.s1 + 'L';
				traverses1(node.right);
				StructurallyIdentical.s1 = StructurallyIdentical.s1 + 'R';
				}
		}
		public void traverses2(Node node){
			if(node != null){
				traverses2(node.left);
				StructurallyIdentical.s2 = StructurallyIdentical.s2 + 'L';
				traverses2(node.right);
				StructurallyIdentical.s2 = StructurallyIdentical.s2 + 'R';
				}
		}

		private boolean structurallyIdentical(Node tnode, Node onode) {
			// write your code here
			traverses1(tnode);
			traverses2(onode);
			if(StructurallyIdentical.s1.equals(StructurallyIdentical.s2)) { 
				return true;
				}
			return false;

		}

	}
}
