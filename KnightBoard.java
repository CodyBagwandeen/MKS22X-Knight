public class KnightBoard{
  private int[][] board;
  private int counter;
  public static void main(String[] args){

    System.out.println("Initializing a 4 x 4 board : k");
    System.out.println("KnightBoard k = new KnightBoard(4,4)");
    KnightBoard k = new KnightBoard(4,4);

    System.out.println("Testing toString on a blank board");
    System.out.println("k\n");
    System.out.println(k);

    System.out.println("Testing adding a Knight to the board");
    System.out.println("k.addKnight(0,0) : Should be true");
    System.out.println(k.addKnight(0,0));
    System.out.println("k.addKnight(2,1) : Should be true");
    System.out.println(k.addKnight(2,1));
    System.out.println("k.addKnight(3,3) : Should be true");
    System.out.println(k.addKnight(3,3));
    System.out.println("k\n");
    System.out.println(k);

    System.out.println("Testing adding a Knight to a place outisde of the board");
    System.out.println("k.addKnight(-1,0) : Should be false");
    System.out.println(k.addKnight(-1,0));
    System.out.println("k\n");
    System.out.println(k);

    System.out.println("Testing adding a Knight to a place that has already been travled on");
    System.out.println("k.addKnight(0,0)");
    System.out.println(k.addKnight(0,0));
    System.out.println("k\n");
    System.out.println(k);

    System.out.println("Making a new board 5 x 5");
    System.out.println("KnightBoard k2 = new KnightBoard5,5)");
    KnightBoard k2 = new KnightBoard(5,5);
    System.out.println("Testing solving a board");
    System.out.println("k2.solve()");
    k2.solve(0,0);
    System.out.println("k2\n");
    System.out.println(k2);

    System.out.println("Making a new board 5 x 5");
    System.out.println("KnightBoard k3 = new KnightBoard(5,5)");
    KnightBoard k3 = new KnightBoard(5,5);
    System.out.println("Testing countSolutions on a board");
    System.out.println("k2.countSolutions(0,0)");
    System.out.println(k3.countSolutions(0,0));
    System.out.println("k3\n");
    System.out.println(k3);




  }

  public KnightBoard(int startingRows, int startingCols){
    if( startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    } else {
      board = new int[startingRows][startingCols];
      counter = 0;
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
   if(startingRow < 0 || startingCol < 0){
     throw new IllegalArgumentException();
   }
   for(int r = 0; r < board.length; r++){
     for(int c = 0; c < board[r].length; c++){
       if(board[r][c] != 0){
         throw new IllegalStateException();
       }
     }
   }
   return solveR(startingRow,startingCol);

 }

 public boolean solveR(int row, int col){
   if( counter == board[row].length * board.length - 1){
     return true;
   } else{
     int[] moves = {2,1, 1,2, -2,-1, -1,-2, 2,-1, 1,-2, -2,1, -1,2}; // 8 different moves
     for(int i = 0; i < 15; i += 2){
       if(addKnight(row + moves[i], col + moves[i+1])){
         if(solveR(row + moves[i], col + moves[i+1])){
           return true;
         } else{
           removeKnight(row + moves[i], col + moves[i+1]);
         }
       }
     }
   }
   return false;

 }

 /** would only work on smaller boards!
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  *@return the number of solutions from the starting position specified
  */
 public int countSolutions(int row, int col){
   if(row < 0 || col < 0){
     throw new IllegalArgumentException();
   }
   for(int r = 0; r < board.length; r++){
     for(int c = 0; c < board[r].length; c++){
       if(board[r][c] != 0){
         throw new IllegalStateException();
       }
     }
   }
   return countH(row, col);
 }

 public int countH(int row, int col){
   int sum = 0;
   if( counter == board.length * board[0].length - 1){
     return 1;
   } else {
     int[] moves = {2,1, 1,2, -2,-1, -1,-2, 2,-1, 1,-2, -2,1, -1,2}; // 8 different moves
     for(int i = 0; i < 15; i += 2){
       if(addKnight(row,col)){
         sum += countH(row + moves[i], col + moves[i+1]);
         removeKnight(row,col);
       }
     }
   }
   return sum;
 }

 public boolean addKnight(int row, int col){
   if(row >= board.length || row < 0 || col >= board[0].length || col < 0){
     return false;
   } else{
     if(board[row][col] != 0){
       return false;
     }else{
       board[row][col] = counter++ + 1;
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
