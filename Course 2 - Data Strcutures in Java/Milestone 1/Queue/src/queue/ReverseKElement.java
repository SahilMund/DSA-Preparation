package queue;
import java.util.Queue;

public class ReverseKElement {

	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) 
    {
		//Your code goes here
        if (input.size()>k)
        {
        	// to maintain the range of k from K to last element
            k = k % input.size();
            
        }
        if (k==0 || k==1)
        {
            return input;
        }
        
        reverseQueue(input,k);
        
        for (int i=0;i<input.size()-k;i++)
        {
            input.add(input.remove());
        }
        
        return input;
        
	}
    
    public static void reverseQueue(Queue<Integer> input, int k) 
    {
		//Your code goes here
        if (input.size()==0 || input.size()==1 || k==0)
        {
            return;
        }
        
        int temp=input.remove();
        reverseQueue(input,k-1);
        input.add(temp);
	}
}
