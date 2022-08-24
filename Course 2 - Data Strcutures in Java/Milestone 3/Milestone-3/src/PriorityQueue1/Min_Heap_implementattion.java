package PriorityQueue1;
import java.util.ArrayList;

public class Min_Heap_implementattion<T> {

	private ArrayList<HeapElement<T>> heap;

	public Min_Heap_implementattion(){
		heap= new ArrayList<>();
	}

	public void insert(T value, int priority){

		HeapElement<T> e= new HeapElement<> (value, priority);
		heap.add(e);

		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;

		while(childIndex>0){
			// Up-Heapify process
			if(heap.get(childIndex).priority < heap.get(parentIndex).priority){

				// swapping both child and parent index
				HeapElement<T> temp= heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);

				//and then we will repaet this process till the 0th index
				childIndex = parentIndex;
				parentIndex= (childIndex-1)/2;
			}else{
				return;
			}
		}

	}

	public T removeMin() {

		HeapElement<T> removeElement = heap.get(0);
		T ans = removeElement.value;

		HeapElement<T> lastElement = heap.get(size()-1);
		heap.set(0, lastElement);

		heap.remove(size()-1);

		int parentIndex=0;
		int leftChildIndex= 2*parentIndex+1;
		int rightChildIndex= 2*parentIndex +2;



		// re-Heap after removal
		while(leftChildIndex < size()){

			// down-heapify
			int minIndex= parentIndex;
			// finding minindex as per priority between parent,left child and right child
			if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
				minIndex= leftChildIndex;
			}



			if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority){
				minIndex= rightChildIndex;
			}

			// if we found the current position, then just break the loop
			if(minIndex == parentIndex)
			{
				return ans;
			}
			//swap the minindex with parentindex
			HeapElement<T> temp= heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);


			parentIndex = minIndex;
			leftChildIndex= 2*parentIndex + 1;
			rightChildIndex= 2*parentIndex + 2;
		}
		return ans;
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public T getMin() {
		// if(isEmpty()) {
		//throw exception
		//    	}

		return heap.get(0).value;

	}

}
