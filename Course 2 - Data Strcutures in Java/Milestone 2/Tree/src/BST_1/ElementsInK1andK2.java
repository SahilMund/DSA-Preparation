package BST_1;

import binaryTree_1.BinaryTreeNode;

public class ElementsInK1andK2 {

	 public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){

	        if(root == null)
	            return;

	        if(root.data >= k1 && root.data <= k2){
	            elementsInRangeK1K2(root.left,k1,k2);
	            System.out.print(root.data+" ");
	            elementsInRangeK1K2(root.right,k1,k2);
	        }

		     // search only on right subtree
		        else if(root.data < k1)
		            elementsInRangeK1K2(root.right,k1,k2);
		        
		        // search only on left subtree
		        else if (root.data > k2)
		            elementsInRangeK1K2(root.left,k1,k2);
	

	    }
}
