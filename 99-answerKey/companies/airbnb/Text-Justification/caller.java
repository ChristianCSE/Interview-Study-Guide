
public class caller{

  public static void main(String[] args)
  {
    Solution call = new Solution(); 
    String[] candidate = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    String[] blanks = new String[]{""};
    String[] letters = new String[]{"a","b","c","d","e"};
    String[] moreStrings = new String[]{"Listen","to","many,","speak","to","a","few."};


    System.out.println(call.fullJustify(moreStrings, 6));

  }
}
