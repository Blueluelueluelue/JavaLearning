import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        int i = 0;
        boolean done = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter an Integer between 1 and 10");
                i = sc.nextInt();

                //IntegerOutOfRangeException is a custom Exception. Custom exceptions can be created by creating a new
                //class with the name of the custom exception and then extending the Exception class with it.
                if(i<1 || i>10) throw new IntegerOutOfRangeException(); //This expression will throw an object of IntegerOutOfRangeException
                done = true;                                            //if i does not lie in the range 1 to 10
                System.out.println("You entered " + i);
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter an integer");
            } catch (IntegerOutOfRangeException e){                     //catch statements can be used to catch custom exceptions as well
                System.out.println("The integer is out of range");
            } finally {
                System.out.println("This will always run");             //the code in the finally block will always run no matter
            }                                                           //if there was an exception encountered in try or not.
        } while (!done);
    }
}
