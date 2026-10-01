package BackTrackingPractice;

public class Sudoku {
    public static void main(String[] args) {

        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudoku(board, 0, 0);

    }

    public static void sudoku(int[][] board,int row,int col){
        if(row == board.length){
            display(board);
            System.out.println();
            return;
        }

        if(col==board.length) {
            sudoku(board,row+1,0);
            return;
        }

        if (board[row][col] != 0) {
            // this cell is already filled
            // move to the next cell
            sudoku(board, row, col + 1);
        }
        else {
            for(int i=1;i<10;i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = i;
                    sudoku(board, row, col + 1);
                    board[row][col] = 0;
                }
            }
        }


    }
    private static boolean isSafe(int[][] board, int row, int col,int num) {

        if (!isInBoundary(board, row, col)) {
            return false;
        }

        //Row check
        for(int i=0;i< board.length;i++){
            if(board[row][i] == num){
                return false;
            }
        }

        //Col check
        for(int i=0;i< board.length;i++){
            if(board[i][col] == num){
                return false;
            }
        }

        //Grid check
        int squareLeft = row - (row % 3);
        int squareRight = col - (col % 3);

        for(int i=squareLeft;i<squareLeft+3;i++){
            for(int j = squareRight;j<squareRight+3;j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }


        return true;
    }

    private static boolean isInBoundary(int[][] board,int row,int col){
        if(row>=0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }

    private static void display(int[][] board){
        for(int[] row : board){
            for (int element : row){
                System.out.print(element);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
