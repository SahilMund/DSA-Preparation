package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

/*
 Now, we will divide preOrder and postOrder array in two parts. 
 One is for the left subtree and other is for the right subtree.

Let siPre: starting index for preorder array
    eiPre: ending index for preorder array
    siPost: starting index of postorder array
    eiPost: ending index of postorder array
    elementInLeftSubtree: Number of elements in the left subtree
    nextrootPostOrderIndex : the index of element next to root in the postOrder traversal

Clearly, elementInLeftSubtree = nextrootPostOrderIndex - siPost + 1;

For left subtree:
Preorder array: from index siPre + 1, siPre + elementInLeftSubtree
Postorder array: from index siPost, nextrootPostOrderIndex

For right subtree:
Preorder array: from index siPre + elementInLeftSubtree + 1, eiPre
Postorder array: from index nextrootPostOrderIndex + 1, eiPost -1


 Using the above arrays, all the steps are recursively repeated.
 
 
 Complexity:-
The time complexity of above approach is O(n^2). The worst case occurs in case of left skewed tree.
 */

public class buildTreeUsingPreOrder_PostOrder {

	
    public static BinaryTreeNode<Integer> buildTreeHelper(int post[],int pre[],int siPost,int eiPost,int siPre,int eiPre){
    
    	
    	// this case occurs when a node has only one child
			if(siPre > eiPre)
			    return null;
			    
			int rootdata = pre[siPre]; // as we are starting from right to left
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
			
			int nextrootPostOrderIndex = -1;
			
			//searching siPre+1(next element) in postOrder array
			//  to find the index of next value to the root in post order array
			for(int i = siPost; i<= eiPost; i++){
			    if(post[i] == pre[siPre+1]){
			    	nextrootPostOrderIndex = i;
			        break;
			    }
			}
			
			//Number of elements in left subtree
			int elementInLeftSubtree = nextrootPostOrderIndex - siPost +1;
			
			
			// PreOrder = [root,left,right]
			// PostOrder =  [left,right,root]
			
			// 1.Left Subtree
			// a. PostOrder:-
			
			int siPostleft = siPost; 
			int eiPostleft = nextrootPostOrderIndex;
			
			// b. PreOrder:-
			int siPreleft = siPre + 1 ;
			int eiPreleft = siPre + elementInLeftSubtree;
			
			// 2.right Subtree
			// a. PostOrder:-
			int siPostright = eiPostleft + 1;
			int eiPostright = eiPost - 1;
			
			//b. PreOrder:-
			int siPreright = eiPreleft + 1;
			int eiPreright = eiPre;

			


			BinaryTreeNode<Integer> leftSubtree = buildTreeHelper(post,pre,siPostleft,eiPostleft,siPreleft,eiPreleft);
			BinaryTreeNode<Integer> rightSubtree = buildTreeHelper(post,pre,siPostright,eiPostright,siPreright,eiPreright);
			
			root.left = leftSubtree;
			root.right = rightSubtree;
			    
			return root;
			
		}




		public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] preOrder) {
		//Your code goes here
		BinaryTreeNode<Integer> root = buildTreeHelper(postOrder,preOrder,0,postOrder.length-1,0,preOrder.length-1);
		return  root;
		}
}
