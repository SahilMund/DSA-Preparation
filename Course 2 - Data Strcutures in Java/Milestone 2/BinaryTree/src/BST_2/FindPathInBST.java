package BST_2;

import java.util.*;

import binaryTree_1.BinaryTreeNode;
public class FindPathInBST {

	 public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
	        /* Your class should be named Solution
			* Don't write main().
			* Don't read input, it is passed as function argument.
			* Return output and don't print it.
			* Taking input and printing output is handled automatically.
			*/
	        if(root == null)
	            return null;

	        if(root.data == data){
	            ArrayList<Integer> output = new ArrayList<Integer>();
	            output.add(data);
	            return output;
	        }

	        if( data < root.data ) {// search on left side 

	            ArrayList<Integer> leftPath = getPath(root.left,data);
	            if(leftPath != null){
	                leftPath.add(root.data);
	                return leftPath;
	            }

	        }else{

	            ArrayList<Integer> rightPath = getPath(root.right,data);
	            if(rightPath != null){
	                rightPath.add(root.data);
	                return rightPath;
	            }

	        }
	        return null;
	 }
}
