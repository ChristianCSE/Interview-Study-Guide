import java.util.*;
class Solution{


 static public void printMenu(String[] menu, double[] prices, double cash){

 }

 
 static public void simplePrint(List<Node> cart, double cash) {
  // Deque<>
 }


 public static void main(String[] args){
  String[] menu = new String[]{"apple", "berry", "pie", "water"};
  double[] prices = new double[]{1.20, 1.30, 10.30, 2.30};
  double salary = 30.00; 
  List<Node> shopping = new ArrayList<>();
  for(int i = 0; i < menu.length; i++)
   shopping.add(new Node(prices[i], menu[i]));
  simplePrint(shopping, salary);
 }
 // printMenu(menu, prices, salary);

}


class Node {
 double price;
 String item;
 public Node(double price, String item){
  this.price = price;
  this.item=item;
 }
}