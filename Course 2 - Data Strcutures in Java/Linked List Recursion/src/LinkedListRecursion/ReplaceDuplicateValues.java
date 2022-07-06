package LinkedListRecursion;



/******** 
Following is the structure of Linked list node
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}
*********/
import java.util.*;
public class ReplaceDuplicateValues {

    public static int maximumValue(LinkedListNode<Integer> head){
        if(head == null)
            return -1;

        if(head.next == null){
            return head.data;
        }

        int max = -1;
        while(head!=null){
            if(head.data > max){
                max = head.data;
            }
            head = head.next;
        }
        return max;
    }

    public static void changeLL(LinkedListNode<Integer> head) {
        // Write your code here

        if(head.next == null)
            return;

        int max = maximumValue(head);

         HashMap<Integer,Integer> map = new HashMap<>();
        
        while(head!=null){
            if(!map.containsKey(head.data)){
                map.put(head.data,1);
            }
            else{
                max++;
                head.data = max;
               
            }
            head = head.next;
        }
    }
}