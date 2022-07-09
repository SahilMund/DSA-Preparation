package linkedList;
import java.util.*;

public class IsPalindrome {


    public  boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();
        
        // adding all the nodes to the arraylist
        while (node!=null)
        {
            arr.add(node.data);
            node=node.next;
        }
        
        int start=0, end=arr.size()-1;
        
        // by using two pointer approach , we are going to check if the LL is palindrome or not.
        while(start<end)
        {
            if (arr.get(start)!=arr.get(end))
            {
                return false;
            }
            else
            {
                start=start+1;
                end=end-1;
            }
        }

        return true;
    }

}

