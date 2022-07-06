package Test6;


import java.util.Scanner;
import java.util.*;

public class RottenOranges {

    // queue with time,rowindex,colindex
    static class Pair{
        int i;
        int j;
        int time;
        Pair(){
        }
        Pair(int i,int j,int time){
            this.i=i;
            this.j=j;
            this.time=time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        ArrayDeque<Pair>q=new ArrayDeque<>();

        // to count total 1
        int findone=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                // if we got 2, then add it to the queue.
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    // count total 1
                    findone ++;
                }
            }
        }

        int time=0;
        // direction array (left,right,top,below)
        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};

        // if size(q) >0 , then change adjacent fresh oranges to rotten ones
        while(q.size()>0){
            // remove the first inserted rotten oranges(2) 
            Pair rem=q.remove();
            // check the time of the rotten orange
            time = rem.time;

            // Loop 4 times, as we have 4 direction to cover
            for(int k=0;k<4;k++){

                int ni = rem.i + dir[k][0]; // row th index
                int nj = rem.j + dir[k][1]; // col index

                // check for validation and if the element is 1(fresh), then rotten it and add it to the queue
                // with incremented time by 1, then make the value 2 and decrement findone by 1
                if(ni >= 0 && ni < grid.length && nj >= 0 && nj<grid[0].length && grid[ni][nj] == 1){

                    q.add(new Pair(ni,nj,rem.time+1));
                    grid[ni][nj] = 2;
                    findone--;
                }
            }
        }

        // finalyly checking if all the fresh oranges has been converted to rotten ones, then returning the time
        // else returning -1, indicating that it is not possible to convert all the fresh ones to the rotten ones.
        if(findone == 0) return time;
        else return -1;
    }


    public static void main(String[] args) {
        /* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

        // Write your code here
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        
        int mat[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        int time = orangesRotting(mat);
        System.out.println(time);

    }

}