public class Student
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
        return this.name + "\t" + this.gpa;
    }

}
