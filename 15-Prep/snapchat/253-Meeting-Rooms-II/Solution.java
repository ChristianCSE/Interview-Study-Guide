import java.util.*; 

class Solution {
  
  public int minMeetingRooms(Interval[] interval) {
    return 0;
  }


  public static void main(String[] args) {
    Solution caller = new Solution(); 
    caller.minMeetingRooms(new Interval[]{new Interval(1,10)});
  }
}


class Interval {
  int start; 
  int end; 
  public Interval(int start, int end) {
    this.start = start; 
    this.end = end; 
  }
}