

class gcd {

  public static int getgcd(int a, int b) {
    //Euclid's algorithm 
    return (b == 0) ? a : getgcd(b, a%b);
  }

  public static void main(String[] args) {
    System.out.println(getgcd(156, 36));
  }

}