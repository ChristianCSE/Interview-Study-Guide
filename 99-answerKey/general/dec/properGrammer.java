
class properGrammer {
  
  static public void rollcall(String[] names) {
   if(names.length < 2)
   {
    System.out.println(names[0]);
   }
   int len = names.length;  //4
   int lastname = len - 1; //3
   String rollcalling = names[0];
   for(int i = 1; i < len; i++) {
    if(lastname == i) {
     rollcalling = rollcalling + ", and " + names[i]; 
    }
    else{
     rollcalling = rollcalling + ", " + names[i]; 
    }
   }
   System.out.println(rollcalling);
  }

  static public void summation(String[] names, int limit){
   int len =  names.length;
   int leftovers = len - limit; 
   String rollcall = names[0];
   for(int i = 1; i < limit; i++) {
    if(i==1 && i+1== limit) {
     rollcall = rollcall + " and " + names[i];
    } 
    else if(limit-1 == i && leftovers == 0) {
     rollcall = rollcall + ", and " + names[i];
    }
    else{
    rollcall = rollcall + ", " + names[i];
    }
   }
   if(leftovers != 0){
    rollcall = rollcall + ", and " + leftovers + " more";
    System.out.println(rollcall);
   }
   else{
    System.out.println(rollcall);
   }

  }



  public static void main(String[] args) {
   rollcall(new String[]{"John", "Steven", "Adam", "Computer", "Nancy", "Jeb", "Apple"});
   summation(new String[]{"John", "Steven", "Adam", "Computer", "Nancy", "Jeb", "Apple"}, 1);
  }
}