import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Create a file object
        File file = new File("students.txt");

        //Create the student array list and populate it
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Tom", 3.2));
        studentList.add(new Student("Sally", 2.5));
        studentList.add(new Student("Bob", 1.8));

        //Create FileOutputStream and ObjectOutputStream objects so that I can serialize the contents of the studentList
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        for(Student st : studentList) {
            objectOutput.writeObject(st);
        }

        //Always do cleanup code
        objectOutput.close();
        fileOutput.close();

        //Create FileInputStream and ObjectInputStream objects so that I can deserialize the contents of the text file
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);

        //Populating a different ArrayList<Student> with the contents of the text file
        ArrayList<Student> studentList2 = new ArrayList<>();

        /*
        The standard way of reading from disk is that put your reading statement inside a while(true) and wait
        for the inputstream to reach the end of the file. At this instant it will throw an exception that it has
        reached the end of file and there's nothing to read (EOFException) which you catch to exit the loop.
         */
        try {
            while(true) {
                Student st = (Student)objectInput.readObject();
                studentList2.add(st);
            }
        } catch (EOFException e) {
        }

        for(Student st : studentList2) {
            System.out.println(st);
        }

        //Always do cleanup code
        objectInput.close();
        fileInput.close();
    }
}
