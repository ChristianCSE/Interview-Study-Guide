

class Solution {

  public static boolean addOne(String one, String two){
    int j = 0; 
    int diffs = 0;
    for(int i = 0; i < one.length(); i++) {
      //could be appended at the very end
      if(two.length() -1 < i || one.charAt(i) != two.charAt(j)) {
        diffs++;
        if(diffs > 1) return false; 
      } else {
        j++;
      }
    }
    return true;
  }

  public static boolean changeOne(String one, String two) {
    int diffs = 0;
    for(int i = 0; i < one.length(); i++) {
      if(one.charAt(i) != two.charAt(i)) {
        diffs++;
        if(diffs > 1) return false;
      }
    }
    return true;
  }

  public static boolean oneAway(String one, String two){
    int diff = one.length() - two.length();
    System.out.println(diff);
    if(diff == -1 || diff == 1) {
      if(one.length() > two.length()){
        return addOne(one, two);
      } else {
        return addOne(two, one);
      }
    }
    else if(diff == 0) {
      return changeOne(one, two);
    } else {
      return false;
    }
  }
  public static void main(String[] args) {
    System.out.println("True ==>" + oneAway("change", "changer"));
    System.out.println("True ==>" +oneAway("changer", "change"));
    System.out.println("True ==>" +oneAway("ahange", "change"));
    System.out.println("False ==>" +oneAway("ssahange", "change"));
    System.out.println("False ==>" +oneAway("chanr", "change"));
  }
}