package SideLines.Palindromes; /**
 * Created by christian on 5/15/16.
 */
import java.util.*;
public class repeatingWords {
//which words repeat in the given string
//if it has it already then add key again, with current value + 1
    public static String wordRepeats(String sentence)
    {
        Map<String, Integer> repeat = new HashMap<>();
        int length = sentence.length();
        if(length == 0){return repeat.toString();}
        String[] allWords =sentence.split(" ");
        length = allWords.length;
        for(int i = 0; i < length; i++)
        {
            String word = allWords[i];
            if( repeat.containsKey(word) )
            {
                repeat.put(word, repeat.get(word) + 1);
            }
            else
                repeat.put(word, 1);
        }


        return repeat.toString();
    }

    public static void main(String[] args)
    {
    String sentence = "The man went to the store" +
            "and he bought bread and then he bought " +
            "some apples; boy was he a rich man! After that, he" +
            "left and went on the road. He headed to his house and " +
            ",but before entering his garage, he noticed that his car" +
            "was a horse. Not only that, but he realized he wasn't a man, " +
            "in fact, he was a camel. ";
        System.out.println(wordRepeats(sentence));
    }
}
