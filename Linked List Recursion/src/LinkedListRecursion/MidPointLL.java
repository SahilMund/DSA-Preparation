package LinkedListRecursion;

public class MidPointLL {

	 public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {

	        //Your code goes here

	        //         LinkedListNode<Integer> fast = head,slow = head;

	        //         return midPointRec(head,fast,slow);

	        if (head==null || head.next==null)
	        {
	            return head;
	        }
	        LinkedListNode<Integer> fast=head,slow=head;

	        while(fast.next!=null && fast.next.next!=null)
	        {
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        return slow;

	    }
	 

//	    public static LinkedListNode<Integer> midPointRec(LinkedListNode<Integer> head,LinkedListNode<Integer> fast,
//	                                                      LinkedListNode<Integer> slow) {
//	        //Your code goes here
//
//	        if (head==null || head.next == null)
//	        {
//	            return head;
//	        }
//
//	        LinkedListNode<Integer> newSlow = midPointRec(head,fast.next.next,slow.next);
//
//	        if( fast.next == null || fast.next.next == null)
//	            return slow;
//
//	        //System.out.println(newSlow.data + "--------");
//	        return newSlow;
//
//	    }
}
