public class Wrapper
{
  public static void main(String[]args)
  {
    int i = 5;   //int is a primitive datatype
    Integer ii = new Integer(5);   //Integer is a Wrapper class
    Integer i2 = new Integer(i);   //Boxing or Wrapping
    int j = ii.intValue();         //Unboxing or Unwrapping

    Integer value = i;            //Autoboxing or Autowrapping
    int k = i2;                   //Autounboxing or Autounwrapping

    String str = "123";
    int intstr = Integer.parseInt(str);     //have to call static method parseInt
                                            //to convert a String into an int
  }
}
