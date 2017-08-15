

class ArrayStacks {

  int numberOfStacks = 3;
  int[] values;
  int[] filled = new int[numberOfStacks];
  int stackSize; 

  public ArrayStacks(int stackSize) {
    this.stackSize = stackSize;
    this.values = new int[numberOfStacks*stackSize];
  }

  //currently what's open 
  public int getHeadIndex(int stack) {
    /*
    get the head of the desired stack 
    Formula = stack*stacksize (starting position) + filled so far - (0 or 1)
    if it has been filled then we subtract 1, since we'll be pointing ahead of the head
    if it's still empty, we get the correct position so no need to subtract
    */

    //int padding = (filled[stack] == 0) ? 0 : -1;
    int startsAt = stack*stackSize;
    int offset = filled[stack];
    return startsAt + offset;
  }

  public boolean isFull(int stack) {
    return filled[stack] == stackSize;
  }

  public boolean isEmpty(int stack) {
    return filled[stack] == 0;
  }

  /*
  add to head: is it full
  if not full, what is the next open spot! 
  getHeadIndex() returns what the head is (we need to +1 to get the empty spot)
   */
  
  public void add(int stack, int value) throws FullStackException{
    if(isFull(stack)) {
      System.out.println("ERROR: STACK "+ stack +" IS ALREADY FILLED UP!");
      throw new FullStackException(stack);
    }
    //if not filled that means we still have open space to fill
    int insertAt = getHeadIndex(stack); //move to empty index
    values[insertAt] = value;

    filled[stack]++; //update number of fillings
  }

  public int pop(int stack) throws EmptyStackException{
    if(isEmpty(stack)) {
      System.out.println("ERROR: STACK " + stack + " HAS NOTHING TO POP, EMPTY !!!");
      throw new EmptyStackException(stack);
    }
    //by now we are ensured it's filled so we get space for empty 
    
    int openIndex = getHeadIndex(stack);
    int filledAt = openIndex - 1;
    int currentHead = values[filledAt];
    values[filledAt] = 0;
    filled[stack]--;
    return currentHead;
  }

  public int peek(int stack){
    if(isEmpty(stack)){ 
      //faulty in returning 0
      System.out.println("\nEMPTY NOTHING TO PEEK FOR HERE!!!");
      return 0;
    }
    return values[getHeadIndex(stack)];
  }


  public void printStacks() {
    System.out.println();
    int len = values.length;
    for(int i = 0; i < len; i++) {
      if(i%(stackSize)==0) {
        System.out.println();
      }
      System.out.print(values[i] + " ");
    }
  }

}

class EmptyStackException extends Exception {
  int stack; 
  public EmptyStackException(int stack) {
    this.stack = stack;
  }
}

class FullStackException extends Exception {
  int stack; 
  public FullStackException(int stack) {
    this.stack = stack;
  }
}