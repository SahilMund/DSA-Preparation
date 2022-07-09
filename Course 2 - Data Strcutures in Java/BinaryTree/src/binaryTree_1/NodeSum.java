package binaryTree_1;

public class NodeSum {

	  public static int getSum(BinaryTreeNode<Integer> root) {

	        if(root == null)
	            return 0;


	        int leftNodeSum  = getSum(root.left);
	        int rightNodeSum = getSum(root.right);

	        return root.data + leftNodeSum + rightNodeSum;

	    }
}
