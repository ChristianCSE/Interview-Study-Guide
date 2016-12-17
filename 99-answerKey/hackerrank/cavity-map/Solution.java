
class Solution {

	public static void main(String[] args) {
	//cavity = not on the border of the map
	//and each cell adjacent to it is smaller depth
	String[] grid = new String[]{"1112", "1912", "1892", "1234"};
	int len = grid.length;

	//start at 1 since no edges
	//end at <len -1 since non
	for(int row = 1; row < len-1; row++){
		for(int num = 1; num < len-1; num++){
			char candidate = grid[row].charAt(num);
			char up = grid[row-1].charAt(num);
			char down = grid[row+1].charAt(num);
			char left = grid[row].charAt(num-1);
			char right = grid[row].charAt(num+1);
			if(candidate > up && candidate > down && candidate > left && candidate > right) {
				grid[row] = grid[row].substring(0, num) + 'X' + grid[row].substring(num+1);
			}
		}
	}

	for(int k = 0; k < len; k++){
		System.out.println(grid[k]);
	}
	}

}