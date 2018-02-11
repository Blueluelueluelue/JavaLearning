import java.lang.*;
import java.util.*;
class StringBufferMethods
{
	public static void main(String[] args)
	{
		StringBuffer s=new StringBuffer("Hello World");
		System.out.println("The buffer is "+s);
		System.out.println("Its length is "+s.length());
		System.out.println("Its capacity is "+s.capacity());
		s.ensureCapacity(100);
		System.out.println("Its capacity is "+s.capacity());
		s.append(" How Are You?");
		System.out.println(s);
		System.out.println("Its length is "+s.length());
		System.out.println("Its capacity is "+s.capacity());
		System.out.println("The reverse is\n"+s.reverse());
		s.reverse();
		s.delete(4,9);
		System.out.println("After deleting from index 4 to 8\n"+s);
		System.out.println("Deleting index 8 in the string\n"+s.deleteCharAt(8));
		System.out.println("after replacing a substring\n"+s.replace(4,4,"o Wor"));
		System.out.println("Appending \"12345\" in the string\n"+s.append("12345"));
	}
}
