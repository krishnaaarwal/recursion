package BackTrackingPractice;

public class N_Pawns {
    public static void main(String[] args) {
        int n = 8;
        boolean[][] board = new boolean[n][n];
        System.out.println(pawns(board,0,0,n));
    }

    static long pawns(boolean[][] board, int row, int col, int pawns){
        if(pawns==0){
//            display(board);
//            System.out.println();
            return 1;
        }

        if(row == board.length-1 && col== board.length){
            return 0;
        }

        if(col==board.length) {
            return pawns(board,row+1,0,pawns);
        }

        int count = 0;
        if(isSafe(board,row,col)){
            board[row][col] = true;
            count += pawns(board, row, col + 1, pawns-1);
            board[row][col] = false;
        }
        //if it is not safe to put, move ahead
        count += pawns(board, row, col + 1, pawns);
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        //Left Diagonal
        if((isInBoundary(board,row-1,col-1) && board[row-1][col-1])){
            return false;
        }

        //Up Diagonal
        if((isInBoundary(board,row-1,col+1) && board[row-1][col+1])){
            return false;
        }

        return true;
    }

    private static boolean isInBoundary(boolean[][] board,int row,int col){
        if(row>=0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }

//    private static void display(boolean[][] board){
//        for(boolean[] row : board){
//            for (boolean element : row){
//                if(element){
//                    System.out.print("P");
//                }else{
//                    System.out.print("X");
//                }
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }
}
