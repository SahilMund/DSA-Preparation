package binaryTree_2;

import binaryTree_1.BinaryTreeNode;

/*
Steps:- (This is only applicable if all the data nodes of Binary Tree are unique)

1. Find the root node (the first element of preorder i.e. preorder[startIndex])

2. Find inorder of both left and right subtree:-
	i)Search for root in inorder , as inorder is(left -> root -> right)
    ii)Left part of root in inorder is, inorder of left subtree (left inorder)
    iii)right part of root in inorder is, inorder of right subtree (right inorder)

3. Find preorder of both left and right subtree:-
	i) from step-2, we knew the number of nodes in present in left inorder,
    so we can find out the left preorder , which will be prorder[1, len(leftinorder)-1] 
    [as preorder 0th element is root node, so coniderint it from 1st index]
    ii) right preorder =  preorder[len(leftinorder),len(prorder-1)]

4. Use recursion to build left and right subtree:-
	i) left_subtree = buildTree(leftpreorder,leftinorder);
    ii) right_subtree = buildTree(rightpreorder,rightinorder);

5. Connect root with both left and right subtree:-
	a) root.left = left_subtree
    b) root.right = right_subtree

*/
public class buildTreeusingInorder_Preorder {


	public static BinaryTreeNode<Integer> buildTreeHelper(int[] pre, int[] in, int siPre, int eiPre,
			int siIn, int eiIn) {
		
		if(siPre > eiPre) {
			return null;
		}
		int rootData = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        

        int rootInorderIndex = -1;
        
        for(int i = siIn;i<= eiIn;i++) {
        	
        	if( in[i] == rootData) {
	        	rootInorderIndex = i;
	        	break;
        	}
        }
        
        // I am assuming the root is exists in  inorder
        // for left subtrees
        int siPreLeft = siPre + 1; // first element is root, so index will be siPre+1
        int siInLeft = siIn;
        int eiPreLeft ;
        int eiInLeft = rootInorderIndex -1;
        
        // for right subtrees
        int siPreRight ;
        int siInRight = rootInorderIndex +1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;
        
        int leftSubtreeLength = eiInLeft - siInLeft +1;
        eiPreLeft = siPreLeft + leftSubtreeLength - 1;
        siPreRight = eiPreLeft + 1;
        // InOrder (left,root,right)
        // PreOrder (root,left,right)
        
        BinaryTreeNode<Integer> leftSubtree  = buildTreeHelper(pre,in,siPreLeft,eiPreLeft,siInLeft,eiInLeft);
        BinaryTreeNode<Integer> rightSubtree  = buildTreeHelper(pre,in,siPreRight,eiPreRight,siInRight,eiInRight);

        
       
        root.left = leftSubtree;
        root.right = rightSubtree;


		return root;
		
	}
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		
		BinaryTreeNode<Integer> root = buildTreeHelper(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
		return  root;
	}
	
	public static void main() {
		int[] in = {1, 2, 4 ,5, 3, 6, 7 };
		int[] pre = {4, 2, 5, 1, 6, 3, 7};
		
		BinaryTreeNode<Integer> root = buildTree(pre,in);
	}
	
}
