import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random gen = new Random();
        int found;
        int target = 30;
        for(int i = 0; i < 20; i++)
            numbers.add(gen.nextInt(100)+1);
        System.out.println("UNSORTED");
        printNumbers(numbers);
        found = find(numbers, target);
        System.out.printf("%d was %s found\n", target, found>0 ? "" : "not");

        //Collections.sort() takes 2 parameters - the ArrayList<> of the objects you want to sort,
        //and the object of Comparator which the method will use to identify whether an object is
        //less than, greater or equal to another object.
        Collections.sort(numbers, new IntegerComparator());
        System.out.println("SORTED");
        printNumbers(numbers);

        //Collections.binarySearch() takes 3 parameters - the ArrayList<> of the objects you want to search inside,
        //the target you are looking for, and the object of Comparator which the method will use to identify if
        //what it's scanning is either less than, equal to or greater than the target
        found = Collections.binarySearch(numbers, target, new IntegerComparator());
        System.out.printf("%d was %s found\n", target, found>0 ? "" : "not");

        /*Student tom = new Student("Tom" , 3.84);
        Student sally = new Student("Sally" , 2.554);
        Student bob = new Student("Bob" , 3.511);*/
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Tom" , 3.84));
        students.add(new Student("Sally" , 2.554));
        students.add(new Student("Bob" , 3.511));
        printStudents(students);

        System.out.println("SORTED BY NAME\n");
        Collections.sort(students, new StudentNameComparator());
        printStudents(students);

        System.out.println("SORTED BY GPA\n");
        Collections.sort(students, new StudentGpaComparator());
        printStudents(students);


    }

    public static void printNumbers(ArrayList<Integer> numbers) {
        for(int i: numbers)
            System.out.printf("%d ",i);
        System.out.println();
    }

    public static int find(ArrayList<Integer> numbers, int key) {
        int found = -1;
        for(int i = 0; i < numbers.size(); i++)
            if(numbers.get(i) == key)
                found = i;
        return found;
    }

    public static void printStudents(ArrayList<Student> students) {
        System.out.println("Student\tGPA");
        System.out.println("-------\t---");
        for(Student s: students) {
            System.out.println(s);
        }
        System.out.println();
    }
}
