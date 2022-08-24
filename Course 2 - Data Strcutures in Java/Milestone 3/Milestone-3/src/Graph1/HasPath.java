package Graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class HasPath {

    public static boolean hasPath(int adjMatrix[][], int source,int destination){

        Queue<Integer> pendingVertices = new LinkedList<>(); 
        boolean visited[] = new boolean[adjMatrix. length]; 
        visited[source] = true; 
        pendingVertices.add(source);

        while(! pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll(); 
            // System.out.print(currentVertex +" "); 
            if(currentVertex == destination){
                return true;
            }
                for(int i = 0; i < adjMatrix.length; i++){ 
                    if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                        // i is unvisited neighbor of currentVertex 
                        pendingVertices.add(i); 
                        visited[i] = true;
                    }
                }
        }
        
        return false;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMatrix[][] = new int[n][n]; 

        for(int i = 0; i <e; i++){
            // taking input for vertices
            int v1 = s.nextInt(); 
            int v2 = s.nextInt(); 
            adjMatrix[v1][v2] = 1; 
            adjMatrix[v2][v1] = 1;
        }

        int source = s.nextInt(); 
        int dest = s.nextInt();

        System.out.println(hasPath(adjMatrix,source,dest));
    }

}