package Test6;
import java.util.*;





class ImplemetBrowserHistory {

    // Using Doubly LL Approach
    public class Node{
        Node prev;
        Node next;
        String url;
        Node(String url){
            this.url = url;

        }
    }
    Node curr;

    public ImplemetBrowserHistory(String homepage) {
        Node node = new Node(homepage);
        curr = node;
    }

    public void visit(String url) {
        // Creating node
        Node newNode = new Node(url);

        // attaching current node with the new node and it will delete all the forward history connection  
        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;
    }

    public String back(int steps) {
        // going back till steps > 0
        while(curr.prev != null && steps-->0){
            curr = curr.prev;
        }
        return curr.url;
    }

    public String forward(int steps) {
        // going forward till steps > 0
        while(curr.next != null && steps-- >0){
            curr = curr.next;
        }
        return curr.url;
    }
}


 class Runner {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String input = scn.next();

		ImplemetBrowserHistory obj = new ImplemetBrowserHistory (input);

		//int choice = scn.nextInt();

		int i = scn.nextInt();
		
		while(true){
			switch(i){
            			case 1: input=scn.next();
                    			obj.visit(input);
                    			break;
            			case 2: int k = scn.nextInt();
                    			input=obj.back(k);
                    			System.out.println(input);
                    			break;
            			case 3: k = scn.nextInt();
                    			input=obj.forward(k);
                    			System.out.println(input);
                    			break;
            			default: return;
        		}
        		i = scn.nextInt();
		}
	}
}