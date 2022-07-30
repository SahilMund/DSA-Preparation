package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

public class buildTreeUsingInorder_PostOrder {

    public static BinaryTreeNode<Integer> buildTreeHelper (int post[],int in[],int siPost,int eiPost,int siIn,int eiIn){
    
		if(siPost > eiPost)
		    return null;
    
		int rootdata = post[eiPost]; // as we are starting from right to left
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		
		int rootInorderIndex = -1;
		
		for(int i=siIn;i<=eiIn;i++){
		    if(in[i] == rootdata){
		        rootInorderIndex = i;
		        break;
		    }
		}

		int siPostleft = siPost; 
		int siInleft  = siIn;
		int eiInleft  = rootInorderIndex - 1;
		int eiPostright = eiPost-1;
		int siInright = rootInorderIndex + 1;
		int eiInright = eiIn;
		
		int lengthOfLeftInorderNodes = eiInleft - siInleft +1;
		
		int eiPostleft = siPostleft + lengthOfLeftInorderNodes -1;
		int siPostright = eiPostleft +1;

		 // InOrder (left,root,right)
		// PostOrder (left,right,root)
		BinaryTreeNode<Integer> leftSubtree = buildTreeHelper(post,in,siPostleft,eiPostleft,siInleft,eiInleft);
		BinaryTreeNode<Integer> rightSubtree = buildTreeHelper(post,in,siPostright,eiPostright,siInright,eiInright);
		
		root.left = leftSubtree;
		root.right = rightSubtree;
		    
		return root;

}




	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
	//Your code goes here
		BinaryTreeNode<Integer> root = buildTreeHelper(postOrder,inOrder,0,postOrder.length-1,0,inOrder.length-1);
		return  root;
	}
		
}
