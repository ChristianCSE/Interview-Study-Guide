import java.util.List; 
import java.util.ArrayList; 
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Set;
import java.util.LinkedHashSet;

public class oldsolution{
  public static List<List<Integer>> old(String[] words)
  {
    List<List<Integer>> list = new ArrayList<>(); 
    List<Integer> pair;
    int len = words.length; 
    boolean check = true; 
    int i = 0, j; 
    for(i = 0; i < len-1; i++){
      String curr = words[i];
      String rev = new StringBuilder(curr).reverse().toString();   
      int lengthCurr = curr.length(); 
      aux: for(j = i+1; j < len; j++){ 

        String att = words[j];

        int diff = att.length() - lengthCurr ; 
        if(diff > 0)
        {
          if(rev.equals(att.substring(0, lengthCurr )))
          {
            check = true;
          }
          if( rev.equals(att.substring(diff, att.length()) ) )
          {
            check = true;
          }
        }
        if(diff == 0)
        {
          if(rev.equals(att))
          {
            pair = new ArrayList<>();
            pair.add(i); 
            pair.add(j);
            list.add(pair);
            pair = new ArrayList<>();
            pair.add(j); 
            pair.add(i);
            list.add(pair);
          }
          continue aux;
        }

        if(diff < 0)
        {
          check = true; 
        }
        //frwrd
        if(check)
        {
          if( checkDrome(curr + att) )
          {
            pair = new ArrayList<>();
            pair.add(i); 
            pair.add(j);
            list.add(pair);
          }
          //bkwrd
          if( checkDrome( att + curr) )
          {
            pair = new ArrayList<>();
            pair.add(j); 
            pair.add(i);
            list.add(pair);
          }
        }
        check = false; 
      }//for()
    }  
    return list; 
  }

  public static boolean checkDrome(String concat)
  {
    if(concat.length() == 1 || concat.length() == 0) {return true;}
    int len = concat.length() - 1, i; 
    for(i = 0; i <= len/2; i++)
    {
      if(concat.charAt(i) != concat.charAt(len - i))
      {
        return false;
      }
    }
    return true; 
  }
  
  public static void main(String[] args)
  {

  }
}
