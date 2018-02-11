import java.lang.*;
import java.util.*;
class StrMethods
{
	public static void main(String[] args)
	{
		String s=new String("Hello World");
		System.out.println("The string is\n"+s);
		System.out.println("Its length is :"+s.length());
		System.out.println("The character at index 4 is '"+s.charAt(4)+"'");
		int csize=s.length();
		char c[]=new char [csize];
		System.out.println("After converting to character array");
		c=s.toCharArray();
		for(int i=0;i<csize;i++)
			System.out.print(c[i]+"  ");
		System.out.println();
		String s2=new String("HELLO WORLD");
		System.out.println("The second string is "+s2);
		System.out.println("Are they both equal?\n"+s.equals(s2));		
		System.out.println("Are they both equal if ignored case?\n"+s.equalsIgnoreCase(s2));
		System.out.println("Which one is greater?");
		int g=s.compareTo(s2);
		if(g<0)
			System.out.println(s);
		else if(g>0)
			System.out.println(s2);
		else
			System.out.println("Equal");
		System.out.println("Which one is greater if ignored case?");
		g=s.compareToIgnoreCase(s2);
		if(g<0)
			System.out.println(s);
		else if(g>0)
			System.out.println(s2);
		else
			System.out.println("Equal");
		System.out.println("After converting string 1 to uppercase\n"+s.toUpperCase());		
		System.out.println("After converting string 2 to lowercase\n"+s2.toLowerCase());		
		System.out.println("Index of 'o' in string 1 is "+s.indexOf('o'));
		System.out.println("Index of \"orld\" in string 1 is "+s.indexOf("orld"));
		System.out.println("Does String 1 start with \"Hell\"?\n"+s.startsWith("Hell"));
		System.out.println("Does String 1 start with \"orld\" from index 7?\n"+s.startsWith("orld",7));
		System.out.println("Does String 2 end with \"ORLD\"?\n"+s2.endsWith("ORLD"));
		System.out.println("substring of string 2 from index 3 to 9\n"+s2.substring(3,10));
		System.out.println("substring of string 2 from index 3 to the end\n"+s2.substring(3));
		System.out.println("last occurence of 'o' is at index "+s.lastIndexOf('o'));
		System.out.println("last occurence of \"Wor\" is at index "+s.lastIndexOf("Wor"));
		char c1[]={'1','+','2','=','3'};
		System.out.println("String representation of 1 + 2 = 3\n"+String.valueOf(c1));
	}
}