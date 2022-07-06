package Test6;


/*Linked List Node Class
*/
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MultiplyTwoLL {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        if(head == null || head.next == null)return head;

        LinkedListNode<Integer> prev =null;
        LinkedListNode<Integer> curr =head;

        while(curr!= null){
            LinkedListNode<Integer> fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    public static LinkedListNode<Integer> multiplywithdigit(LinkedListNode<Integer> head,int dig){

        // head :- 5 -> 4 -> 3->2-> 1 , dig = 3
        LinkedListNode<Integer> ansHead = new LinkedListNode<>(-1);
        LinkedListNode<Integer> ans = ansHead;
        int carry=0;
        while(head!=null || carry!=0){

            int sum = carry +(head!=null ? head.data:0)*dig;  
            int digit = sum%10;  
            carry =sum/10;

            ans.next = new LinkedListNode<Integer>(digit);
            if(head != null)head=head.next;

            ans = ans.next;
        }
        return ansHead.next;
    }

    public static void addtwovalues(LinkedListNode<Integer> head, LinkedListNode<Integer> ans_itr){

        LinkedListNode<Integer> c1 = head;
        LinkedListNode<Integer> c2 =ans_itr;

        int carry =0;
        while(c1!=null || carry!=0){
            int sum = carry  
                + (c1 != null ? c1.data : 0) 
                + (c2.next != null ? c2.next.data : 0);
            
            int digit = sum%10;
            carry = sum/10;
            
            if(c2.next!=null)
                c2.next.data = digit;
            else
                c2.next = new LinkedListNode<Integer>(digit);
            
            if(c1 != null)
                c1 = c1.next;
            
            c2 = c2.next;
        }
    }

    public static void print(LinkedListNode<Integer> head){
        if(head == null)return ;
        while(head !=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }


    public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here

        // 1. reversing  both LL as the multiplication operation will start from last index
        head1 = reverse(head1);
        head2 = reverse(head2);

        // 2. Creating some dummy variables and one dummy node
        LinkedListNode<Integer> head2_itr = head2;
        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        LinkedListNode<Integer> ans_itr = dummy;

        // 3. Iterating through head2 and calling multiplywithdigit () method
        while(head2_itr!= null){
            // iterating the data of 2nd LL and multiplying it with  all the data of head1
            LinkedListNode<Integer> prod = multiplywithdigit(head1,head2_itr.data);

            // after getting the multiplied 1 row, let's add them
            addtwovalues(prod,ans_itr);

            // going to the next element of head2 and ans_itr
            head2_itr = head2_itr.next;
            ans_itr = ans_itr.next;

        }

        // reverse the sum LL and then print it
        LinkedListNode<Integer> head =  reverse(dummy.next);

        print(head);
    }

}
