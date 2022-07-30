package BST_1;

import binaryTree_1.BinaryTreeNode;

public class LCA_of_BAST {

	public static int getLCA(BinaryTreeNode<Integer> root, int n1, int n2) {
        if (root == null) 
            return -1; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (root.data > n1 && root.data > n2) 
            return getLCA(root.left, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (root.data < n1 && root.data < n2)  
            return getLCA(root.right, n1, n2); 
        
   		// if both the above cases failed, then current root will be the ans.
        return root.data; 
        
		
	}
}
