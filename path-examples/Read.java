import java.util.Scanner;
class Read {
  public static void main(String[] args) {
    System.out.print("What's your name? ");
    Scanner in;
    in = new Scanner(System.in);
    String s = in.nextLine();
    System.out.println("Hello " + s);
  }
}
