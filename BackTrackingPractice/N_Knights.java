package BackTrackingPractice;

public class N_Knights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        knights(board,0,0,n);
    }

    static void knights(boolean[][] board,int row,int col,int knights){
        if(knights==0){
            display(board);
            System.out.println();
            return;
        }

        if(row == board.length-1 && col== board.length){
            return;
        }

        if(col==board.length) {
            knights(board,row+1,0,knights);
            return;
        }

        if(isSafe(board,row,col)){
            board[row][col] = true;
            knights(board, row, col + 1, knights-1);
            board[row][col] = false;
        }
        //if it is not safe to put, move ahead
        knights(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        //Up Left
        if((isInBoundary(board,row-2,col-1) && board[row-2][col-1])){
            return false;
        }

        //Up Right
        if((isInBoundary(board,row-2,col+1) && board[row-2][col+1])){
            return false;
        }

        //Left Up
        if((isInBoundary(board,row-1,col-2) && board[row-1][col-2])){
            return false;
        }

        //Right Up
        if((isInBoundary(board,row-1,col+2) && board[row-1][col+2])){
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

    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for (boolean element : row){
                if(element){
                    System.out.print("K");
                }else{
                    System.out.print("X");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
