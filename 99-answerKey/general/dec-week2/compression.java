class compression {

  public static void compressMe(String nums){
    int len = nums.length();
    if(len == 0) {
      System.out.println("");
      return;
    }
    char[] container = nums.toCharArray();
    String compressed = "";
    char prev = container[0];
    int counter = 1;
    for(int i = 1; i < len; i++) {
      if (container[i] == prev) {
        counter++;
      } else {
        compressed = compressed + counter + prev;
        counter = 1;
        prev = container[i];
      }
    }

    if(container[len-1] == prev) {
      compressed = compressed + counter + prev;
      System.out.println(compressed);
    }
    else {
      compressed = compressed  + "1" + prev;
      System.out.println(compressed);
    }
  }


  public static void main(String[] args) {
    compressMe("111223333");
  }
}