import java.util.List; 
import java.util.ArrayList; 
import java.util.Queue;
import java.util.Deque; 
import java.util.ArrayDeque;
import java.util.Arrays;
public class Solution{

  /**
   * fullJustify: L is the width of a legitmate string of size L
   *  add space padding in order for it to fit this. Also, it is guarenteed 
   *  that each string will not be over length L. 
   * @param  words    [array of words]
   * @param  maxWidth [Limit for string entry length]
   * @return          [List ]
   */
  public static List<String> fullJustify(String[] words, int maxWidth)
  {
    Deque<String> queue = new ArrayDeque<>(); 
    for(String oneWord: words)
    {queue.add(oneWord);} 
    List<String> list = new ArrayList<>(); 
    String sentence = "";
    boolean addWire = false;

    while(!queue.isEmpty())
    {
      if(sentence.length() + queue.peek().length() <= maxWidth)
      {
        //starting word
        if(sentence.length() == 0)
          {
            sentence = queue.poll();
            if(sentence.length() != maxWidth)
            {
              sentence = sentence + " ";
            }
          }
        //appeneded to existing phrase
        else
        {
          sentence = sentence + queue.poll();
          if(queue.peek() != null)
          {
            if(sentence.length() + queue.peek().length() < maxWidth)
            {
              sentence = sentence + " ";
            }
          }

        }
      }
      
      if(queue.peek() != null)
      {
        if(sentence.length() + queue.peek().length() > maxWidth)
        {
          addWire = true;
        }
      }

      if(addWire)
      {
        sentence = padSentence(sentence, maxWidth);
        list.add(sentence);
        sentence = "";
        addWire = false;
      }
    }
    //last entry isn't entered
    sentence = sentence.trim();
    sentence = padSentence(sentence, maxWidth);
    // System.out.println("=>" +sentence.length()+ "<=");
    list.add(sentence);
    return list; 
    }

    public static String padSentence(String sentence, int maxWidth)
    {
      
      //edge case
      if(sentence.length() == maxWidth)
      {
        return sentence;
      }

      //edge case
      if(sentence.length() == 0 || sentence.length() == 1)
      {
        int extraPadding = maxWidth - sentence.length();
        // System.out.println("=>" +sentence+ "<=");
        for(int j = 0; j < extraPadding; j++)
        {
          sentence = sentence + " ";
        }
        // System.out.println("=>" +sentence+ "<=");
        return sentence;
      }      

      //normal cases
      String[] letters = sentence.split("");
      int len = letters.length;
      int spaces = 0;  

      for(String curr: letters)
      {
        if(curr.equals(" "))
        {
          spaces++;
        }
      }

      //no spaces
      

      int remaining = maxWidth - len;
      // System.out.println(sentence + "<=="  + "   =>" + remaining);
      boolean evenWire = true;
      int addPadding;

      // System.out.println(sentence);
      if(spaces == 0)
      {
        addPadding = remaining;
        sentence = sentence + " ";
        // System.out.println(sentence + "<==");
        letters = sentence.split("");
        len = sentence.length();
        // System.out.println(Arrays.deepToString(letters));
      }
      else
      {
        addPadding = remaining/spaces;
        if(remaining%spaces!=0){evenWire = false;}
      }
      

      String newPaddedString = "";

      //add padding
      for(int i = 0; i < len; i++)
      {
        
        if(letters[i].equals(" "))
        {

          if(evenWire)
          {
            for(int j = 0; j < addPadding; j++)
            {
              newPaddedString += " ";

            }
          }
          else{
              for(int j = 0; j < addPadding+1; j++)
              {
                newPaddedString += " ";
              }
              evenWire = true;
            }
        }
        else
        {
          newPaddedString += letters[i];
        }
      }
      return newPaddedString;
    }

}
