package BackTracking;

import java.util.ArrayList;

public class MazeAllDirections {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();

        boolean[][] matrix = {
                {true,  true,  true},
                {true,  true,  true},
                {true,  true,  true},
        };

        maze(0, 0, "", ans, matrix);

        System.out.println(ans);
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

}
