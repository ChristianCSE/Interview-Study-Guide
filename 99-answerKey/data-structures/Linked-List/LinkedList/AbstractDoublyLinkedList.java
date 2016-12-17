package LinkedLists;

import DoublyLinkedList.Node;

/*===================================================
These are the methods every  Linked Lists should have: Interface
 ===================================================*/
public abstract class AbstractDoublyLinkedList{

/*================================================
SETTERS
================================================*/
	public abstract void putNode(int data);

	public abstract void newHead(int head);

	public abstract void putMultiNodes(int[] nodes);

	public abstract Node removeHead() throws Exception;

	public abstract  Node removeTail() throws Exception ;

	public abstract void deleteNode(int data) throws Exception ;

	public abstract void autoLinkedList(int size);

/*================================================
GETTERS
================================================*/
public abstract int getSize();

public abstract Node getHead();

public abstract void listToString();

}
