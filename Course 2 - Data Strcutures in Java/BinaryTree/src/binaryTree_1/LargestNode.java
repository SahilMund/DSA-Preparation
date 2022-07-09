package binaryTree_1;

public class LargestNode {

	public static int findMaxNode(BinaryTreeNode<Integer> root) {

        if(root == null)
            return -1;

       int leftMaxNode = findMaxNode(root.left);
       int rightMaxNode = findMaxNode(root.right);
       
       return Math.max(root.data, Math.max(leftMaxNode, rightMaxNode));

    }
	
	// count all the nodes which values are greater than x
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {

        if(root == null)
            return 0;


        int leftCount = countNodesGreaterThanX(root.left,x);
        int rightCount = countNodesGreaterThanX(root.right,x);

        if(root.data > x)  
            return 1 + leftCount + rightCount;
        else
            return leftCount + rightCount;


    }
}
