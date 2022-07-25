package GenericTrees;

import java.util.*;
public class StructurllayIdentical {

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
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		// Write your code here
         if(root1==null ||root2==null){
            return false;
        }
        Queue<TreeNode<Integer>> q1 = new LinkedList<TreeNode<Integer>>();
        Queue<TreeNode<Integer>> q2 = new LinkedList<TreeNode<Integer>>();
        
        q1.add(root1);
        q1.add(null);
        q2.add(root2);
        q2.add(null);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            
            TreeNode<Integer> front1 = q1.poll();
            TreeNode<Integer> front2 = q2.poll();
            
            if(front1==null && front2==null) continue;
            
            if((front1==null||front2==null)){
                return false;
            }
            
            if(front1.data!=front2.data){
                return false;
            } 
            for(TreeNode<Integer> child:front1.children){
                q1.add(child);
            }
            for(TreeNode<Integer> child:front2.children){
                q2.add(child);
            }
            
            if(q1.peek()==null&&q2.peek()==null){
                q1.add(q1.poll());
                q2.add(q2.poll());    
            }
            
        }
        return true;
        
	}
	
}
