package binaryTree_1;

public class PrintNodeAtDepathK {

	
	public static void printAtDepathK(BinaryTreeNode<Integer> root, int k) {
		if(root == null)
			return;
		
		if(k == 0) {
			System.out.print(root.data);
			return;
		}
		
		printAtDepathK(root.left,k-1);
		printAtDepathK(root.right,k-1);
		
	}
}
