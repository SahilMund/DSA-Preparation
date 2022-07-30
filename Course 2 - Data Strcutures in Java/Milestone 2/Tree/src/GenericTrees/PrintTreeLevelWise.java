package GenericTrees;

import java.util.*;
public class PrintTreeLevelWise {

class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}
	
	
	
	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
        
		
        if(root==null){
            return;
        }
        
        Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            
            TreeNode<Integer> front = q.poll();
            
            if(front==null) continue;
            
            System.out.print(front.data+" ");
     
            for(TreeNode<Integer> child:front.children){
                q.add(child);
            }

            
            if(q.peek()==null){
                q.add(q.poll());
                System.out.println();      
            } 
        }
        

	

	}
		
}
