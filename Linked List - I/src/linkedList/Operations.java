/**
 * 
 */
package linkedList;

import java.util.Scanner;

public class Operations {

	
	public  int length(LinkedListNode<Integer> head){
        int len = 0;
        
        while(head != null && head.data != -1){
            len++;
            head = head.next;
        }
        return len;
	}
	
	// Take input from user
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


	 // Print the data
	 public  void print(LinkedListNode<Integer> head){

		 LinkedListNode<Integer> temp = head;
	      while(temp!= null ){
	        System.out.print(temp.data+" ");
	        temp=temp.next;
	      }
	      System.out.println();
	 }
	 
	 
	 // insert at particular position
	 public  void insertNode(LinkedListNode<Integer> head, int elem, int pos){

		  LinkedListNode<Integer> nodeToBeInserted= new LinkedListNode<Integer>(elem);

	    if(pos==0){
	      nodeToBeInserted.next= head;
	      head= nodeToBeInserted;
	    }else{
	        int count=0;
	        LinkedListNode<Integer> prev= head;
	        while(count<pos-1 && prev!=null){
	          count++;
	          prev=prev.next;
	        }
	        if(prev!=null){
	            nodeToBeInserted.next= prev.next;
	            prev.next= nodeToBeInserted;
	        }
	    }
	    System.out.println("Node "+elem +" Insertion successfull at location "+pos+".................");
	  }
	 
	 public  LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
	        if (pos < 0 || head == null)
	        {
	            return head;
	        }
	        //at 0th pos --> change the pointer of head to the next node
	        else if(pos == 0){
	            head = head.next;
	        }
	        else{
	            LinkedListNode<Integer> prev=head;
	            // at start :- head is at 0th pos
	            for(int i=0;i<pos-1 && prev != null;i++){
	                prev = prev.next;  //prev is pointing to the (pos-1)th node
	            }

	            if(prev != null && prev.next != null){
	                if (prev.next != null)
	                {
	                    prev.next=prev.next.next;
	                }
	                else
	                {
	                    prev.next=null;
	                }
	            }


	        }
	        System.out.println("Node deleted Successfully");
	        return head;
	    }
	 
	 public  int findNode(LinkedListNode<Integer> head, int n) {
			// Write your code here.
	        int pos = 0;
	        while(head != null ){
	        
	            if(head.data == n)
	                return pos;
	            
	            head = head.next;
	            pos ++;
	        }
	        return -1;
		}
	 
	

	
}
