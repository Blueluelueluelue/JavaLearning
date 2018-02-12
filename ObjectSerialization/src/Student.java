import java.io.Serializable;

/*
If you want to make it so that objects of a class are serializable (i.e. you can write them on disk) you have
to make that class implement the Serializable interface or else the objects created using that class won't be
Serializable and you get an error. The Serializable interface is inside java.io package so don't forget to import it.
 */
public class Student implements Serializable
{
    private String name;
    private double gpa;

    /**
     * Creates a new Student object with 2 parameters name and gpa.
     * @param name is the String name.
     * @param gpa is the double gpa.
     */
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return this.name + "\t\t" + this.gpa;
    }

}
