package BST_1;

import binaryTree_1.BinaryTreeNode;
class ResultPair {
	
	 int max;
	 int min;
	 boolean isBST;
	 
	 public ResultPair(int max,int min,boolean isBST) {
		 this.max=max;
		 this.min=min;
		 this.isBST=isBST;
	 }
}

public class ISBST {

	// 1. Approach - 1:- T.C => O(nh)
	public static int maximum(BinaryTreeNode<Integer> root) {
		
		if(root == null)
			return Integer.MIN_VALUE;
		
		int leftMax = maximum(root.left);
		int rightMax = maximum(root.right);
		
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		
		if(root == null)
			return Integer.MAX_VALUE;
		
		int leftMax = minimum(root.left);
		int rightMax = minimum(root.right);
		
		return Math.min(root.data, Math.min(leftMax, rightMax));
	}

	public static boolean checkIfBST1(BinaryTreeNode<Integer> root) {
		if(root == null)
			return true;
		
		int leftMax = maximum(root.left);
		
		if(leftMax >= root.data)
			return false;
		
		int rightMin = minimum(root.right);
		
		if(rightMin < root.data)
			return false;
		
		boolean isLeftBst = checkIfBST1(root.left);
		boolean isRightBst = checkIfBST1(root.right);
		
		return isLeftBst && isRightBst ;
	}
	
	// 2. 2nd approach 
	
	

	public static ResultPair checkIfBST(BinaryTreeNode<Integer> root) {
		
		// empty tree is a BST
		if(root == null)
			return new ResultPair(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
		
		ResultPair leftPair = checkIfBST(root.left);
		ResultPair rightPair = checkIfBST(root.right);
		

		int min = Math.min(root.data,Math.min(leftPair.min, rightPair.min));
		int max = Math.max(root.data,Math.max(leftPair.min, rightPair.min));
		
		boolean isBST = true;
		
		if(leftPair.max >= root.data || rightPair.min < root.data || (leftPair.isBST && rightPair.isBST)) {
			isBST = false;
		}
		
		ResultPair ans = new ResultPair(max,min,isBST);
		return ans;

	}
	
//	public static void main(String[] args) {
//		
//		System.out.print(checkIfBST1(root));
//	}
}
