/*
Reimplement
Current State: Sloppy and Slowly Done

 */

import java.util.*;

class StackOfPlates {
  
  //implement your own stack; rather than ArrayDeque<>()
  List<Stack> stacks = new ArrayList<>(); 
  int stackSize; 
  
  /*is this needed? No, since we can just do stacks.size() - 1 */
  //int stackOn; 
  
  public StackOfPlates(int stackSize){
    this.stackSize = 0;
  } 

  public void push(int data) {
    Stack last = getlastStack(); //adding to newest stack
    //either our current stack is full OR never inited a stack 
    if (last != null && last.isFull()) {
      last.push(data);
    }
    else {
      //make a new stack, add your data into it and add it to our List of stacks
      Stack newStack = new Stack(stackSize);
      stacks.add(newStack);
      newStack.push(data);
    }
    
  }

  public int pop(){
    Stack last = getlastStack(); 
    if(last!=null) {
      int popped = last.pop();
      //did we clear the stack ?
      if(last.size() == 0) {
        //remove it from our list
        stacks.remove(stacks.size() - 1);
      }
      return popped;
    } else {
      return -1; //or throw exception
    }
  }

  public int popFromStack(int index) {
    return leftShift(index, true);
  }

  //Probably most important part of this problem!
  public int leftShift(int index, boolean removeTop) {
    //Get stack 
    Stack stack = stacks.get(index);
    int removed;
    //are we removing top or bottom?
    //Both of these could empty out their stacks 
    //=> remember to remove the stack from our list of stacks if that's the case
    if(removeTop) {
      removed = stack.pop();
    } else {
      removed = stack.removeBottom();
    }
    if(stack.size() == 0) {
      stacks.remove(index); //everything shifts to the left 
    } else if(index + 1 < stacks.size()) {
      //retrieve a node from the stack that comes after and insert it to our current stack
      //we will be removing from the bottom of the next node!
      int bottomFromStackAhead = leftShift(index + 1, false);
      stack.push(bottomFromStackAhead);
    }
    return removed;
  }

  public Stack getlastStack(){
    int len = stacks.size();
    if(len == 0) return null; //haven't inited
    return stacks.get(len-1);
  }

}

/*
An individaul stack: Abstracts the concept of Nodes from StackOfPlates
 */
class Stack {
  //we will have top & bottom pointers (allows for shifting resizing)
  Node top, bottom;
  int capacity;
  int size; 
  public Stack(int capacity){
    this.capacity = capacity;
  }

  /*
  Just for the nodes NOT the stack top/bottom references
   */
  public void linkNodes(Node newHead, Node oldHead) {
    if(oldHead!=null) {
      newHead.below = oldHead;
      oldHead.above = newHead;
    }
  }

  /*
  Abstract the fact that they are Nodes with pointers
   */
  public boolean push(int data){
    if(isFull()){
      return false; //cannot push anymore!
    }
    Node newHead = new Node(data);
    //do we have a bottom at all? 
    if(size == 0) {
      bottom = newHead;
    }
    //link it with the old head, make old head our bottom 
    linkNodes(newHead, top);
    top = newHead;
    return true;
  }

  public int pop(){
    //shouldn't need to treat this since we would've removed the entire list if it got to 0
    if(size==0) {
      return -1;
    }
    Node oldTop = top;
    size--;
    top = top.below;
    //nullify the previous refernce to old top
    if(top!= null) top.above = null; 
    return oldTop.data;
  }

  public int removeBottom() {

    //should not be empty! if it was it would've been removed!
    Node prevBottom = bottom;
    bottom = bottom.above; //new bottom is what is above this bottom
    if(bottom != null){
      //if new bottom is an element, we need to update it's own bottom ref (we just removed it)
      //nullify it (lose complete reference to old bottom)
      bottom.below = null;
    }

    return prevBottom.data;
  }


  public boolean isFull(){
    return (size == capacity);
  }

  public int size(){
    return size;
  }

}

class Node {
  Node above;
  Node below;
  int data; 
  public Node(int data) {
    this.data = data;
  }
}