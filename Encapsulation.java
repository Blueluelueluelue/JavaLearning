// Encapsulation -> Binding data with methods, i.e. someone can't change the
// variables without using methods

class Student
{
  private int rollno;
  private String name;

  // Getters and Setters

  public void setRollno(int rollno) {
    this.rollno = rollno;
  }
  public int getRollno() {
    return rollno;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
}

class Encapsulation
{
  public static void main(String[]args)
  {
    Student s = new Student();
    s.setRollno(5);
    s.setName("Katya");
    System.out.println("Rollno : "+s.getRollno()+"\nName : "+s.getName());
  }
}
