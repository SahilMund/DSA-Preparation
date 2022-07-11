package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class RemoveLeafNodes {

	
	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
		
		if(root == null)
			return null;
		
		// leaf nodes
		if(root.left == null && root.right == null)
			return null;
		
		// else remove leaf nodes
		root.left = removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		
		return root;
		
	}
}
