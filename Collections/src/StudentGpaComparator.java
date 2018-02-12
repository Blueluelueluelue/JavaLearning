import java.util.Comparator;

public class StudentGpaComparator implements Comparator<Student> {
    /**
     * This method compares 2 Student objects and returns an int representing the greater than or less than or equal
     * to relationship of the 2 objects' gpa
     * @param o1 is the first Student object
     * @param o2 is the second Student object
     * @return returns 1 if the first object has higher gpa than the second object's gpa, 0 if they are equal and -1 if
     * the second object's gpa is greater than the first object's gpa.
     */
    @Override
    public int compare(Student o1, Student o2) {
        double diff = o1.getGpa() - o2.getGpa();
        if(diff < 0)
            return 1;
        else if(diff > 0)
            return -1;
        else
            return 0;
    }
}
