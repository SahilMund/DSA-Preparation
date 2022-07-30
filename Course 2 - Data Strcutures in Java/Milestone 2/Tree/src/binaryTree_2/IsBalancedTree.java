package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class IsBalancedTree {
	// T.C =  O(n^2)

public static int height(BinaryTreeNode<Integer> root) {
        
        if(root == null)
            return 0;
        
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        
        return 1 +  Math.max(leftheight,rightheight);
	}

public static boolean CheckIfBalanced(BinaryTreeNode<Integer> root) {
	
	if(root == null)
		return true;
	
	if(Math.abs(height(root.left) - height(root.right)) > 1) {
		return false;
	}
	
	return CheckIfBalanced(root.left) && CheckIfBalanced(root.right);
	
	
	
}
}
