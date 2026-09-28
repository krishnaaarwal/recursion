package BackTracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();

        boolean[][] matrix = {
                {true,  true,  true,  true},
                {true,  false, true,  true},
                {true,  true,  false, true},
                {true,  true,  true,  true}
        };

        mazeWithLoop(0, 0, "", ans, matrix);

        System.out.println(ans);

        ans.clear();

        mazeWithoutLoop(0, 0, "", ans, matrix);

        System.out.println(ans);
    }

    //Maze with Obstacles (But Loop is used for remaining paths)
    static ArrayList<String> mazeWithLoop(int row, int col, String processed, ArrayList<String> ans,boolean[][] matrix){
        //False means obstacles

        if (row == matrix.length-1) {
            for (int i = row + 1; i < matrix.length; i++) {
                if(matrix[row][i]){
                    processed += "R";
                }else{
                    processed = "";
                    break;
                }
            }
            if(!processed.equals("")){
                ans.add(processed);
            }

            return ans;
        }

        if (col == matrix.length-1) {
            for (int i = col + 1; i < matrix[0].length; i++) {
                if(matrix[i][col]){
                    processed += "B";
                }else{
                    processed = "";
                    break;
                }

            }
            if(!processed.equals("")){
                ans.add(processed);
            }

            return ans;

        }

        //Going down
        if(matrix[row+1][col]){
            mazeWithLoop(row+1,col,processed+"B",ans,matrix);
        }


        //Going Right
        if(matrix[row][col+1]){
            mazeWithLoop(row,col+1,processed+"R",ans,matrix);
        }

        return ans;
    }

    static ArrayList<String> mazeWithoutLoop(int row, int col, String processed, ArrayList<String> ans,boolean[][] matrix){
        //False means obstacles

        if (row == matrix.length-1 && col == matrix.length-1) {
            ans.add(processed);
            return ans;
        }


        //Going down
        if( row+1 <matrix.length && matrix[row+1][col]){
            mazeWithoutLoop(row+1,col,processed+"B",ans,matrix);
        }

        //Going Right
        if(col+1 < matrix[0].length && matrix[row][col+1]){
            mazeWithoutLoop(row,col+1,processed+"R",ans,matrix);
        }

        return ans;
    }
}