public class LCPrefix{

  public static String prefix(String[] arr)
  {
    
    if(arr.length == 0 || arr == null) {return "";}
    int i, len = arr.length; 
    String prefix = arr[0];
    for(i = 1; i < len; i++)
    {
      String candidate = arr[i];
      //indexOf = + means not prefix but inside the word 
      //indexOf = - means the prefix might be too long, hence update it and make shorter 
      //indexOf = 0 means prefix
      while(candidate.indexOf(prefix) != 0)
      {
        prefix = prefix.substring(0, prefix.length() - 1); 
        if(prefix.equals("")) {return "";}
      }
    }
    return prefix; 
  }

  public static void main(String[] args)
  {
    String[] arr = new String[]{"leest", "lees", "leestcode", "leesters", "leesps", "leesp"};
    System.out.println(prefix(arr));
  }
}
