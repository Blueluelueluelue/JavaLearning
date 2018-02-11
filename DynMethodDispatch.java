class A
{
  public void show() {
    System.out.println("in A");
  }
}

class B extends A
{
  public void show() {
    System.out.println("in B");
  }
}

class C extends A
{
  public void show() {
    System.out.println("in C");
  }
}

class DynMethodDispatch
{     // 2 types of polymorphisms - compile time and runtime polymorphism
  public static void main(String[]args)
  {
    A obj1 = new B();     //runtime polymorphism
    obj1.show();

    obj1 = new C();       //dynamic method dispatch
    obj1.show();
  }
}
