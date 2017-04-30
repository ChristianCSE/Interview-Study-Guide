import java.util.AbstractMap;
import java.util.HashMap;
import java.util.*; //bad but idk where Generics is 

class studyGuide1{

  

  /*===========================================
  Map iterator methods: 
  Enhanced for loop
  While loop 
  ===========================================*/
  public static void explicitCastingMapIterations(Map map)
  {
    System.out.println("Most of the times when we iterate through a map \n" +
      "we don't store the objects, but when we do we must use explicit casting.\n"+
      "The reason we do this is that \n"+
      "Map.Entry pair = (Map.Entry)iter.next();\n"+
      "pair.getKey(); & pair.getValue()\n"+
      "both getters return OBJECT types, and you cannot simply do\n"+
      "String myKey = pair.getKey(); Since you would be downcasting an object into something lower. "
      );
    Iterator iter = map.entrySet().iterator(); 
    while(iter.hasNext())
    {
      Map.Entry pair = (Map.Entry) iter.next(); 
      String myKey = (String) pair.getKey();
      Integer myValue = (Integer) pair.getValue();
      System.out.println(myKey + "     " + myValue);
    }
  }

  public static <T> void printMap(Map<T, Integer> map)
  {
    for(Map.Entry<T, Integer> entry : map.entrySet())
    { 
      System.out.println( entry.getKey() + "   " + entry.getValue());
    }
  }

  static public void callMapMethods()
  {
    Map<String, Integer> map = new HashMap<>(); 
    String[] keyEntries = new String[]{"apple", "food", "homemade", "coffee"};
    Integer[] valueEntries = new Integer[]{123, 1244, 2121, 1212};
    int i = 0;
    for(String key : keyEntries)
    {
      map.put(key, valueEntries[i]);
    }

    //Regular looping through a map
    printMap(map);

    //do the explicit map casting
    explicitCastingMapIterations(map);
  }

/*===========================================
  String Reversal Methods: 
  StringBuilder 
  & String array 
  ===========================================*/
  static public String simpleRev(String word)
  {
    return new StringBuilder(word).reverse().toString();
  }

  static public String medRev(String word)
  {
    String[] sliced = word.split("");
    int length = sliced.length, i; 
    String temp = "";
    for(i = 0; i < length/2; i++)
    {
      temp = sliced[i]; 
      sliced[i] = sliced[length-1-i];
      sliced[length-1-i] = temp; 
    }
    return Arrays.deepToString(sliced);
  }

/*===========================================
  Replacing/manipulating strings: 
  Regex: Remove all letters and numbers
  Regex: Only leave letters and numbers
  Regex: Remove blank spaces 
  ===========================================*/
  static public String removeBlanks(String word)
  {
    return word.replaceAll("\\s+", "");

  }

  static public String removeLettersNumbers(String word)
  {
    return word.replaceAll("[A-za-z0-9]", "");
  }

  //doesn't completely work 
  static public String leaveOnlyLettersNumbers(String word)
  {
   return word.replaceAll("[^A-za-z0-9]", ""); 
  }

  static public void callStringManMethods()
  {
    String word = "      h      e     l    l  o ";
    System.out.println(word);  
    System.out.println(removeBlanks(word));
    word = "h2132321e12321231l213231231l1233213121230";
    System.out.println(word);
    System.out.println(removeLettersNumbers(word));
    word = "()*(increasing &*^num[&%bers $^300 &*()(*&^[%$^&*()200";
    System.out.println(word);
    System.out.println(leaveOnlyLettersNumbers(word));
  }



  public static void main(String[] args)
  {
    callMapMethods(); 
    callStringManMethods(); 
  }



}
