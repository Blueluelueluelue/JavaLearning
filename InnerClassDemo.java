class Outer
{
  int i;
  public Outer(int j) {
    i = j;
  }
  public void show() {
    System.out.println("inside outer class and i = "+i);
  }

  class Inner
  {
    int k;
    public Inner(int m) {
      k = m;
    }
    public void display() {
      System.out.println("inside inner class and k = "+k);
    }

    class Inner2
    {
      int l;
      public Inner2(int n) {
        l = n;
      }
      public void project() {
        System.out.println("inside inner2 class and l = "+l);
      }
    }
  }

  public static class StatInner
  {
    static int s;
    public StatInner(int s) {
      this.s = s;            //this keyword lets you access the
                            // instance variable instead of the
                            // local variable when they both have the same name
    }
    public static void render() {
      System.out.println("inside statinner class and s = "+ s);
    }
  }
}

class InnerClassDemo
{
  public static void main(String[]args)
  {
    Outer objOut = new Outer(100);
    objOut.show();

    Outer.Inner objInn = objOut.new Inner(5);
    objInn.display();

    Outer.Inner.Inner2 objInn2 = objInn.new Inner2(75);
    objInn2.project();

    Outer.StatInner objStatInn = new Outer.StatInner(400);
    Outer.StatInner.render();
  }
}
