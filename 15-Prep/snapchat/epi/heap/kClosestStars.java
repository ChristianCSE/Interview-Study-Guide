import java.util.*;

class kClosestStars {

  public static List<Star> findKClosest(int k, Iterator<Star> iter) {
    //PQ defaults to min 
    PriorityQueue<Star> maxHeap = new PriorityQueue<Star>(k, new Comparator<Star>(){
      public int compare(Star a, Star b){
        return (-1)*Integer.compare(a.distance, b.distance);
        /*
        if(a.distance < b.distance) return 1;
        else if(a.distance > b.distance)  return -1;
        return 0;
        */
      }
    });

    for(int i = 0; i < k && iter.hasNext(); i++) {
      maxHeap.add(iter.next());
    }

    //flush out the heap
    while(iter.hasNext()) {
      maxHeap.add(iter.next());
      maxHeap.poll();
    }

    List<Star> kClosest = new ArrayList<>(maxHeap);
    
    //return the stars in order! 
    Comparator<Star> cmp = new Comparator<Star>(){
      public int compare(Star a, Star b) {
        return Integer.compare(a.distance, b.distance);
      }
    };

    Collections.sort(kClosest, cmp);
    return kClosest;
  }


  public static void main(String[] args) {
    List<Star> galaxy = new ArrayList<>();
    Star holding;
    for(int i = 0; i < 10; i++) {
      galaxy.add(new Star( (int)(Math.random() * 10) , (int)(Math.random() * 10), (int)(Math.random() * 10)));
    }
    for(Star s: galaxy){
      System.out.println(s.distance);
    }

    Iterator<Star> iter = galaxy.iterator();
    List<Star> inOrder = findKClosest(3, iter);
    System.out.println("<=====================>");
    for(Star s: inOrder){
      System.out.println(s.x + " " + s.y + " " + s.z);
      System.out.println(s.distance);
    }
  }
}

class Star {
  int x;
  int y;
  int z;
  int distance; 
  
  public Star(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.distance = (int)Math.sqrt((x*x) + (y*y) + (z*z));
  }

}