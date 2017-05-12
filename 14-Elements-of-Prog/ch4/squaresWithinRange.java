public class squaresWithinRange {

  public static boolean isPerfect(int numb) {
    return (Math.pow(numb, 0.5)%1 == 0);
  }

  public static int singlyRange(int numb) {
    int start = 0;
    int numbPerfs = 0;
    for(int i = 1; i < numb; i++) {
      boolean perfSquare;
      if (perfSquare = isPerfect(i)) {
        System.out.println("this is perfect: " + i);
        numbPerfs++;
      }
    }
    return numbPerfs;
  }

  public static int rangeSquares(int[] pair) {
    int len = pair.length;
    if(len == 0 ) {
      return 0; 
    }
    if (len == 1) {
      return singlyRange(pair[0]);
    }
    int numbPerfs = 0, 
    start = pair[0], 
    end = pair[1];
    for(int i = start+1; i < end; i++) {
      boolean perf;
      if( perf = isPerfect(i) ){
        System.out.println("this is perfect: " + i);
        numbPerfs++;
      }
    }
    return numbPerfs;
  }

  public static void main(String[] args) {
    int[] pairing = new int[]{9, 90};
    System.out.println("there are " + rangeSquares(pairing) + " perfect squares");
    int[] singly = new int[]{500};
    double container = Math.pow(500, 0.5);
    System.out.println("hello: " + container);
    System.out.println("there are " + rangeSquares(singly) + " perfect squares");
  }
}