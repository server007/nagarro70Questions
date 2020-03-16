import java.util.*;



public class TreeTopView1 {
	
	class BinaryTree{
		Scanner sc = new Scanner(System.in);
		
		private Map<Integer, Node> lmap = new TreeMap<Integer, Node>();
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

		public void printTopView() {
//			System.out.println(root.right.data);
			lmap.put(root.dis, root);
			this.printTopView(this.root.left,1);
			this.printTopView(this.root.right,0);
			
			for (Map.Entry<Integer, Node> element : lmap.entrySet()) {
			   System.out.print((element.getValue()).data + " ");
			  } 
//			System.out.println();
			for (Map.Entry<Integer, Node> element : rmap.entrySet()) {
				   System.out.print((element.getValue()).data + " ");
				  } 
		
			
			
//			for (Map.Entry<Integer, Node> element : map.entrySet()) {
//				   System.out.print((element.getValue()).data + " ");
//				  } 
			
		}
		
		private void printTopView(Node node, int counter) {
			if(node == null) return;
			if(counter==1) {
//				System.out.println(node.dis+ " c " + counter);
				if(!lmap.containsKey(node.dis) && node.dis < 0) {
					lmap.put(node.dis, node);
				}
				
			}else if(counter==0) {
//				System.out.println(node.dis+ " c " + counter + " " + node.data);
				if(!rmap.containsKey(node.dis) && node.dis > 0) {
					rmap.put(node.dis, node);
				}
			}
			
			printTopView(node.left,counter);
			printTopView(node.right,counter);
			}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		TreeTopView1 obj = new TreeTopView1();
		BinaryTree bt = obj.new BinaryTree();
		bt.printTopView();
	}
}