


class Solution {
  

  public static void main(String[] args) throws Exception{
    ArrayStacks myStacks = new ArrayStacks(2);
    myStacks.add(1, 10);
    myStacks.add(1, 100);
    myStacks.add(0, 100);
    myStacks.add(0, 100);
    myStacks.printStacks();
    System.out.println("\nPOPPED HEAD=> " + myStacks.pop(0));
    myStacks.printStacks();
    myStacks.add(0, 300);
    myStacks.printStacks();
    System.out.println("\nPOPPED HEAD=> " + myStacks.pop(0));
    myStacks.printStacks();
    System.out.println("\nPOPPED HEAD=> " + myStacks.pop(0));
    myStacks.printStacks();
    myStacks.peek(0);
  }
}