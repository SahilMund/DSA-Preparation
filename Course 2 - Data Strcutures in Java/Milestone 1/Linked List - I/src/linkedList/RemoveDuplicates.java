package linkedList;

public class RemoveDuplicates {

	 public  LinkedListNode<Integer> removeDuplicates (LinkedListNode<Integer> head) {

	        if(head == null || head.next == null)
	            return head;

	        LinkedListNode<Integer> nextNode=head.next,currNode=head;

	        while (nextNode != null)
	        {
	            if (!(nextNode.data).equals(currNode.data))
	            {
	                currNode.next=nextNode;
	                currNode=currNode.next;
	            }
	            nextNode=nextNode.next;
	        }
	        currNode.next=nextNode;


	        return head; 

	    }
}
