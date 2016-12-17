import java.util.*;
class autocomp{



 public static void main(String[] args){
  Trie t = new Trie(); 
  String[] dict = new String[]{"apple", "apples", "app", "aplets", "applez", "apz"};
  for(String word:dict){
   t.insertWord(word);
  }
  t.autoplete("app");
  }
 }


class Trie{
 Node root; 
 public Trie(){
  root = new Node("");
 }
 public void insertWord(String word){
  Node pointer = this.root; 
  for(String letter:word.split("")){
    if(pointer.children.containsKey(letter)){
     pointer = pointer.children.get(letter);
    }
    else{
     pointer.children.put(letter, new Node(letter));
     pointer = pointer.children.get(letter);
    }
  }//split
  pointer.setEndOfWord();
 }

 public List<String> autoplete(String candidate){
  //go to candidates stopping point! which is the end of this word
  //return null if invalid 
  Deque<Node> queue = new ArrayDeque<>();
  Deque<String> prefix = new ArrayDeque<>();
  Node pointer = root;
  for(String letter : candidate.split("")){
   pointer = pointer.children.get(letter);
  }
  queue.push(pointer);
  List<String> recomend = new ArrayList<>();
  
  // if(pointer.endOfWord){
  //  recomend.add(candidate);
  //  System.out.println("yep");
  // }
  String currentLetter;
  Node curr; 
  String pre = candidate;
  while(!queue.isEmpty()){
   curr = queue.poll();//(p)--> (l) Node
   pre = prefix.poll(); //String Word
   if(curr.endOfWord){
    recomend.add(pre);
   }
   Iterator it = curr.children.entrySet().iterator();
   while(it.hasNext()){
    Map.Entry indivLetter = (Map.Entry)it.next();
    prefix.push(pre+indivLetter.getKey());
    queue.push((Node)indivLetter.getValue());
   }
  }
  return recomend;
 }
}

class Node{
  String letter; 
  boolean endOfWord;
  Map<String, Node> children; //could 
  public Node(String letter){
   this.letter =letter;
   children = new HashMap<>(26);
  }
  public void setEndOfWord(){
   endOfWord=true;
  }
}