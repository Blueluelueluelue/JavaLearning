import java.lang.*;
import java.util.*;
class Palind
{
	public static void main(String[] args)
	{
		int i;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String s=sc.nextLine();
		char c[]=new char [s.length()];
		c=s.toLowerCase().toCharArray();
		for(i=0;i<s.length()/2;i++)
			if(c[i]!=c[s.length()-i-1])
				break;
		if(i==s.length()/2)
			System.out.println("Palindrome");
		else
			System.out.println("Not a palindrome");
		
	}
}