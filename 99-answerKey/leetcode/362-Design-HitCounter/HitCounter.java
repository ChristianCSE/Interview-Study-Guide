import java.util.*;
public class HitCounter {

    /** Initialize your data structure here. */
    Deque<Integer> deque;
    
    public HitCounter() {
        deque = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int within = timestamp - 300; 
        deque.push(timestamp);
        while(!deque.isEmpty() && (int)deque.peekLast() < within){
             deque.pollLast();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int within = timestamp - 300;
        while(!deque.isEmpty() && (int)deque.peekLast() <= within){
            deque.pollLast();
        }
        return deque.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */