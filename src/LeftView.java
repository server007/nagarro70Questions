import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;




public class LeftView {
	
	class BinaryTree{
		Scanner sc = new Scanner(System.in);
		
		private Map<Integer, Node> lmap = new TreeMap<Integer, Node>();
		 
		
		private class Node{
			int data;
			int dis;
			int ver;
			Node left;
			Node right;
		}
		
		private Node root;
		private int size;
		
		public BinaryTree() {
			this.root = this.takeInput();
			
		}
		
		public Node takeInput() {
			int rootData = sc.nextInt();
			
			if(rootData == -1) {
				return null;
			}
			
			Node rootNode = new Node();
			rootNode.data = rootData;
			rootNode.dis = 0;
			rootNode.ver = 0;
			
			Queue<Node> q = new LinkedList<Node>();
			q.add(rootNode);
			
			while(!q.isEmpty()) {
				Node temp = q.remove();
				int lc = sc.nextInt();
				if(lc != -1) {
					Node leftc = new Node();
					leftc.data = lc;
					leftc.dis = temp.dis-1;
					leftc.ver = temp.ver + 1;
					temp.left = leftc;
					q.add(leftc);
				}
				int rc = sc.nextInt();
				if(rc != -1) {
					Node rightc = new Node();
					rightc.data = rc;
					rightc.dis = temp.dis+1;
					rightc.ver = temp.ver+1;
					temp.right = rightc;
					q.add(rightc);
				}
			}
			return rootNode;
			
		}

		public void leftView() {
			this.leftView(this.root);

			for (Map.Entry<Integer, Node> element : lmap.entrySet()) {
				   System.out.print((element.getValue()).data + " ");
				  } 
			
		}
		
		private void leftView(Node node) {
			if(node == null) return;
//			System.out.println(node.data + " nv " + node.ver + " nd " + node.dis );
			if(!lmap.containsKey(node.ver)) {
				lmap.put(node.ver, node);
			}else {
				if(lmap.get(node.ver).dis > node.dis ) {
					lmap.put(node.ver,	node);
				}
			}
			leftView(node.left);
			leftView(node.right);
			}
		}
	
	
	public static void main(String[] args) {
		LeftView obj = new LeftView();
		BinaryTree bt = obj.new BinaryTree();
		bt.leftView();
	}
}