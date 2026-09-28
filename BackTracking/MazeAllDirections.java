package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeAllDirections {
    public static void main(String[] args) {
//        ArrayList<String> ans = new ArrayList<>();
//
        boolean[][] matrix = {
                {true,  true,  true},
                {true,  true,  true},
                {true,  true,  true},
        };
//
//        maze(0, 0, "", ans, matrix);
//        System.out.println(ans);

        int[][] path = new int[matrix.length][matrix[0].length];
        mazeAllPath(0, 0, "",matrix,path,1);
    }

    static ArrayList<String> maze(int row, int col, String processed, ArrayList<String> ans,boolean[][] matrix){
        //False means obstacles
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            ans.add(processed);
            return ans;
        }

        matrix[row][col] = false;

        //Going down
        if( row+1 <matrix.length && matrix[row+1][col]){
            maze(row+1,col,processed+"B",ans,matrix);
        }

        //Going Right
        if(col+1 < matrix[0].length && matrix[row][col+1]){
            maze(row,col+1,processed+"R",ans,matrix);
        }

        //Going Up
        if(row > 0 && matrix[row-1][col]) {
            maze(row - 1, col, processed + "U", ans,matrix);
        }

        //Going Left
        if(col > 0 && matrix[row][col-1]) {
            maze(row, col - 1, processed + "L", ans,matrix);
        }

        //This line is where the function will be over
        //so before function removes, also removes
        //the changes that were made by that function.
        matrix[row][col] = true;

        return ans;
    }

    static void mazeAllPath(int row, int col, String processed,boolean[][] matrix,int[][] path,int step){
        //False means obstacles
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            path[row][col] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }

        matrix[row][col] = false;
        path[row][col] = step;

        //Going down
        if( row+1 <matrix.length && matrix[row+1][col]){
            mazeAllPath(row+1,col,processed+"B",matrix,path,step+1);
        }

        //Going Right
        if(col+1 < matrix[0].length && matrix[row][col+1]){
            mazeAllPath(row,col+1,processed+"R",matrix,path,step+1);
        }

        //Going Up
        if(row > 0 && matrix[row-1][col]) {
            mazeAllPath(row - 1, col, processed + "U",matrix,path,step+1);
        }

        //Going Left
        if(col > 0 && matrix[row][col-1]) {
            mazeAllPath(row, col - 1, processed + "L",matrix,path,step+1);
        }

       // Important Point - You don't need to step -1, because it will be already minus for that function call, right?
        // ont the other hand, path which is array will use same reference and original object will be modified,
        // hence you need to retrieve that changes. You dont need to do it for step (integer).
        matrix[row][col] = true;
        path[row][col] = 0;

    }

}
