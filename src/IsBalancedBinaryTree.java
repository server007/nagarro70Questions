import java.util.*;

public class IsBalancedBinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		IsBalancedBinaryTree m = new IsBalancedBinaryTree();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
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

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {
			int l = 0;
			int r = 0;
			Node temp = node;
			while(temp.left != null){
				l++;
				temp = temp.left;

			}
			temp = node;
			while(temp.right != null){
				r++;
				temp = temp.right;

			}
			BalancedPair obj = new BalancedPair();
			if(Math.abs(l-r) <= 1) obj.isBalanced = true;
			else obj.isBalanced = false;
			obj.height = l;
			return obj;
			


			// write your code here

		}

		private class BalancedPair {
			int height;
			boolean isBalanced;
		}

	}
}
