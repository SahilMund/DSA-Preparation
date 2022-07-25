package GenericTrees;

public class CountLeafNodes {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
	public static int countLeafNodes(TreeNode<Integer> root){

		// A leaf node is a node, which has no children
        if(root.children.isEmpty()){
            return 1;
        }
        int count=0;
        
        for(TreeNode<Integer> child:root.children){
            count+= countLeafNodes(child);
            
        }
        
        
        return count;

	}
	
}
