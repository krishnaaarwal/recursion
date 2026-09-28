package BackTracking;

import java.util.ArrayList;

public class MazeDiagonal {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        maze(3,4,"",ans);
        System.out.println(ans);
    }

    //Paths to reach - (Arraylist in args)
    static ArrayList<String> maze(int row, int col, String processed, ArrayList<String> ans){
        if (row == 1) {
            for (int i = 1; i < col; i++) {
                processed += "R";
            }
            ans.add(processed);
            return ans;
        }

        if (col == 1) {
            for (int i = 1; i < row; i++) {
                processed += "B";
            }
            ans.add(processed);
            return ans;
        }

        //Going down
        maze(row-1,col,processed+"B",ans);

        //Going Right
        maze(row,col-1,processed+"R",ans);

        //Going Diagonal
        maze(row-1,col-1,processed+"D",ans);

        return ans;
    }
}
