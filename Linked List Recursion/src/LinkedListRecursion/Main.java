package LinkedListRecursion;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Operations op = new Operations();
		System.out.println("Enter nodes to form a linked list :-");
		LinkedListNode<Integer> head = op.takeInput();
//		
//		System.out.println("Printing the Value :-");
//		op.printRecursively(head);
//		
//		System.out.println("Printing the alternate Value :-");
//		op.printAlternates(head);
//
//		System.out.println("Printing the Value Recursively :-");
//		op.printReverseRecursively(head);
//
//		
//		System.out.print("Enter the node you want to insert :");
//		int data = sc.nextInt();
//		System.out.print("Enter the location at which you want to insert the node :");
//		int pos = sc.nextInt();
//		
//		op.insertNodeRecurively(head, data, pos);
//		
//		System.out.println("Printing the Value :-");
//		op.printRecursively(head);
//		
//		int loc = sc.nextInt();
//		
//		op.deleteNodeRec(head, loc);
		

		// reverse
//		System.out.println("Making LinkedList reverse :- ");
//		LinkedListNode<Integer> newHead  = ReverseLinkedListRec.reverseLinkedListRec(head);
//		System.out.println("Printing the Value :-");
//		op.printRecursively(newHead);
//		
		
//		// Merge two sorted array
//		
//		System.out.println("Enter nodes for a first sorted linked list :-");
//		LinkedListNode<Integer> head1 = op.takeInput();
//		System.out.println("Enter nodes for a second sorted linked list :-");
//		LinkedListNode<Integer> head2 = op.takeInput();
//		LinkedListNode<Integer> mergedHead = MergeTwoSortedList.mergeTwoSortedLinkedLists(head1, head2);
//		System.out.println("Printing the Value :-");
//		op.printRecursively(mergedHead);
//		
//		
//		// merge sort
//		System.out.println("Enter nodes to sort a linked list :-");
//		LinkedListNode<Integer> newhead = op.takeInput();
//		MergeSortLnikedList.mergeSort(newhead);
		
//		// Find node using rec
//		System.out.println("Enter a number to search in LL :");
//		int n = sc.nextInt();
//		System.out.println(FindANodeInLLRec.findNodeRec(head, n));
		
		// Even after odd LL
		
		LinkedListNode<Integer> newHead = EvenAfterOddLL.evenAfterOdd(head);
		System.out.println("Printing the Value :-");
		op.printRecursively(newHead);
	}
	

}
