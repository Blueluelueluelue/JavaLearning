import java.lang.*;
import java.util.Scanner;

// Pattern which this program outputs-
//           A
//          ABA
//         ABCBA
//        ABCDCBA

class PatternTriangleCapitalLetters {
  public static void main(String[]args) {
    int lines;
    char c = 'A';
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of lines");
    lines = sc.nextInt();
    for(int i = 1; i <= lines; i++) {
      for(int j = 1; j <= lines-i; j++) {
        System.out.print(" ");
      }
      for(int j = 1; j <= i; j++) {
        System.out.print(c++);
      }
      c--;
      for(int j = 1; j < i; j++) {
        System.out.print(--c);
      }
      for(int j = 1; j <= lines-i; j++) {
        System.out.print(" ");
      }
      System.out.println();
      c = 'A';
    }
  }
}
