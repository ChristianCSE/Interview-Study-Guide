

class Solution {

  /*tbh how would you notice this??*/
  public static boolean isRotation(String str1, String str2) {

    if(str1.length() != str2.length()) return false;

    String trick = str1 + str1;
    return (trick.indexOf(str2) > 0) ? true : false;
  }

  public static void main(String[] args) {
    String str1 = "waterbottle";
    String str2 = "ttlewaterbo";
    System.out.println(isRotation(str1, str2));
    str1 = "waterbottle";
    str2 = "erbottlewat";
    System.out.println(isRotation(str1, str2));
    str1 = "waterbottle";
    str2 = "waterelottb";
    System.out.println(isRotation(str1, str2));    
  }
}