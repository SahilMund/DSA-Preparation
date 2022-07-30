package BST_1;


import binaryTree_1.BinaryTreeNode;
public class ReplaceWithSumOfGreaterNodes {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
        replaceWithLargerNodesSum(root,0);
	}
    
    public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum)
    {
        //Base Case
        if(root == null)
			return sum;
        
		//Recursive Case
        // reverse inorder traversal (right->root->left)
		int rightSum = replaceWithLargerNodesSum(root.right,sum);
        
		sum = rightSum + root.data;
        // root
		root.data = sum; // rightSum + root.data;
        
        //left
		return replaceWithLargerNodesSum(root.left,sum);
    }
}