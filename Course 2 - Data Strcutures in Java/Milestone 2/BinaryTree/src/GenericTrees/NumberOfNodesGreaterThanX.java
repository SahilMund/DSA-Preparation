package GenericTrees;


public class NumberOfNodesGreaterThanX {

/*	TreeNode class 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

	
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root==null){
            return 0;
        }	
        int count=0;
        for(TreeNode<Integer> child:root.children){
            
            count+=numNodeGreater(child,x);
        }
        
        if(root.data>x){
            count+=1;
        }
        
        return count;

	}
	
}
