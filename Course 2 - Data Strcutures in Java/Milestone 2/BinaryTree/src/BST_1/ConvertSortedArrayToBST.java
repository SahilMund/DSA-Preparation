package BST_1;

import binaryTree_1.BinaryTreeNode;

public class ConvertSortedArrayToBST {

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return SortedArrayToBSTHelper(arr,0,n-1);

    }

    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int si, int ei){
        
        // base case
        if (si>ei)
            return null;

        // 1. Take middle element and create root node
        int mid=(si+ei)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);

        // 2. Call recursively for left subtree[left elements of mid eleemnt] and right subtree[right elements of mid element]
        root.left=SortedArrayToBSTHelper(arr,si,mid-1);
        root.right=SortedArrayToBSTHelper(arr,mid+1,ei);
        
        return root;

}
}