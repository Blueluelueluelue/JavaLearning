import java.util.Scanner;

// 1 - 1/2 + 1/3 - 1/4 + 1/5.....

class Series3 {
  public static void main(String[]args) {
    float terms, sum=0;
    Scanner sc = new Scanner(System.in);
    System.out.println("No. of terms");
    terms = sc.nextInt();
    for(int i = 1; i <= terms; i++) {
      if(i % 2 == 0) {
        sum = sum - 1/(float)i;
        System.out.print(" - 1/"+i+" ");
      }
      else {
          sum = sum + 1/(float)i;
          if(i == 1)
            System.out.print(1);
          else
            System.out.print("+ 1/"+i);
      }
    }
    System.out.println(" = "+sum);
  }
}
