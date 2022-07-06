package Test6;



/***********

Following is the Linked list node structure already written 



************/
class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
		 this.data=data;
	 }
}

public class MoveToLast {


    public static Node<Integer> func(Node<Integer> head,int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        Node<Integer> tail = head;

        while(tail.next!=null){
            tail =tail.next;
        }

        Node<Integer> last = tail;

        while(temp!=last){
            if(temp.data !=n){
                prev = temp;
                temp = temp.next;
            }
            else{
                if(prev == null){
                // if the head element needs to be shifted
                    Node<Integer> fwd = temp.next;
                    tail.next = temp;
                    temp.next = null;
                    tail =tail.next;
                    head = fwd;
                    temp = fwd;
                }else{
                    Node<Integer> fwd = temp.next;
                    prev.next = fwd;
                    tail.next = temp;
                    temp.next =null;
                    tail =tail.next;
                    temp = fwd;
                }
            }
        }
        return head;



    }

}

