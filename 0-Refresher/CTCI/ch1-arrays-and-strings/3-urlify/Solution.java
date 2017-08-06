

class Solution {

  public static String urlify(char[] c, int realLength) {
    //The "holes" will be from [0, realLength]
    int holes = 0;
    
    for(int i = 0; i < realLength; i++) {
      if(c[i] == ' ') {
        holes++;
      }
    }
    
    
    //holes = 1 spot, need 2 more spaces
    //endpoint start building string from here
    int totalLength = realLength + 2*holes;

    for(int i = realLength - 1; i >= 0; i--) {
      if(c[i] != ' ') {
        //nothing to add, just place it 
        c[totalLength - 1] = c[i];
        totalLength--;
      }
      else {
        //%20
        c[totalLength - 1] = '0';
        c[totalLength - 2] = '2';
        c[totalLength - 3] = '%';
        totalLength -= 3;
      }
    }

    //System.out.println(c);
    return new String(c);
  }

  public static void main(String[] args) {
    String str  = "Mr John Smith";
    int real_len = str.length();
    char[] c = new char[str.length() + 11];
    int index = 0;
    for(char i: str.toCharArray()){
      c[index++] = i;
    }

    /*
    index = 1;
    for(char o: c) {
      System.out.println(index++ + " =>" + o);
    }
    */
    System.out.println(str + "=>" + urlify(c, real_len));
  }
}