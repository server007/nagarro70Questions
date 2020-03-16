import java.util.*;
public class LevelOrder {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		LevelOrder m = new LevelOrder();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
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

		public void levelOrderZZ() {
			this.levelOrderZZ(this.root);
			
		}
		
		
		private void levelOrderZZ(Node node){
			if(node == null) return;
			
			Deque<Node> deque = new LinkedList<>();
			deque.offer(null);
			deque.offerFirst(node);

			
			while(deque.size() > 1) {
				node = deque.peekFirst();
				while(node != null) {
					node = deque.pollFirst();
					System.out.print(node.data + " ");
					if(node.left != null) {
						deque.offerLast(node.left);
					}
					if(node.right != null) {
						deque.offerLast(node.right);
					}
					node = deque.peekFirst();
				}
				
				node = deque.peekLast();
				while(node != null) {
					System.out.print(node.data+ " ");
					node = deque.pollLast();
					if(node.right != null) {
						deque.offerFirst(node.right);
					}
					if(node.left != null) {
						deque.offerFirst(node.left);
					}
					node = deque.peekLast();
				}
				
			}
			
		}

	}

}
