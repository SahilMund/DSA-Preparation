package binaryTree_1;

public class CountLeafNodes {

	// count leaf nodes
	public static int getCountofLeafNodes(BinaryTreeNode<Integer> root) {
		
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		int lCount = getCountofLeafNodes(root.left);
		int rCount = getCountofLeafNodes(root.right);
		
		return lCount+rCount;
			
	}
}
