import java.util.*;


public class DigitalDictionary {
	class Node{
		char data;
		boolean isTerminal;
		HashMap<Character, Node> children;
		
		Node(char data, boolean isTerminal){
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap();
		}
	}
	
	private int numwords;
	private Node root;
	
	DigitalDictionary(){
		this.root = new Node('\0', false);
	}
	
	public void addWord(String word) {
		this.addWord(this.root, word);
	}
	
	private void addWord(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal) {
				return;
			}else {
				parent.isTerminal = true;
				this.numwords++;
			}
			return;
		}
		char cc= word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(cc);
		
		if(child == null) {
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		
		this.addWord(child, ros);
	}
	
	
	public boolean isPresent(String word) {
		return this.isPresent(this.root, word, word);
	}
	
	private boolean isPresent(Node parent, String word, String ans) {
		if(word.length() == 0) {
			this.display(parent, ans);
			return true;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1); 
		
		Node child = parent.children.get(cc);
		
		if(child == null) return false;
		return this.isPresent(child, ros, ans);
	}
	
	private void display(Node parent, String ans) {
		if(parent.isTerminal) {
			System.out.println(ans);
		}
		Set<Map.Entry<Character, Node>> entries = parent.children.entrySet();
		for(Map.Entry<Character, Node> entry: entries) {
			display(entry.getValue(), ans+entry.getKey());
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DigitalDictionary obj = new DigitalDictionary();
		for(int i=0; i<n; i++) {
			obj.addWord(sc.next());
		}

		int q = sc.nextInt();
		for(int i=0; i<q; i++) {
			String word = sc.next();
			boolean flag = obj.isPresent(word);
			if(flag == false) {
				System.out.println("No suggestions");
				obj.addWord(word);
			}
		}
		sc.close();
	
	}
}
