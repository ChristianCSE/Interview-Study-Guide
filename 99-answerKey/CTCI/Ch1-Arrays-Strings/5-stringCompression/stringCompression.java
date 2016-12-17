/**
 * Created by christian on 5/15/16.
 */
import java.util.*;
public class stringCompression{

    //compresses doesn't care about length
    public static String universal_char_compression(String candidate)
    {
        candidate = candidate + " "; //last letter
        int len = candidate.length(), i;
        char[] letter = candidate.toCharArray();
        String compressedWord = "";
        int count = 1;
        for(i = 1; i < len; i++)
        {
            if(letter[i] != letter[i-1])
            {
                compressedWord = compressedWord + letter[i-1] + "" + count;
                count = 1; //reset count
            }
            else
                count++;
        }
        return compressedWord;
    }

    //returns compressed if shorter than original:ex. a1b1 is longer than ab
    public static String isCompressionShorter(String candidate)
    {
	    candidate = candidate + " "; //last letter
	    int len = candidate.length(), i;
	    char[] letter = candidate.toCharArray();
	    String alt_compression = "";
	    int count = 1;
	    for( i = 1; i < len; i++)
	    {
	        if(letter[i] != letter[i-1])
	        {
	            alt_compression = alt_compression + letter[i-1] + "" + count;
	            count = 1; //reset count
	            }
	            else
	                count++;
	    }
			int newLength = alt_compression.length();
	    if(len <= newLength)
			{
				return candidate;
			}
	     return alt_compression;
    }

    //nonrecuring
    public static String non_recurring_compression(String word)
    {
        try{
            if(word.length() == 0){return "";}
        } catch(NullPointerException e)
        {
            System.out.println("bad input");
            return null; 
        }

        int i, len = word.length();
        

        String[] letters = word.split("");
        len = letters.length; 
        Map<String, Integer> map = new HashMap<>();
        for(String single : letters)
        {
            if(map.containsKey(single))
            {
                Integer prevCount = map.get(single);
                map.put(single, prevCount+1);
            }
            else
            {
             map.put(single,1);   
            }
        }
        String answ = "";
        Iterator trav = map.entrySet().iterator(); 
        while(trav.hasNext())
        {
            Map.Entry letter_Count = (Map.Entry)trav.next();
            answ = answ + letter_Count.getKey() +  letter_Count.getValue();
        }
        return answ; 
    }
    

    public static void main(String[] a)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's compress a word!\nWord: ");
        String usr; 
        while( (usr = input.nextLine() ) != null )
        {
        	System.out.println("universal compression: "
        	 + universal_char_compression(usr) 
        		+ "\nlength compression: " 
        		+ isCompressionShorter(usr) 
        		+ "\nnonrecuring compression: "
        		+ non_recurring_compression(usr) );
        }
    }
}

/**CAVEAT: You may only use this if non-recurring 
    letters are specified. In other words, 
    aabba will be an invalid input since you will 
    return a3b2 instead of a2b2a1; hence if a question is 
    framed as how many times a char occurs, then this 
    would be allowed. If not, then use above*/
