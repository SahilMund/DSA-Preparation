package LinkedListRecursion;

public class ReverseLinkedListRec {

	
	 public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {

		 // T(n) = O(n)
	        if(head == null || head.next == null)
	            return head;

	        LinkedListNode<Integer> revHead = reverseLinkedListRec(head.next);

	        // 4 -> 5-> 7->8 -> 3 -> ->NULL
	        // To reverse the connection(making connection from 5->7 to 7->5  )
	        // head (5) , head.next(7) , head.next(7).next = head(5) --> now next of 7 will point to 5  
	        head.next.next = head;
	        head.next = null;

	        return revHead;
	    }
}
