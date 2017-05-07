import java.util.*;

public class Solution {

  /*
  public static int minMeetingRooms(Interval[] intervals) {
    
    List<Interval> arr = new ArrayList<>();
    //could maintain order, but don't
    int rooms = 0;
    //N
    for(Interval individual : intervals) {
      int candidate = individual.end;
      System.out.println(candidate);
      for(Interval clocked : arr) {
        if( (clocked.start < candidate) && (candidate < clocked.end) ) {
          rooms++; 
          break;
        }
      }
      System.out.println("broke");
      arr.add(individual);
    }
    System.out.println(rooms);
    return 0;
  }
  */
 
 //completely thought of the problem wrong
 public static int minMeetingRooms(Interval[] intervals) {
  if(intervals.length < 1) return 0;
  int[] rooms = new int[intervals.length];
  for(int i = 0; i < rooms.length; i++){
    rooms[i] = 1;
  }
  List<Interval> arr = new ArrayList<>();
  int now = 0;
  for(Interval slottedTime: intervals) {
    
    for(int i = arr.size() - 1; i >= 0; i--) {
      Interval inside = arr.get(i);
      System.out.println(slottedTime.start);
      boolean startConflict = (inside.start <= slottedTime.start && slottedTime.start <= inside.end);
      boolean endConflict = (inside.start < slottedTime.end && slottedTime.end <= inside.end);
      System.out.println("start=>"+ startConflict + " end => " + endConflict);
      if(startConflict || endConflict) {
        rooms[now] = rooms[i] + 1;
        System.out.println(rooms[now]);
        break;
      }
    }

    arr.add(slottedTime);
    now++;
  }
  Arrays.sort(rooms);
  return rooms[rooms.length-1];
 }

  public static void main(String[] arg) {

    /*Interval one = new Interval(0, 30); //no
    Interval two = new Interval(5, 10); //conflict
    Interval three = new Interval(15, 20); //no
    Interval four = new Interval(18, 20); //conflict
    Interval five = new Interval(24, 32); //conflict
    Interval six = new Interval(40, 50); //no
    Interval[] arr = new Interval[]{one, two, three, four, five, six};
    */
    // Interval one = new Interval(9, 10);
    // Interval two = new Interval(4, 9);
    // Interval three = new Interval(4, 17);
    // Interval[] arr = new Interval[]{one, two, three};
    // 
    Interval one = new Interval(6, 15);
    Interval two = new Interval(13, 20);
    Interval three = new Interval(6, 17);
    Interval[] arr = new Interval[]{one, two, three};
    minMeetingRooms(arr);
    
  }
}

class Interval {
  int start; 
  int end; 
  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

}


