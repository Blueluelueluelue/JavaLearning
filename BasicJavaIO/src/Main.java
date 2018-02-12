import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        File txtFile = new File("test.txt");

        //Write to the file
        try {
            PrintWriter p = new PrintWriter(txtFile);
            p.print("Hello");
            p.println(" World");
            p.println(56);
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("%s\n", e);
        }

        //Read From a file
        try {
            Scanner sc = new Scanner(txtFile);
            String hello = sc.nextLine();
            int i = sc.nextInt();
            System.out.printf("%s and %d were found\n", hello, i);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("%s\n", e);
        }

    }
}
