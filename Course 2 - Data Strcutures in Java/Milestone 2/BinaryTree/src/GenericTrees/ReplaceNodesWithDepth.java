package GenericTrees;


public class ReplaceNodesWithDepth {

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
    
    public static void replaceWithDepthValueHelper(TreeNode<Integer> root,int depth){
        root.data=depth++;
        
        
        for(TreeNode<Integer> child:root.children){
            replaceWithDepthValueHelper(child,depth);
        }
    }
	
	public static void replaceWithDepthValue(TreeNode<Integer> root){

		// Write your code here
        replaceWithDepthValueHelper(root,0);
        
		
	}
	
	
}
