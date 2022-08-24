package Graph1;
import java.util.*;


public class BFS_DFS_DisconnectedGraph {

	//DFT Traversal for disconnected Graph
	public static void dftraversal(int adjMatrix[][], int currentVertex, boolean visited[]){
		visited[currentVertex] = true; 
		System.out.print(currentVertex + " "); 
		for(int i = 0; i < adjMatrix.length; i++){ 
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbor of currentVertex 
				dftraversal(adjMatrix, i, visited);
			}
		}
	}


	public static void dftraversal(int adjMatrix[][]){
		boolean visited[]= new boolean[adjMatrix. length];
		for(int i=0;i<adjMatrix.length;i++) {
			if(!visited[i]) {
				dftraversal(adjMatrix,i,visited);
				System.out.println();
			}
		}
	}


	//BFT Traversal for disconnected Graph

	//A print helper function to solve the print function issues
    public static void BftHelper(int adjMatrix[][], int sv,boolean visited[]){ 

        Queue<Integer> pendingVertices = new LinkedList<>(); 
        //here sv is the vertex passed to the print function
        visited[sv] = true; 
        pendingVertices.add(sv);

        while(!pendingVertices.isEmpty()){
            //here both poll and remove can be used, both remove and return the first element of the queue
            int currentVertex = pendingVertices.poll(); 
            System.out.print(currentVertex +" "); 
            for(int i = 0; i < adjMatrix.length; i++){ 
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    // i is unvisited neighbor of currentVertex 
                    //check for all neighbours of firstElement if they have an edge and are not visited put them in the queue

                    pendingVertices.add(i); 
                    visited[i] = true;
                }
            }
        }

    }


    // we have to deal with both connected and non connected
    public static void bfTraversal(int adjMatrix[][]){

        if(adjMatrix.length == 0)
            return;

        boolean visited[] = new boolean[adjMatrix.length]; //here adjMatrix.length is the number of vertices
        //here we loop through all the vertices if they are not visitied 
        //call the  helper function on it, to solve the problem of unconnected graphs

        for(int i=0; i< adjMatrix.length; i++){
            if(!visited[i]){
                BftHelper(adjMatrix, i, visited);   
            }
        }

    }


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		int n = s.nextInt(); 
		int e = s.nextInt(); 
		int adjMatrix[][] = new int[n][n]; 
		for(int i = 0; i <e; i++){
			int v1 = s.nextInt(); 
			int v2 = s.nextInt(); 
			adjMatrix[v1][v2] = 1; 
			adjMatrix[v2][v1] = 1;
		}
		//dftraversal(adjMatrix);
		bfTraversal(adjMatrix); 
		// for(int i = 0; i<n; i++){ 
		// for(int j = 0; j<n; j++){
		// System.out.print(adjMatrix[i][j] +" ");
		// }
		// System.out.println();
		// }
	}
}

