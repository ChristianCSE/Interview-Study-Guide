/*
 * Created by christian on 5/15/16.
 */
import java.util.*;
public class allPermutations {

    /*
    * I want to see all possible permutations Use Heap's algorithm
    * **/
public static Set<String> getPerms(String word)
{
    Set<String> allPerms = new HashSet<>();
    int spaces = word.length();
    // String[] wordSep = new String[] {word}; //puts word into one index
    String[] wordSep = word.split("");
    // System.out.println(Arrays.toString(wordSep)); //Java 8 update turning to string
    // return null;
    return makePerms(wordSep, allPerms, spaces);
}

    public static Set<String> makePerms(String[] wordSep, Set<String> allPerms, int n)
    {
        if(n == 1)
        {
            allPerms.add(Arrays.toString(wordSep));
            // System.out.println(Arrays.toString(wordSep));
            return allPerms;
        }
        else{
            for(int i = 0; i < n; i++)
            {
                makePerms(wordSep, allPerms, n-1);
                if(n%2==0)
                {
                    wordSep = swapLetter(wordSep, i, n-1);
                }
                else
                {
                    wordSep = swapLetter(wordSep, 0, n-1);
                }
            }//for()
        }//else()
        return allPerms;
    }

    public static String[] swapLetter(String[] wordSep, int i, int j)
    {
        String tmp = wordSep[i];
        wordSep[i] = wordSep[j];
        wordSep[j] = tmp;
        return wordSep;
    }

    public static void main(String[] args)
    {
        String wantAllPerms = "1234";
        Set<String> allPerms = getPerms(wantAllPerms);
        // System.out.println(Arrays.toString(allPerms.toArray()));

        System.out.println( allPerms + "\nThis many permutations possible: " + allPerms.size()); //all collection d/t call size

    }


}
