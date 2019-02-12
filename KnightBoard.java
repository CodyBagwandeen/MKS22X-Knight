public class KnightBoard{
  public static void main(String[] args){

  }

  public KnightBoard(int startingRows, int startingCols){
    if( startingCols <= 0 || startingRows <= 0){
      throw new IllegalArgumentException();
    }
  }
}
