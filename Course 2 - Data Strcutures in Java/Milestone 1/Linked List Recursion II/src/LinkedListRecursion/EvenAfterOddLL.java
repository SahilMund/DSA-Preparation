package LinkedListRecursion;

public class EvenAfterOddLL {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        //Your code goes here
        if (head==null || head.next==null)
        {
            return head;
        }
        
        LinkedListNode<Integer> node=head,evenNode=null,oddNode=null,oddHead=null,evenHead=null;
        
        while(node!=null)
        {            
       		//if even
            if (node.data % 2 == 0)
            {
                if (evenNode==null)
                {
                    //Adding first node
                    evenNode=node;
                    evenHead=node;
                }
                else
                {
                    evenNode.next=node;
                    evenNode=evenNode.next;
                }

            }
            else  // if odd
            {
                if (oddNode==null)
                {
                    //Adding first node
                    oddNode=node;
                    oddHead=node;
                }
                else
                {
                    oddNode.next=node;
                    oddNode=oddNode.next;
                }
            }

            node=node.next;
        }
       
        
        if (oddHead == null)
        {
            return evenHead;
        }
        else // linking odd node with even node
        {
            oddNode.next=evenHead;
        }

        if (evenNode!=null)
        {
            evenNode.next=null;
        }


        return oddHead;
    }
}
