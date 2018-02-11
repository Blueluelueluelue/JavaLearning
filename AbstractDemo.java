/* Abstract class */
abstract class Fruit {
   // abstract method ( will be defined in subclass )
   abstract void fruitInfo();
}

class Mango extends Fruit {
   void fruitInfo() {
      System.out.println("My name is Mango. I am a fruit");
   }
}

class Apple extends Fruit {
   void fruitInfo() {
      System.out.println("My name is Apple. I am a fruit");
   }
}

public class AbstractDemo {
   public static void main(String args[]) {
      Fruit m = new Mango();
      Fruit a = new Apple();
      m.fruitInfo();
      a.fruitInfo();
   }
}