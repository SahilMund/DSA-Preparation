package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

 class ResultPair {
	int height;
	boolean isBalanced;
	
	public ResultPair(int height,boolean isBalanced){
		this.height = height;
		this.isBalanced =  isBalanced;
	}
}

public class IsBalancedTreeBetter {
	
/*
 A tree will be balanced , if the absolute difference between the 
 height of left subtree and height of right subtree will be less than equal to 1
 | H(left) - H(right) | >= 1   --> T.C ==> O(N)
 */
public static ResultPair CheckIfBalancedBetter(BinaryTreeNode<Integer> root) {
	
	if(root == null) {
		int height = 0;
		boolean isBalanced = true;
		ResultPair ans = new ResultPair(height,isBalanced);
		return ans;
	}
	
	
	ResultPair leftAns = CheckIfBalancedBetter(root.left);
	ResultPair rightAns = CheckIfBalancedBetter(root.right);
	
	boolean isBal = true;
	int totHeight = 1 + leftAns.height + rightAns.height;
	
	if(Math.abs(leftAns.height - rightAns.height) > 1) {
		isBal = false;
	}
	
	if( !leftAns.isBalanced || !rightAns.isBalanced)
		isBal = false;
	
	ResultPair result = new ResultPair(totHeight,isBal);

	return result;
}
}
