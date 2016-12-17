// 68. Text Justification
import java.util.*;
public class Solution{


  public static List<String> fullJustify(String[] words, int maxWidth)
  {
    Deque<String> queue = new ArrayDeque<>();
    for(String currWord : words)
    {
      queue.add(currWord);
    }

    List<String> list = new ArrayList<>();
    String sentence = "";
    boolean padIt = false;
    boolean finalLine = false;

    while( !queue.isEmpty() )
    {
      sentence = sentence + queue.poll();
      int len = sentence.length();

      //can we append a blank?
      if(len < maxWidth)
      {
        sentence+= " ";
        len = sentence.length();
      }

       //THE LAST LINE DOES NOT RECEIVE EXTRA PADDING B/W WORDS
      //The padding goes at the end
      if(queue.peek() == null && !padIt)
      {
        finalLine = true;
        padIt = true;
      }

      //we should add this now if it reached max size
      if(len == maxWidth)
      {
        if(queue.peek() != null)
        {
          padIt = true;
        }
      }

      //will it reach max capacity in it's next turn
      if(queue.peek() != null && !padIt)
      {
        if( len + queue.peek().length() - 1 >  maxWidth)
        {
          padIt = true;
        }
      }

      //Padd it and add it to list
      if(padIt)
      {
        sentence = padSentence(sentence, maxWidth, finalLine);
        list.add(sentence);
        sentence = "";
        padIt = false;
      }
    }//while()

    return list;
  }

  public static String padSentence(String sentence, int maxWidth)
  {
    int padding = sentence.lastIndexOf(" ");
    int addPadding = maxWidth - sentence.length() + 1;
    String[] letters = sentence.split("");
    int len = sentence.length(), i;
    String sendBack = "";
    for(i = 0; i < len; i++)
    {
      if(i == padding)
      {
        for(int j = 0; j < addPadding; j++)
        {
          sendBack += " ";
        }
      }
      else
      {
        sendBack += letters[i];
      }
      }
    return sendBack;
   }

  public static String padSentence(String sentence, int maxWidth, boolean finalLine)
  {
      //edge case
      if(finalLine)
      {
        return padSentence( sentence, maxWidth);
      }

      sentence = sentence.trim();
      if(sentence.length() == maxWidth)
      {
        return sentence;
      }

      //edge case: might have to put == 0
      if( sentence.length() == 1)
      {
        int extraPadding = maxWidth - sentence.length();

        for(int j = 0; j < extraPadding; j++)
        {
          sentence = sentence + " ";
        }
        return sentence;
      }

      //normal cases
      int wordCount = 0;
      String[] letters = sentence.split("");

      int spaces = 0;

      for(String curr: letters)
      {
        if(curr.equals(" "))
        {
          spaces++;
          wordCount++;
        }
      }


      //Want:   |to___a|
      //Don't want: |to__a_|
      if(wordCount > 1)
      {
        sentence = sentence.trim();
        // System.out.println("has more than one word|" +sentence + "|");
        letters = sentence.split("");
        // spaces = spaces - 1;
      }

      spaces = 0;
      for(String curr: letters)
      {
        if(curr.equals(" "))
        {
          spaces++;
        }
      }



      // System.out.println(sentence + " " + spaces);



      int len = sentence.length();

      int remainderShared = maxWidth - (len - spaces);
      boolean sharedEvenly = true;
      int addPadding;
      String newPaddedString = "";
      boolean singleSpace = false;
      int shoveInFront = 0;

      //It's one word, but it needs spaces
      if(spaces == 0)
      {
        addPadding = remainderShared;
        sentence = sentence + " ";
        letters = sentence.split("");
        len = letters.length;
      }
      else
      {
        addPadding = remainderShared/spaces;
        if(spaces == 1)
        {
          singleSpace = true;
        }
        int sharing = remainderShared%spaces;

        if(sharing != 0)
        {
          sharedEvenly = false;
          shoveInFront= addPadding + (remainderShared - spaces);
        }
      }

      for(int i = 0; i < len; i++)
      {
        if(letters[i].equals(" "))
        {

          if(sharedEvenly)
          {
            for(int j = 0; j < addPadding; j++)
            {
              newPaddedString += " ";
            }
          }
          else{
              for(int j = 0; j < shoveInFront; j++)
              {
                newPaddedString += " ";
              }
              sharedEvenly = true;
            }
        }//padding
        else
        {
          newPaddedString += letters[i];
        }//letter
      }
      return newPaddedString;
    }
  }
