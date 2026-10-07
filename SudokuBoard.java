public class SudokuBoard {
    int[][] board;
    int boardWidth = 9;
    public SudokuBoard(String filename){
        board = new int[boardWidth][boardWidth];
        clearBoard();
    }

    private void clearBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = 0;
            }
        }
    }

    public String toString(){
        String output = "";

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c< board[r].length; c++){
                output += (char)board[r][c];
            }
            output += "\n";
        }

        return output;
    }
}
