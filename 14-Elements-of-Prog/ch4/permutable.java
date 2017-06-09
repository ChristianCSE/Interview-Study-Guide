import java.util.*;

public class permutable {

  static public boolean permutableNumb(int numb) {
    char[] arr = (numb + "").toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for(char indieNumb: arr) {
      if(map.containsKey(indieNumb)) {
        map.put( indieNumb, map.get(indieNumb)+1);
      } else {
        map.put(indieNumb, 1);
      }
    }
    int odds = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue()%2 != 0) {
        odds++;
        if(odds == 2) {
          return false;
        }
      }
    }
    return true; 

  }

  public static void main(String[] args) {
    int numb = 1321352;
    System.out.println(numb+ " is permutable => " + permutableNumb(numb));
    numb = 111222;
    System.out.println(numb+ " is permutable => " + permutableNumb(numb));
  }
}