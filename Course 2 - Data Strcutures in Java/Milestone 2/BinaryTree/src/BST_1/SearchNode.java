package BST_1;

import binaryTree_1.BinaryTreeNode;

public class SearchNode {

public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		
        if(root == null){
            return false;
        }
        
        if(root.data == k){
            return true;
        }
        
        
        if(k < root.data)
            return searchInBST(root.left,k);
        else
            return searchInBST(root.right,k);
        
	}
}
