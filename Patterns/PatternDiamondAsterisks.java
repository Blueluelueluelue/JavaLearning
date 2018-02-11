import java.lang.*;
import java.util.Scanner;

// Pattern which this program outputs-
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *

class PatternDiamondAsterisks {
  public static void main(String[]args) {
    int size;
    char c = '*';
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of diamond");
    size = sc.nextInt();

    // Displaying upper traingle

    for(int i = 1; i <= size; i++) {
      for(int j = 1; j <= size-i; j++) {
        System.out.print(" ");
      }
      for(int j = 1; j <= 2*i - 1; j++) {
        System.out.print(c);
      }
      for(int j = 1; j <= size-i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }

    // Displaying lower traingle

    for(int i = 1; i < size; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j < (size - i)*2; j++) {
        System.out.print(c);
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
