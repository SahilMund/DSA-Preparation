package BST_2;

import binaryTree_1.BinaryTreeNode;

class ReturnData{
    int min;
    int max;
    boolean isBST;
    int heightofLargestBST;

    ReturnData(int min,int max,boolean isBST,int heightofLargestBST){
        this.min=min;
        this.max =max;
        this.isBST=isBST;
        this.heightofLargestBST=heightofLargestBST;
    }
}
public class LargestBST {
    /*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */

    public static ReturnData largestBSTSubtreeHelper(BinaryTreeNode<Integer> root){
        // check if root is null, then it is BST and heightofLargestBST will be zero
        if(root==null){
            return new ReturnData(Integer.MAX_VALUE,Integer.MIN_VALUE,true,0);
        }

        // call recrusively for both left and right subtree
        ReturnData leftOP = largestBSTSubtreeHelper(root.left);
        ReturnData rightOP = largestBSTSubtreeHelper(root.right);

        // initially considering ans's isBST as false
        ReturnData ans = new ReturnData(0,0,false,0);

        // To be a BST , both left and right subtree should be a BST and 
        // maximum of left subtree should be less than root data and
        // minimum of right subtree should be greater than and equals to root data
        if((leftOP.isBST && rightOP.isBST) && (leftOP.max < root.data && root.data <= rightOP.min)){
            ans.isBST=true;
            // height = 1(adding current node) + max(height of largest left subtree + height of largest right subtree)
            ans.heightofLargestBST = 1 + Math.max(leftOP.heightofLargestBST,rightOP.heightofLargestBST);

        }else{
            // height =  max(height of largest left subtree + height of largest right subtree)
            ans.heightofLargestBST = Math.max(leftOP.heightofLargestBST,rightOP.heightofLargestBST);
        }

        /*
        If suppose the left and right subtrees of the
        current node are BST and the current node value is
        greater than the maximum value in the left subtree
        and also the current node value is smaller that the
        minimum value in the right subtree (Basic conditions
        for the formation of BST) then our whole subtree
        with the root as current root can be consider as a
        BST. Hence the size of the BST will become size of
        left BST subtree + size of right BST subtree +
        1(adding current node).

        Else we will consider the largest of the left BST or
        the  right BST.
        */

        ans.min = Math.min(root.data,Math.min(leftOP.min,rightOP.min));
        ans.max = Math.max(root.data,Math.max(leftOP.max,rightOP.max));


        return ans;

    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        ReturnData ans = largestBSTSubtreeHelper(root);
        return ans.heightofLargestBST;
    }

}
