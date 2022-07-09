package LinkedListRecursion;

/*

Following is the Node class already written for the Linked List

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

*/

public class KReverse {

public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
    //Your code goes here

    if (head==null || head.next==null)
    {
        return head;
    }
    LinkedListNode<Integer> smallerHead=reverseLinkedListRec(head.next);
    LinkedListNode<Integer> node=smallerHead;
    while (node.next!=null)
    {
        node=node.next;
    }
    node.next=head;
    head.next=null;
    return smallerHead;
}

public static LinkedListNode<Integer> findTail(LinkedListNode<Integer> head, int k)
{
    for (int i=0;i<k && head.next!=null;i++)
    {
        head=head.next;
    }
    return head;


}

public static int findLength(LinkedListNode<Integer> head)
{
    int count=0;
    while(head.next!=null)
    {
        head=head.next;
        count=count+1;
    }
    return count;
}

public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
    //Your code goes here
    if (head==null || k==0 || k==1)
    {
        return head;
    }
    // if k is greater than the length ,then directly reverse the LL.
    else if (k > findLength(head))
    {
        return reverseLinkedListRec(head);
    }

    LinkedListNode<Integer> node=head,nextNode=null,tail=null,prevTail=null,newHead=null;
    while(node!=null)
    {
        tail = findTail(node,k-1);
        nextNode = tail.next;
        tail.next = null;
        newHead = reverseLinkedListRec(node);

        if (node == head)
        { // first node
            tail=head;
            tail.next=nextNode;
            head=newHead;

        }
        else
        {
            tail=node;
            tail.next=nextNode;
            prevTail.next=newHead;

        }
        node=nextNode;
        prevTail=tail;

    }
    return head;


}

}