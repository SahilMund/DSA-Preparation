package linkedList;

public class AppendLastNToFirst {

	
	 public  LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
	        //Your code goes here
	        LinkedListNode<Integer> node=head,checkNode=null,newHead=null;

	        if (n==0)
	        {
	            return head;
	        }

	        int count=0;

	        while(node!=null)
	        {
	            node=node.next;
	            count=count+1;
	        }
	        
	        //System.out.println(count);
	        if (count<n)
	        {
	            return head;
	        }

	        n=count-n;
	        node=head;

	        for (int i=0;i<n-1;i++)
	        {
	            node=node.next;
	        }
	        checkNode=node.next;
	        node.next=null;
	        newHead=checkNode;
	        //System.out.println("Shifting from element: "+checkNode.data);
	        //System.out.println("Now last element is: "+node.data);
	        //System.out.println("Now first element is: "+newHead.data);
	        while(checkNode.next!=null)
	        {
	            checkNode=checkNode.next;
	        }
	        checkNode.next=head;
	        head=newHead;
	        return head;



	    }
}
