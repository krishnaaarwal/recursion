package BackTrackingPractice;

public class N_Queens {
    public static void main(String[] args) {
        int n = 8;
        boolean[][] board= new boolean[n][n];
        System.out.println(queens(board,0));
    }

    //Since we start by col 0 every time , it doesn't necessarily need to pass it to arguments
    static int queens(boolean[][] board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count=0;

        //Place the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            //Place queen , if the place is safe
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count = count + queens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        //Vertically check
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        int leftDiagonal = Math.min(row,col);
        for (int i = 1; i <= leftDiagonal ; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        int rightDiagonal = Math.min(row,board.length - col - 1);
        for (int i = 1; i <= rightDiagonal; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for (boolean element : row){
                if(element){
                    System.out.print("Q");
                }else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

}
