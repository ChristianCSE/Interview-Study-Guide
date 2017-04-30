import java.util.*; 
/*
reads user input and stores in an array; prints the array 
filed with String objects
**/
class readusrinput{

  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String usr; 
    String[] store = new String[10]; 
    int len = store.length; 
    int i = 0; 
    while( ( ( usr = input.nextLine() ) != null) && i < len ) 
    {
      store[i] = usr; 
      i++; 
    }
    System.out.println( Arrays.deepToString(store) );
  }
}
