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



/*

Representation of the Pair Class



*/

class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class MinMaxNodeOfATree {


public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
    //Your code goes here

    if(root == null){
        Pair<Integer, Integer> ans = new Pair<Integer, Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);
        return ans;
    }
         
    
    Pair<Integer, Integer> leftPair =  getMinAndMax(root.left);
    Pair<Integer, Integer> rightPair = getMinAndMax(root.right);

    
    int max = Math.max(leftPair.maximum,rightPair.maximum);
    int min = Math.min(leftPair.minimum,rightPair.minimum);
    
    max = Math.max(max,root.data);
    min = Math.min(min,root.data);
    


    return new Pair<Integer, Integer> (min,max);

}

}