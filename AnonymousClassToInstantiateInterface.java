interface Abc
{
  void show();
  void dontShow();
}

abstract class A {
  abstract void dontDisplay();

  public void display(){
    System.out.println("I am useless");
  }

  public void aDifferentMethod() {
    System.out.println("aDifferentMethod");
  }
}

public class AnonymousClassToInstantiateInterface
{
  public static void main(String[]args)
  {

    Abc obj = new Abc() {         //normally you cannot create an object of an interface
      public void show() {        //you can only create reference of an interface but if you
        System.out.println("I am in show"); //use anonymous class to define the methods inside
      }                           //the interface then you can create its object
      public void dontShow() {
        //I have to define ALL methods which were declared in the interface or else it will give an error
      }
    };
    obj.show();

    A obj1 = new A() {            //I wanted a different functionality from the method display
      public void display() {     //than what's already defined up there, so I use anonymous class
          System.out.println("I am in display");  //to get that one time functionality. It's not
      }                           //necessary to define ALL the methods which were in the class in the anonymous class

      public void dontDisplay() {
        //But I have to define the abstrace methods in the class, not doing so will give an error
      }
    };
    obj1.display();
    obj1.aDifferentMethod();    //I can call the other methods of the class normally

  }
}
