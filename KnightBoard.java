public class KnightBoard{
  private int[][] board;
  private int counter;
  public static void main(String[] args){

    System.out.println("Initializing a 4 x 4 board : k");
    System.out.println("KnightBoard k = new KnightBoard(4,4)");
    KnightBoard k = new KnightBoard(4,4);

    System.out.println("Testing toString on a blank board");
    System.out.println("k");
    System.out.println(k);

  }

  public KnightBoard(int startingRows, int startingCols){
    if( startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    } else {
      board = new int[startingRows][startingCols];
      counter = 1;
    }

  }

  public String toString(){
    boolean blank = true;
    String boutput = "";
    for(int r = 0; r < board.length ; r++){ // blank board
      for(int c = 0; c < board[r].length; c++){
        if(board[r][c] != 0 ){
          blank = false;
        }
        boutput+= "_ ";
        if(c == board[r].length - 1){
          boutput += "\n";
        }
      }
    }

    if(blank){
      return boutput;
    } else {
      String output = "";
      if(board.length * board[0].length < 10){
        for(int r = 0; r < board.length; r++){ // rows * cols < 10
          for(int c = 0; c < board[r].length; c++){
            output += board[r][c] + " ";
            if( c == board[r].length -1){
              output += "\n";
            }
          }
        }
      } else {
        for(int r = 0; r < board.length; r++){ // rows * cols >= 10
          for(int c = 0; c < board[r].length; c++){
            if(board[r][c] > 9){
              output += board[r][c] + " "; // one space after two digit numbers
            } else {
              output += " " +  board[r][c] + " ";  // one space before and after single digit numbers
            }
            if( c == board[r].length -1){
              output += "\n";
            }
          }
        }
      }
      return output;
    }

  }

 /*
 Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
 @throws IllegalStateException when the board contains non-zero values.
 @throws IllegalArgumentException when either parameter is negative
 or out of bounds.
 @returns true when the board is solvable from the specified starting position
 */
 public boolean solve(int startingRow, int startingCol){
   if(startingRow <0 || startingCol <0){
     throw new IllegalArgumentException();
   }
   for(int r = 0; r < board.length; r++){
     for( int c = 0; c < board[r].length; c++){
       if( board[r][c] != 0){
         throw new IllegalStateException();
       }
     }
   }
   return solveR(startingRow,startingCol);

 }

 public boolean solveR(int row, int col){
   if( counter == board[row].length * board.length){
     return true;
   } else{

   }
   return false;

 }

 public boolean addKnight(int srow, int scol, int nrow, int ncol){
   if(srow + nrow >= board.length || srow - nrow < 0 || scol + ncol >= board[0].length || scol - ncol < 0){
     return false;
   } else{
     if(board[nrow][ncol] != 0){
       return false;
     }else{
       board[nrow][ncol] = counter++ + 1;
       return true;
     }
   }

 }

public boolean removeKnight(int row, int col){
    if(board[row][col] != counter){
      return false;
    } else{
      board[row][col] = 0;
      counter--;
      return true;
    }

  }

}
