package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

/*

Following is the structure used to represent the Binary Tree Node

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

*/

public class PathSumRootToLeaf {

/*
1. make a helper method in which we will pass our path also
2. add root.data to path and call helper methoed recursively with k = k-root.data
3. CHk if the node is leaf node and if it's value equals to k, then print the path.
*/

public static void helper(BinaryTreeNode<Integer> root, int k, String path){

    if(root == null)
        return;
   
    path = path + root.data + " ";

    helper(root.left, k-root.data,path);
    helper(root.right, k-root.data,path);
    
     if(root.left == null && root.right == null && root.data == k){
        System.out.println(path);
    }

}

public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
    //Your code goes here
    String path = "";

    helper(root,k,path);
}

}