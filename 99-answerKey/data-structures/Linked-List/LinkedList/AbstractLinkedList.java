package LinkedLists;

import SinglyLinkedList.Node;
//this is how it is allowed to used Node 

/*===================================================
These are the methods every  Linked Lists should have: Interface
 ===================================================*/
public abstract class AbstractLinkedList{

/*================================================
SETTERS
================================================*/
	public abstract void putNode(int data);

	public abstract void newHead(Node head);

	public abstract void putMultiNodes(int[] nodes);

	public abstract Node removeHead() throws Exception;

	public abstract  Node removeTail();

	public abstract Node deleteNode(int data); 

	public abstract void autoLinkedList(int size);

/*================================================
GETTERS
================================================*/
public abstract int getSize();

public abstract Node getHead();

public abstract void listToString();

}
