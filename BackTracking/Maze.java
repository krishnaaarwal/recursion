package BackTracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(mazeCount(3,4));

        ArrayList<String> ans = new ArrayList<>();
        maze(3,4,"",ans);
        System.out.println(ans);

        System.out.println(maze(3,4,""));
    }

    // No. of ways to reach goal
    static int mazeCount(int row,int col){
        if(row == 1 || col == 1){
            return 1;
        }

        return mazeCount(row-1,col) + mazeCount(row,col-1);

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

         maze(row-1,col,processed+"B",ans);

         maze(row,col-1,processed+"R",ans);

         return ans;
    }

    //Paths to reach - (ArrayList in body)
    static ArrayList<String> maze(int row, int col, String processed){
        if (row == 1) {
            for (int i = 1; i < col; i++) {
                processed += "R";
            }
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        if (col == 1) {
            for (int i = 1; i < row; i++) {
                processed += "B";
            }
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        ans.addAll(maze(row-1,col,processed+"B"));

        ans.addAll(maze(row,col-1,processed+"R"));

        return ans;
    }
}
