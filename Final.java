class A
{
  final int TEN = 10;        //constant
  // TEN = 11;       ERROR
  final int i = 6;
  final int j;
  public A() {
    // i = 5;        ERROR
    j = 11;         //NO ERROR because the int becomes a constant AFTER it gets a value assigned to it.
  }
  public final void show() {        //final methods cannot be overriden
    System.out.println("in A show");
  }
}

class B extends A
{
  // public void show() {            ERROR
  //   System.out.println("in B show");
  // }
}

final class C     // final classes cannot be extended
{

}

// class D extends C       ERROR
// {
//
// }

public class Final
{
  public static void main(String[]args)
  {
    A obj = new A();
    System.out.println(obj.j);
  }
}
