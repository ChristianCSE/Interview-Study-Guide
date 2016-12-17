
#Queue API:

[Java SDK](http://hg.openjdk.java.net/jdk6/jdk6/jdk/file/c228a234a3f3/src/share/classes/java/util/Queue.java)
<br/>[Sedgewick](http://algs4.cs.princeton.edu/13stacks/Queue.java.html)

###Queue API defined by CTIC & Sedgewick
add(item) <br/>
remove() <br/>
peek() <br/>
isEmpty() <br/>
int size () [sedgewidge] <br/>

###Queue in Java JDK
public interface Queue<E> extends Collection<E> <br/>
boolean add(E e) <br/>
boolean offer(E e) <br/>
E remove() ( throws exception if empty ) <br/>
throw new NoSuchElementException() <br/>
E poll() (null if head is empty) <br/>
E element() <br/>
E peek() <br/>
void clear() <br/>
public boolean addAll(Collection<? extends E> c) <br/>
