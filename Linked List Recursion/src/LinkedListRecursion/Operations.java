package LinkedListRecursion;

import java.util.Scanner;



public class Operations {
	
	 public  LinkedListNode<Integer> takeInput(){
	        Scanner s= new Scanner(System.in);
	        int data = s.nextInt();
	        LinkedListNode<Integer> head = null,tail=null;
	        while(data != -1){
	        	LinkedListNode<Integer> currentNode= new LinkedListNode<>(data);
	          if(head==null){
	            head=currentNode;
	            tail=currentNode;
	          }else{
	        tail.next = currentNode;
	        tail=currentNode;    //tail=tail.next;
	    }
	    data= s.nextInt();
	    }
	       
	        return head;

	  }


	
	public void printRecursively(LinkedListNode<Integer> head) {
		if(head == null )
			return;
		
		System.out.print(head.data + " -> ");
		
		printRecursively(head.next);
		
	}
	
	public void printAlternates(LinkedListNode<Integer> head) {
		if(head == null )
			return;
		
		System.out.print(head.data +" ");
		
		if(head.next != null)
			printAlternates(head.next.next);
		
	}
	
	public void printReverseRecursively(LinkedListNode<Integer> head) {
		if(head == null)
			return;
				
		printReverseRecursively(head.next);
		
		System.out.print(head.data + " -> ");

	}

	public LinkedListNode<Integer> insertNodeRecurively(LinkedListNode<Integer> head,int data, int pos){
		
		  LinkedListNode<Integer> nodeToBeInserted= new LinkedListNode<Integer>(data);
		  
		  if(head == null && pos > 0) // pos>0 is used as we want to insert the node, if the list is empty
			  return head;
		  
		  if(pos == 0) {
			  nodeToBeInserted.next = head;
			  return nodeToBeInserted;
		  }
		  else {
			  LinkedListNode<Integer> smallHead = insertNodeRecurively(head.next,data,pos-1);
			  head.next = smallHead;
			  return head;
		  }
		
	}
	
	public  LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        //Your code goes here
		
        if (head == null)
        {
            return head;
        }

        if (pos==0)
        {
            head=head.next;
            return head;
        }
        else
        {
            LinkedListNode<Integer> smallerHead = deleteNodeRec(head.next,pos-1);
            head.next=smallerHead; //make connection with first node 
            return head;
        }  
}

}
