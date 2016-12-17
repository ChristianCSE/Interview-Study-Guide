
import java.util.*;
public class dromePerm
{
//can a word's permutation be a palindrome
//this cannot read palindromes that include punctuation. 
	//if one want this, then use the commented out expression
	public static void arrangedDrome(String word)
	{
		if(word == null || word.length() < 2) {return;}
		 // word = word.replaceAll("[^A-Za-z0-9]", "");
		String[] letters = word.toLowerCase().replaceAll(" ", "").split(""); 
		Map<String, Integer> map = new HashMap<>();

		for(String aLetter : letters)
		{
			if(map.containsKey(aLetter))
			{
				map.put(aLetter, map.get(aLetter) + 1);
			}
			else
			{
				map.put(aLetter, 1);
			}
		}
		//now iterate through it and see if it can be palindrome
		//def of palindrome: Only 1 instance of odd pairs!
		Iterator iter = map.entrySet().iterator();
		boolean wire = false; 
		while(iter.hasNext())
		{
			Map.Entry paired = (Map.Entry) iter.next();
			int value = (int)paired.getValue();
			if( (value = value%2) != 0)
			{
				if(wire)
				{
					wire = false; 
					break; //break out of loop {if = a branch}
				}
				wire = true; //tripped wire
			}

		}

		if(wire)
		{
			System.out.println("this can be a palindrome");
		}
		else
		{
			System.out.println("this cannot be a palindrome since it breaks the def.");
		}

		
	}

	public static void main(String[] args)
	{
		arrangedDrome("Tact Coa");
		arrangedDrome("oe was Ir ere I sasw Eros");
		arrangedDrome("Gatename manseesman   atgarage  sees name g");
		arrangedDrome("Not so Boston");
	}
}
