package queue;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		
		QueueUsingArray queue = new QueueUsingArray(3);
		
		int arr[] = {10,20,30,40,50};
		
		for(int elem :arr) {
			queue.enqueue(elem);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}

	}

}

