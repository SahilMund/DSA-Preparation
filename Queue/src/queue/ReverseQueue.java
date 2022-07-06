package queue;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {


	public static void reverseQueue(Queue<Integer> input) {
		//Your code goes here
        if (input.size()==0 || input.size() == 1)
        {
            return;
        }
        
        int temp = input.remove();
        reverseQueue(input);        
        input.add(temp);
	}
	
	public static void main(String[] args)  {

		
			Queue<Integer> queue = new LinkedList<>();
			queue.add(10);
			queue.add(20);
			queue.add(30);
			reverseQueue(queue);

			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();
	}

}
