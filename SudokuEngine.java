public class SudokuEngine {
    public static void main(String[] args) throws Exception {
        SudokuBoard board = new SudokuBoard("dirty-data.sdk");
        
        
        System.out.println(board);
        System.out.println(board.isValid());
        System.out.println(board.isSolved());
    }
}

/*
PROGRAM OUTPUT:

dirty-data.sdk loaded.

- ----jGRASP exec: java SudokuEngine
-------------------------
| . . . | . . . | . . . |
| 1 6 7 | 9 8 5 | 4 2 3 |
| . . / | . . . | . . . |
-------------------------
| . . . | . . . | . . . |
| . . . | / . . | . . . |
| . . . | . . . | . . . |
-------------------------
| . . . | . . 2 | . . . |
| . . / | . . . | . . . |
| . . . | . . . | . . . |
-------------------------
false
false 
----jGRASP: Operation complete.
  
*/
