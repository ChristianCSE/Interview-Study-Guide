import java.util.*;

class payments {



  public static int[] owes(String[] payments){
   Map<String, HashMap<String, Integer>> map = 
   new HashMap<>();

   for(String transaction: payments){
    //is the person they are paying, already exist

    String[] owes = transaction.replace(" owes ", " ").split(" ");
    String a = owes[0];
    String b = owes[1];
    Integer c = Integer.parseInt(owes[2]);
    if(!couldBePaying(b, a, c, map)){
     //is owed
     //needsPayment(a, b, c, map);
    }


    if(map.containsKey(a)){
     //that means possibly there already
     if(map.get(a).containsKey(b)){

     }
    }
    System.out.println(Arrays.toString(owes));
   }


   return null;
  }

  public static boolean couldBePaying(String a, String b, Integer isOwed, Map<String, HashMap<String, Integer>> map){
   if(map.containsKey(a)){
    //already owed by others
    if(map.get(a).containsKey(b)){
     //this person owes more on top of recent
     
    }
   }
  }

  public static boolean couldBePaying(String a, String b, Integer paying, Map<String, HashMap<String, Integer>> map){
   if(map.containsKey(a)){
    if(map.get(a).containsKey(b)){
     Integer owes = map.get(a).get(b);
     Integer diff = owes - paying;
     if(diff == 0){
      map.get(a).remove(b);
      return true;
     } else{
      map.get(a).put(b, diff);
      return true;
     }
    }
   }
   return false;
  }


 public static void main(String[] args){
  String[] payments = new String[]{"A owes B 100", "B owes A 100"};
  owes(payments);
 }
}