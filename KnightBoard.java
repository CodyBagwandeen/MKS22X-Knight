public class KnightBoard{
  private int[][] board;
  public static void main(String[] args){

  }

  public KnightBoard(int startingRows, int startingCols){
    if( startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    } else {
      board = new int[startingRows][startingCols];
    }

  }

  public String toString(){
    boolean blank = true;
    String boutput = "";
    for(int r = 0; r < board.length ; r++){
      for(int c = 0; c < board[r].length; c++){
        if(board[r][c] != 0 ){
          blank = false;
        }
        boutput+= "_ ";
        if(c == board[r].length){
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
  
}
