package LinkedListRecursion;

public class MergeTwoSortedList {

	
	  public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
	        //Your code goes here

	        if (head1==null) // if first list is null, return second list's head
	        {
	            return head2;
	        }

	        if (head2==null) // if second list is null, return first list's head
	        {
	            return head1;
	        }

	        LinkedListNode<Integer> t1 = head1 , t2 = head2;
	        // we need two pointer head and tail as we have to add the nodes at the last , for which tail is required
	        LinkedListNode<Integer> head = null , tail = null;

	        if (t1.data <= t2.data) //checking which value is smaller between two lists and making it head
	        {
	            head = t1;
	            tail = t1;
	            t1 = t1.next;
	        }
	        else
	        {
	            head = t2;
	            tail = t2;
	            t2 = t2.next;
	        }

	        while(t1 != null && t2 != null)
	        {
	            if (t1.data <= t2.data)
	            {
	                tail.next = t1;
	                tail = t1;
	                t1 = t1.next;
	            }
	            else
	            {
	                tail.next = t2;
	                tail = t2;
	                t2 = t2.next;
	            }
	        }

	        // if second list values are added then tail should point to the next node of the first list 
	        if(t1 != null)
	        {
	            tail.next = t1;
	        }
	        
	        if (t2 != null)
	        {
	            tail.next = t2;
	        }
	        
	        return head;
	}

}
