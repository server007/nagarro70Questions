import java.util.*;
public class RootToLeaf {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		RootToLeaf m = new RootToLeaf();
		BinaryTree bt = m.new BinaryTree();
        int k = scn.nextInt();
        scn.close();
		bt.paths(k);
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

        public void traverse(Node node, int i, int k, String s){
            if(node != null){
//                if(i==k && node.left==null && node.right==null){
//                    System.out.println(s);
//                    return;
//                }else if(i>k) return;
                traverse(node.left, i+node.data, k, s + node.data + " ");
                System.out.println(node.data);
                traverse(node.right, i+node.data, k, s + node.data + " ");
            }
        }

        public void paths(int k){
            Node start = this.root;
            traverse(start, 0, k, "");

        }
	}
}
