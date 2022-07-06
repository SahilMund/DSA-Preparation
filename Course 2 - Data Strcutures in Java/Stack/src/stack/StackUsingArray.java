

package stack;

public class StackUsingArray{

    private int data[];
    private int topIndex;  //Index of the top most element of the stack

    public StackUsingArray(){
        data= new int[10];
        topIndex=-1;
    }

    public StackUsingArray(int size){
        data= new int[size];
        topIndex=-1;
    }

    public int size(){

    	return topIndex+1;
    }

    public boolean isEmpty(){

    	return topIndex == -1;

    }

    public void push(int elem) throws StackFullException{
    	
    	if(topIndex == data.length -1)
    		doubleCapcaity();
    		//throw new StackFullException();
    	
    	

    	topIndex++;
    	data[topIndex] = elem;
    	
    }

    private void doubleCapcaity() {
		// TODO Auto-generated method stub
    	int temp[] = data;
    	data = new int[temp.length * 2];

    	for(int i=1;i<temp.length;i++) {
    		data[i] = temp[i];
    	}
		
	}

	public int top() throws StackEmptyException{

    	if(topIndex == -1) {
    		throw new StackEmptyException();
    	}
    	return data[topIndex];
    		

    }

    public int pop() throws StackEmptyException{

    	if(topIndex == -1) {
    		throw new StackEmptyException();
    	}
    	
    	// returning the prev top element and then decrementing it by 1
    	return data[topIndex--];
    }


}
