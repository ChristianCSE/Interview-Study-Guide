import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
class HotlineBling{
 //combination sum 
 //combination words
 //
 public static Map<String, List<String>> map = new HashMap<>(); 
 public static List<String> dict = new ArrayList<>(); 
 static{
  map.put("0", new ArrayList<>());
  map.put("1", new ArrayList<>());
  map.put("2", Arrays.asList(new String[] { "a", "b", "c"}));
  map.put("3", Arrays.asList(new String[] { "d", "e", "f"}));
  map.put("4", Arrays.asList(new String[] { "g", "h", "i"}));
  map.put("5", Arrays.asList(new String[] { "j", "k", "l"}));
  map.put("6", Arrays.asList(new String[] { "m", "n", "o"}));
  map.put("7", Arrays.asList(new String[] { "p", "q", "r", "s"}));
  map.put("8", Arrays.asList(new String[] { "t", "u", "v"}));
  map.put("9", Arrays.asList(new String[] { "w","x", "y", "z"}));
  final String pathToFile = "dictionary.txt";
  try{
  InputStream in = new FileInputStream(pathToFile);
  BufferedReader reader = new BufferedReader(new InputStreamReader(in));
  String word;
  while((word = reader.readLine()) != null){
    String[] splitIt = word.split(", ");
    for(String official : splitIt){
      dict.add(official);
    }
  }
  } catch(Exception oops){}
}

 public static void decompose(String phoneNumber){
  int len = phoneNumber.length();
  String[] careNumbers = phoneNumber.substring(5, len).replace("-","").split("");
  String[] formedWord = new String[careNumbers.length];
  int i =0;
  for(String digit: careNumbers){
    if(digit.equals("1")||digit.equals("0")){
      formedWord[i++] = "";
    } else{
      formedWord[i++]= map.get(digit).get(0);
    }
  }
  Set<String> candidates = new HashSet<>();
  getCandidates(candidates, careNumbers, formedWord, 0);
  Map<String, List<String>> bagOfWords = new HashMap<>();
  System.out.println(candidates.size());
  for(String singly:candidates){
   System.out.println(singly);
  }
  //splitem(bagOfWords, candidates, 0);
 }

 public static void splitem(Map<String, List<String>> bagOfWords, Set<String> candidates, int start){
  //should take curr word 
  for(String candidate: candidates){
    
    splitIt(candidate, 0, new String[candidate.length()]);
  }
  //split it 
  //multiple ways of splitting an individual word
  //and check if each exists 
  
  //if yes then store
  
 }

 public static void splitIt(String candiate, int splitSpacing, String[] splitTo){


 }

 public static Set<String> getCandidates(Set<String> set, 
  String[] careNumbers, String[] formedWord, int startingPoint){
  set.add(Arrays.toString(formedWord));
  for(int i = startingPoint; i < formedWord.length; i++){
    String curr = careNumbers[i];
    int allowed;
    if(( allowed = map.get(curr).size()) != 0){
      for(int j = 1; j < allowed;j++){
        formedWord[i] = map.get(curr).get(j);
         getCandidates(set, careNumbers, formedWord, startingPoint+1);
      }
    }
  }
  return set;
 }


 public static void combinations(String str){
  List<String> combs = new ArrayList<>(); 
  
 }

 public static void main(String[] args){
  decompose("1-800-234");
  decompose("1-800-487-8647");
  // List<String> list = new ArrayList<>();
  // System.out.println(list.size());
  combinations("123");
 }
}