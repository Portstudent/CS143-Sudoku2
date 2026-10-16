import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuBoard {
    int[][] board;
    int boardWidth = 9;
    public SudokuBoard(String filename){
        board = new int[boardWidth][boardWidth];
        Scanner data;

        try{
            data = new Scanner(new File(filename));
            clearBoard();
            populateBoard(data);


        } catch (FileNotFoundException e){
            System.out.println("ERROR: File not found!");
        }

    }
    
      private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }

    
    private void clearBoard(){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = 0;
            }
        }
    }

    private void populateBoard(Scanner data){
        int row = 0;
        while(data.hasNextLine()){
            String line = data.nextLine();
            for(int i = 0; i < line.length(); i++){
                if(Character.isDigit(line.charAt(i))){
                    board[row][i] = Character.getNumericValue(line.charAt(i));
                } else {
                    board[row][i] = 0;
                }
            }
            row++;
        }

    }
   
   public boolean isValid() {
      Set<Integer> cSet = new HashSet<>();
      Set<Integer> rSet = new HashSet<>();
      Set<Integer> miniSet = new HashSet<>();
      int resetCounter = 0;
      for (int r = 0; r < board.length; r++) {
         cSet.clear();
         for (int c = 0; c < board[r].length; c++) {
            if (!cSet.add(board[r][c]) && (board[r][c] != 0)) {
               return false;
               }
         }
      }
      
      for (int r = 0; r < board.length; r++) {
         rSet.clear();
         for (int c = 0; c < board[r].length; c++) {
            if (!rSet.add(board[c][r]) && (board[c][r] != 0)) {
               return false;
               }
         }
      }
      
      for (int spot = 1; spot <= board.length; spot++) {
         int[][] mini = miniSquare(spot);
         miniSet.clear();
         for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
               if (!miniSet.add(mini[r][c]) && mini[r][c] != 0) {
                  return false;
               }
            }
          }
       }
       return true;
    }
       
    public String toString(){
        String output = "";

        for(int r = 0; r < board.length; r++){
            if (r % 3 == 0){
                for(int i = 0; i < 25; i++){
                    output += '-';
                }
                output += '\n';
            }
            for(int c = 0; c< board[r].length; c++){
                if(c % 3 == 0){
                    output += "| ";
                }
                if(board[r][c] != 0){
                    output += (char)(board[r][c] + '0');
                } else {
                    output += '.';
                }

                output += ' ';
                
            }
            output = output.substring(0, output.length() - 1);
            output += " |\n";

        }

        for(int i = 0; i < 25; i++){
            output += '-';
        }

        return output;
    }
}
