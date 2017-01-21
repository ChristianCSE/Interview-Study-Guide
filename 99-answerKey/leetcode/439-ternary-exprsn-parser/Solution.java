import java.util.*; 
class Solution{

//similar to reverse polish notation 
	public static String parseTernary(String expression){
        if(expression == null){return "";}
        int len = expression.length(); 
        Deque<String> stack = new ArrayDeque<>(); 
        String current; 
        String[] expr = expression.split("");
        for(int i = len-1; i >= 0; i--){
            current = expr[i];
            if(!stack.isEmpty() && stack.peek().equals("?")){
                //?T:F
                stack.pop();
                String yep = stack.pop();
                stack.pop();
                String nope = stack.pop();
                if(current.equals("T")){
                    stack.push(yep);
                } else{ 
                    stack.push(nope);
                }
            }
            else {
                stack.push(current);
            }
        }
        return stack.pop();
    }





	public static void main(String[] args){
		String candidate = "T?2:3";
		System.out.println(parseTernary(candidate));
		candidate = "T?T?1:3:4";
		System.out.println(parseTernary(candidate));
	}
}