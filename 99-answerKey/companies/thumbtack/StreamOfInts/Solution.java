import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
class Solution {

 public static void meanAndMedian(int[] arr){
  //don't know the size!!!! => cannot use arr.length since constant stream
  
  
 }


 public static void main(String[] args) throws Exception{
  List<String> dict = new ArrayList<>(); 
  InputStream in = new FileInputStream("numbers.txt");
  BufferedReader reader = new BufferedReader(new InputStreamReader(in));
  String word;
  while((word = reader.readLine()) != null){
    String[] splitIt = word.split(",");
    for(String official : splitIt){
      dict.add(official);
    }
  }
  // Random generator = new Random();
  // for(int i = 0; i < 1000; i++){
  //  System.out.print(generator.nextInt(1001) +", ");
  //  if(i!=0&&i%100==0){System.out.println();}
  // }
 }
}