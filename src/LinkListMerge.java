import java.util.*;
public class LinkListMerge {
	Node head = null;
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	
	public void add(int x) 
	{ 
		
		Node node = new Node(x); 

		node.next = head; 

		head = node; 
	}
	
	public static Node mergeSort(Node node){
		if(node == null || node.next == null) return node;
		Node middle = getmiddle(node);
		Node nm = middle.next;
		middle.next = null;
		Node left = mergeSort(node);
		Node right = mergeSort(nm);
		
		
		return merge(left, right);
		
	}

	public static Node merge(Node left, Node right) {
		if(left == null) return right;
		if(right == null) return left;
		Node temp = null;
		if(left.data <= right.data) {
			temp = left;
			temp.next = merge(left.next, right);
		}else {
			temp = right;
			temp.next = merge(left, right.next);
		}
		return temp;
	}

	 public static Node getmiddle(Node node) {
		if(node==null) return node;
		Node fast = node;
		Node slow = node;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	 public void display(Node node) {
		 if(node == null) return;
		 System.out.print(node.data + " ");
		 display(node.next);
	 }

	public static void main(String[] args) {
		LinkListMerge ll = new LinkListMerge();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			ll.add(sc.nextInt());
		}
		sc.close();
		ll.head = mergeSort(ll.head);
		ll.display(ll.head);
		}
}




	