import java.util.Scanner;

class Switch {
  public static void main(String[]args) {
    int marks;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter marks");
    marks = sc.nextInt();
    switch((int)marks/10) {
      case 0:
      case 1:
      case 2:
      case 3:
        System.out.println("Fail");
        break;
      case 4:
        System.out.println("Pass");
        break;
      case 5:
        System.out.println("Second Class");
        break;
      case 6:
        System.out.println("First Class");
        break;
      case 7:
      case 8:
      case 9:
      case 10:
        System.out.println("Distinction");
        break;
      default:
        System.out.println("Invalid marks");
    }
  }
}
