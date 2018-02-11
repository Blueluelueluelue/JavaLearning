abstract class Human            // an abstract class
{
  public abstract void eat();   // an abstract method
  //If an abstract method is declared inside a class then the class becomes abstract
  // It is not necessary to have any abstract methods in an abstract class
  // but it is necessary that the class which contains an abstract method
  // is an abstract class
  public void walk() {

  }
}

class Man extends Human         // a Concrete class
{
  public void eat() {            // if a class extends an abstract class then
    System.out.println("A Man is eating");      //it has to define the
  }                                 //methods inside it's abstract parent class
}                                   // which are abstract, not doing that will cause error


class Woman extends Human
{
  public void eat() {
    System.out.println("A Woman is eating");
  }
}

public class Abstract
{
  public static void main(String[]args)
  {
    Human obj = new Man();
    obj.eat();                  //output - A Man is eating
    Human obj1 = new Woman();
    obj1.eat();                  //output - A Woman is eating
  }
}
