import java.util.Scanner;

public class Main {

    static <E> void printArray(E[] array) {
        for(E element : array) {
            System.out.println(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("What size of Integer array?");
        size = sc.nextInt();
        Integer[] intArray = new Integer[size];
        for(int i = 0; i < size; i++)
            intArray[i] = sc.nextInt();

        System.out.println("What size of String array?");
        size = sc.nextInt();
        String[] stringArray = new String[size];
        sc.nextLine();
        for(int i = 0; i < size; i++)
            stringArray[i] = sc.nextLine();

        System.out.println("You Entered");
        printArray(intArray);
        printArray(stringArray);
    }
}
