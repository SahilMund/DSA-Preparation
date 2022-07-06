package LinkedListRecursion;





public class NextNumber {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        if(head.next == null)
            return head;

        LinkedListNode<Integer> prev = null,curr = head;
        
        while(curr != null) {
            LinkedListNode<Integer> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static LinkedListNode<Integer> addone(LinkedListNode<Integer> head){
        LinkedListNode<Integer> temp = null,res = head;
        int carry = 1, sum;
        while(head!=null){
            sum = carry + head.data;
            carry = (sum >= 10) ? 1 : 0;
            sum =sum % 10;
            head.data = sum;
            temp =head;
            head =head.next;
        }
        if(carry>0){
            // if new node needs to be added for carry 
            LinkedListNode<Integer> newnode = new LinkedListNode<Integer>(carry);
            temp.next = newnode;
        }
        return res;

    }

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> tail = head;

        if(head.next == null){
            head.data++;
            return head;
        }

        //         while(tail.next != null){
        //             tail = tail.next;
        //         }

        //         if(tail.data != 9){
        //             tail.data++;
        //         }else{
        //             head  = reverse(head);
        //             head =  addone(head);
        //             return reverse(head);
        //         }

        //         return head;

        head  = reverse(head);
        head =  addone(head);
        return reverse(head);


    }


}
