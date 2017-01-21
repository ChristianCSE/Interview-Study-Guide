import java.util.*;

public class caller{

  static public void printer(List<String> need, int max)
  {
    System.out.println("Should be: "+ max);
    for(String here : need)
    {

      // System.out.println("|"+here + "|");
      // System.out.println(here.length());
      if(here.length() != max)
      {
        System.out.println("|"+here + "|");
        System.out.println(here.length());        
      }
    }
    System.out.println("\n\n");

  }
  public static void main(String[] args)
  {
    Solution call = new Solution(); 
    String[] candidate = new String[]{"Here", "is", "an", "example", "of", "text", 
    "justification."};
    String[] blanks = new String[]{""};
    String[] letters = new String[]{"a","b","c","d","e"};
    String[] moreStrings = new String[]{"Listen","to","many,","speak","to","a","few."};
    String[] spacing = new String[]{"What","must","be","shall","be."};
    String[] checkEvenWire = new String[]{"Don't","go","around","saying",
    "the","world","owes","you","a","living;","the","world","owes","you","nothing;",
    "it","was","here","first."};

    List<String> need = new ArrayList<>(); 
    SecondTry anotherone = new SecondTry(); 

    
    need = anotherone.fullJustify(candidate, 15);
    System.out.println("-----------------------");
    printer(need, 15);

    need = anotherone.fullJustify(letters, 6);
    printer(need, 6);

    need = anotherone.fullJustify(blanks, 6);
    printer(need, 6);
    
    need = anotherone.fullJustify(spacing, 12);
    printer(need, 12);

    need = anotherone.fullJustify(moreStrings, 6);
    printer(need, 6);

    need = anotherone.fullJustify(checkEvenWire, 30);
    printer(need, 30);
  }
}
