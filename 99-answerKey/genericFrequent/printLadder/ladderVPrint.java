class ladderVPrint{


  public static void printStairs(int n)
  {
    int j = 0, i; 
    for(i = n; i > 1; i--)
    {
      for(j = 0; j < i; j++)
      {
        System.out.print('*');
      }
      System.out.println();
    }
    for (i = 1; i <= n; i++) 
    {
      for (j = 0; j < i; j++) 
      {
        System.out.print('*');
      }
      System.out.println();
    }

  }

  public static void main(String[] args)
  {
    printStairs(5);
  }
}
