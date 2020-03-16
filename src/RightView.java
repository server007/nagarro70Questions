import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;




public class RightView {
	
	class BinaryTree{
		Scanner sc = new Scanner(System.in);
		
		private Map<Integer, Node> rmap = new TreeMap<Integer, Node>();
		 
		
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

		public void rightView() {
			this.rightView(this.root);
//			this.printTopView(this.root.left,1);
//			this.printTopView(this.root.right,0);
			
//			for (Map.Entry<Integer, Node> element : lmap.entrySet()) {
//			   System.out.print((element.getValue()).data + " ");
//			  } 
			for (Map.Entry<Integer, Node> element : rmap.entrySet()) {
				   System.out.print((element.getValue()).data + " ");
				  } 
			
		}
		
		private void rightView(Node node) {
			if(node == null) return;
//			System.out.println(node.data + " nv " + node.ver + " nd " + node.dis );
			if(!rmap.containsKey(node.ver)) {
				rmap.put(node.ver, node);
			}else {
				if(rmap.get(node.ver).dis <= node.dis ) {
					rmap.put(node.ver,	node);
				}
			}
			rightView(node.left);
			rightView(node.right);
			}
		}
	
	
	public static void main(String[] args) {
		RightView obj = new RightView();
		BinaryTree bt = obj.new BinaryTree();
		bt.rightView();
	}
}