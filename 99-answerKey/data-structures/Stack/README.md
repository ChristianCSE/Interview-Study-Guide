
#Stack API:

Most seem to define a stack as a Singly Linked List when making one implement it. Normally, it is written by extending to a Vector : <br/>
[Java SDK](http://hg.openjdk.java.net/jdk6/jdk6/jdk/file/c228a234a3f3/src/share/classes/java/util/Stack.java)
<br/>
[Sedgewick](http://algs4.cs.princeton.edu/13stacks/Stack.java.html)


###Stack API defined by CTCI & Sedgewick:
Stack() <br/>
void push(Item item) <br/>
Iterator pop() <br/>
boolean isEmpty() <br/>
int size() [Sedgewick] <br/>
String toString() [Sedgewick] <br/>
Iterator<Item> iterator [Sedgewick] <br/>



###Stack in Java JDK
public class Stack<E> extends Vector<E> <br/>
public E push(E item) <br/>
public E pop() <br/>
public E peek() <br/>
public boolean empty() <br/>
public int search(Object o) => Uses  lastindexof from Vector <br/>

 
