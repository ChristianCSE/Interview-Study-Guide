import java.util.*;
class Best {


 public static void flipped(int[][] board, List<Integer[]> dead, List<Integer[]> light){
  Map<Integer, List<Integer>> deadareas = new HashMap<>();
  Map<Integer, List<Integer>> litareas = new HashMap<>();
  int now = 0;
  int rowlen = board.length;
  for(Integer[] arr : dead){
    getBanned(arr[0], arr[1], rowlen, board[now].length, deadareas);
    now++;
  }
  now = 0;
  rowlen = board.length;
  for(Integer[] arr: light){
    getDiagonals(arr[0], arr[1], rowlen, board[now].length, litareas);
    now++;
  }

  for(Integer rows : litareas.keySet()){
    for(Integer cols : litareas.get(rows)){
      if(deadareas.containsKey(rows) && !deadareas.get(rows).contains(cols)){
        board[(int)rows][(int)cols] = 1;
      }
      if(!deadareas.containsKey(rows)){
        board[(int)rows][(int)cols] = 1;
      }
    }
  }
  
  for(int i = 0; i < rowlen; i++){
    System.out.print(i+"      ");
    for(int j = 0; j < board[i].length; j++){
      System.out.print(board[i][j]+" | ");
    }
    System.out.println();
  }
 }


 public static void getDiagonals(int row, int col, int rows, int cols, 
  Map<Integer, List<Integer>> map){
  placer(row, col, map);
  int upLeftR = row-1;
  int upLeftC = col-1;
  //     \
  while( upLeftR >= 0 && upLeftC >= 0){
    placer(upLeftR, upLeftC, map);
    upLeftR--;
    upLeftC--;
  }

  //     \
  int downLeftR= row+1;
  int downLeftC= col-1;
  while(downLeftC >= 0 && downLeftR < rows){
    placer(downLeftR, downLeftC, map);
    downLeftR++;
    downLeftC--;
  }

  //  /
  int upRightR= row-1;
  int upRightC= col+1;
  while (upRightR >= 0 && upRightC < cols){
    placer(upRightR, upRightC, map);
    upRightR--;
    upRightC++;
  }
  
  //    /
  int downRightR= row+1;
  int downRightC= col-1;
  while (downRightR < rows && downRightC >= 0){
    placer(downRightR, downRightC, map);
    downRightR++;
    downRightC--;
  }

  int leftCols = col-1;
  while(leftCols >= 0){
    placer(row, leftCols, map);
    leftCols--;
  }

  int rightCols = col+1;
  while(rightCols < cols){
    placer(row, rightCols, map);
    rightCols++;
  }

  int upRow = row-1;
  while(upRow>=0){
    placer(upRow, col, map);
    upRow--;
  }

  int downRow = row+1;
  while(downRow<rows){
    placer(downRow, col, map);
    downRow++;
  }

 }

 public static void placer(int row, int col, Map<Integer, List<Integer>> map){
  if(map.containsKey(row)){
    map.get(row).add(col);
  }
  else{
    map.put(row, new ArrayList<>());
    map.get(row).add(col);
  }
 }

 public static void getBanned(int row, int col, int rows, int cols,
  Map<Integer, List<Integer>> map){
  placer(row, col, map);
  
  //   x
  //     \
  int leftrowup = row-1;
  int leftcolup = col-1;
  if(leftrowup >= 0 && leftcolup >= 0){
    placer(leftrowup, leftcolup, map);
  }

  //     \
  //       x
  int leftuprow = row+1;
  int leftupcol = col+1;
  if(leftuprow < rows && leftupcol < cols){
    placer(leftuprow, leftupcol, map);
  }

  //     /
  //   x
  int rightdownrow = row+1; 
  int rightdowncol = col-1;
  if(rightdownrow < rows && rightdowncol >= 0){ 
    placer(rightdownrow, rightdowncol, map);
  }

  //     x
  //   /
  int rightuprow = row-1; 
  int rightupcol = col+1;
  if(rightuprow < rows && rightupcol < cols){
    placer(rightuprow, rightupcol, map);
  }

  //            ^
  //  above |
  int above = row-1;
  if(above >= 0){
    placer(above, col, map);
  }

  //below |
  //          v
  int below = row+1; 
  if(below<rows){
    placer(below, col, map);
  }

  // left <-
  int left = col-1;
  if(left >= 0){
    placer(row, left, map);
  }

  // right ->
  int right = col+1;
  if(right < cols){
    placer(row, right, map);
  }

 }




 public static String[] solver(int[][] board){
  Map<Integer, Integer> lights = new HashMap<>();
  lights.put(4, 5);
  lights.put(4, 6);
  Map<Integer, List<Integer>> nokills = new HashMap<>();
  getDiagonals(4, 5, 8, 8, nokills);
  getDiagonals(4, 6, 8, 8, nokills);
  List<Integer[]> dead = new ArrayList<>();
  dead.add(new Integer[]{3, 4});
  dead.add(new Integer[]{7, 6});
  String[] finalizer = new String[2];
  int now = 0;
    for(Integer[] arr : dead){ 
     Map<Integer, List<Integer>> banned = new HashMap<>();
     getBanned(arr[0], arr[1], 8, 8, banned);
    Map<Integer, List<Integer>> lightupvalid = new HashMap<>();
    Map<Integer, Integer> validLamps = new HashMap<>();
    for(Integer aRow : lights.keySet()){
     List<Integer> cols = banned.get(aRow); //could be null
     if(cols!=null){
      if(!cols.contains(lights.get(aRow))){
       validLamps.put(aRow, lights.get(aRow));
      }
     }
    }
    if(validLamps.size()!=0){
    for(Integer row : validLamps.keySet()){
     getDiagonals(row, validLamps.get(row), 8, 8, lightupvalid);
    }
    if(lightupvalid.get(arr[0]).contains(arr[1])){
     finalizer[now] = "LIGHT";
     now++;
    } else {
     finalizer[now] = "DARK";
     now++;
    }
    }
    else {
     if(nokills.get(arr[0]).contains(arr[1])){
      finalizer[now] = "LIGHT";
      now++;
     } else {
      finalizer[now] = "DARK";
      now++;
     }
    }
  }
  System.out.println(Arrays.toString(finalizer));
  return finalizer;
  // return new String[1];
 }

 public static void main(String[] args){
 // int[][] board = {{0, 0, 0, 0,0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0 }, {0, 0, 0, 0, 0}};
  int[][] board = {
   {0, 0, 0, 0, 0, 0, 0, 0}, 
  {0, 0, 0, 0, 0, 0, 0, 0},  
  {0, 0, 0, 0, 0, 0, 0, 0},  
  {0, 0, 0, 0, 0, 0, 0, 0}, 
  {0, 0, 0, 0, 0, 0, 0, 0}, 
  {0, 0, 0, 0, 0, 0, 0, 0}, 
  {0, 0, 0, 0, 0, 0, 0, 0}, 
  {0, 0, 0, 0, 0, 0, 0, 0}
 };
 solver(board);
  // List<Integer[]> ban = new ArrayList<>();
  // ban.add(new Integer[]{1, 1});
  // ban.add(new Integer[]{3, 4});
  // List<Integer[]> alive = new ArrayList<>(); 
  // alive.add(new Integer[]{2, 3});
  // alive.add(new Integer[]{5, 5});
  // flipped(board, ban, alive);
 }
}
// Pretty hard question. The hard part was when you had an adjacent person to the lamp since you couldn't simply void the spaces in its region rather you had to void the lamps that were in the region (so another lamp could still shine through). In other words, you couldn't nullify the 8 spots (9 when we include the person as well) since a lamp could have not touched the area; hence, valid so that spot can still be lit up. My approach was to kill lamps one by one, reconstruct the lit areas with the remaining lights and check if the person is still valid. I cached a perfect lit up board in the case where no bulbs were dimmed out, since in this case we wouldn't need to reconstruct the board. 
// So: 
// New board, check if still valid, => "LIGHT" or "DARK"
// The reason I did it like this is that a spot can be lit by more than 1 lamp; hence we have to know the source of the lit spot, since we could dim one lamp but that wouldn't dim out the region since another lamp could be lighting it too.