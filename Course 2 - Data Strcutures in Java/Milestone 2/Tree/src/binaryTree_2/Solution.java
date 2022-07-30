package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class Solution {

	 public static void printTreeDetailed(BinaryTreeNode<Integer> root){
	        if(root == null){
	            return;
	        }
	        System.out.print(root.data+":");
	        if(root.left != null){
	            System.out.print("L"+root.left.data+", ");
	            }
	        if(root.right != null){
	            System.out.print("R"+root.right.data);
	            }
	        System.out.println();
	        printTreeDetailed(root.left);
	        printTreeDetailed(root.right);

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeNode<Integer> root = LevelWiseInput.takeInputLevelWise();
		
		printTreeDetailed(root);
	}

}
