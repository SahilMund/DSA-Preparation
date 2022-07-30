package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

//1. If the max distant leaf nodes are present in only left side ->left diameter
//2. If the max distant leaf nodes are present in only right side -> right diameter
//3. If the max distant leaf nodes are present in one on left and another is on right side -> left height + right height

// Time complexity =  O(n) and space complexity = O(H), where n =  number of nodes and h = height of the tree

class ResultsPair{
 int height;
 int diameter;
 
 public ResultsPair(int height,int diameter){
     this.height = height;
     this.diameter = diameter;
 }
}

public class DiameterOfATreeBetter {

	public static ResultsPair diameter(BinaryTreeNode<Integer> root){
		//We are handling the root node and left and right node will be automatically handled by 0
     if(root == null){
         return new ResultsPair(0,0); // both height and diameter is  0
     }
     
     ResultsPair leftPair  =  diameter(root.left);
     ResultsPair rightPair =  diameter(root.right);
     
     int currentNodediameter = leftPair.height + rightPair.height + 1 ; 
     
     int height = 1 + Math.max(leftPair.height , rightPair.height);
     
     // overall diameter will be the max diameter of current node, left subtree diameter and right subtree diameter 
     int diameter =  Math.max(currentNodediameter , Math.max(leftPair.diameter,rightPair.diameter));
     
     return new ResultsPair(height,diameter);
     
	}
 
 public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
     
	 ResultsPair ans = diameter(root);
     return ans.diameter;
 }
	
}
