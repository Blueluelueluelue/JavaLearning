import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    /**
     * This method compares 2 Student objects and returns an int representing the greater than or less than or equal
     * to relationship of the 2 objects' name
     * @param o1 is the first Student object
     * @param o2 is the second Student object
     * @return returns a negative int if the first object's name String is less than the second object's name String,
     * 0 if they are equal, and a positive int if the second object's name String is less than the first object's name String.
     */
    @Override
    public int compare(Student o1, Student o2) {
         return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
