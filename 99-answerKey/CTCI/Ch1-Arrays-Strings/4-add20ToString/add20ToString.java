/**
 * Created by christian on 5/15/16.
 */
import java.util.*;
public class add20ToString {
/*Chapter 1 Problem 4:
Write a method to replace all SPACES with "%20".
Assume enough space. You are given TRUE LENGTH:
Where the last non empty character is.
**/
    public static char[] add20(char[] str, int lastCharLenght)
    {
        int spaceCount = 0, totalLength, i;

        for (i = 0; i < lastCharLenght; i++)
        {
            if(str[i] == ' ') //char not string
            {
                spaceCount++;
            }
        }
        totalLength = lastCharLenght + (spaceCount * 2);

        for( i = lastCharLenght - 1 ; i >=0; i--)
        {
            if(str[i] == ' ')
            {
                str[totalLength - 1] = '0';
                str[totalLength - 2] = '2';
                str[totalLength - 3] = '%';
                totalLength = totalLength - 3;
            }
            else
            {
                str[totalLength - 1] = str[i];
                totalLength = totalLength - 1; //this is moving
                //i is already compensated LWR is far away from i so no worries for i
            }
        }
        return str;

    }


    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {

            if (str[i] != ' ')
            {

                return i+1; //why
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String argHold = "a b c d U        "; //assume enough room
        char[] holdIt = argHold.toCharArray();
        int charLength = findLastCharacter(holdIt); //last instance of char
        char [] heldit = add20(holdIt, charLength);
        System.out.println(heldit);
    }
}
/* Notes about the problem: 
We aren't given the total length of the str. 
each space requires three indices, since we 
already have 1, we only req 2 more per empty space.
-We are allowed to assume we are given a valid string
-We are told where the last character is, but not the length of the char array
*/

/*Things I noticed: 
--Specific to Problem----
-We want to find the last instance of a character.
-Work backwards, since faster to get
-if we find a non empty, then this is the last char
-IMPORTANT: You get back the index of the last character
  , you don't get back the length of the last character.
  This is what findLastCharacter() is doing!

---Methods/Algs/DS------
System.out.println(Arrays.toString(str));
str[lengthWithRoom] = '\0'; //this is C specific not Java, not sure why she does it in the book
String[] help = holdIt.split(""); turn string into a String array
Cost of split(): depends if it fits certain criteria. Normally calls indexOf()
*/

