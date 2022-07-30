package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class InsertDuplicateNodestotheLeft {

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
	       
        if(root == null)
            return;
        
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);

        // Let's build logic for root node and others for recursion
        BinaryTreeNode<Integer> save = root.left;
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
        root.left = newNode;
        newNode.left = save;

    }
}
