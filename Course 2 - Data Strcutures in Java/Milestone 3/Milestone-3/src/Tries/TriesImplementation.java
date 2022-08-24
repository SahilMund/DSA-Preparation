package Tries;

class TrieNode{

	char data;
	boolean isTerminal;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {

		this.data = data;
		this.isTerminal = false;
		// considering either uppercase / lowercase characters
		this.children = new TrieNode[26];

	}
}
public class TriesImplementation {

	private TrieNode root;

	public TriesImplementation() {
		root = new TrieNode('\0');
	}

	private static void addHelper(TrieNode root, String word) {

		if(word.length() == 0) {
			root.isTerminal = true;
			return;
		}

		int childIndex = word.charAt(0) - 'A';
		// let's check if the node/element is present in the child array or not
		// and if not then create a new element for it and add it to the child array
		TrieNode child = root.children[childIndex];
		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		addHelper(child,word.substring(1));

	}
	public void add(String word) {

		addHelper(root,word);

	}

	public boolean searchHelper(TrieNode root , String word) {

		if(word.length() == 0) {
			return root.isTerminal;
		}

		int childIndex = word.charAt(0) - 'A';
		// let's check if the node/element is present or not

		TrieNode child = root.children[childIndex];

		if(child == null) {
			return false;
		}

		return searchHelper(child,word.substring(1));

	}

	public boolean search(String word) {

		return searchHelper(root,word);
	}


	public void removeHelper(TrieNode root , String word) {

		if(word.length() == 0) {
			root.isTerminal = false;
			return;
		}

		int childIndex = word.charAt(0) - 'A';
		// let's check if the node/element is present or not

		TrieNode child = root.children[childIndex];

		if(child == null) {
			return;
		}

		removeHelper(child,word.substring(1));

		if(!child.isTerminal && child.childCount == 0) {
			// remove the child from the root
			root.children[childIndex] =null;
			root.childCount--;
		}

	}

	public void remove(String word) {

		removeHelper(root,word);
	}

	public int count(TrieNode root){
		// Write your code here
		int result = 0;

		// Leaf denotes end of a word
		if (root.isTerminal)
			result++;

		for (int i = 0; i < 26; i++)  { 
			if (root.children[i] != null)
				result += count(root.children[i]);
		}

		return result;  
	}

	public int countWords() {

		return count(root);
	}



}
