import java.lang.*;
import java.util.Scanner;
class PatternWords1
{
public static void main(String[] args)
{
int i,j,size;
System.out.println("enter a string without spaces");
Scanner sc=new Scanner(System.in);
String temp=sc.nextLine();
size=temp.length();
String str=temp.toUpperCase();
char c[]=new char [size];
c=str.toCharArray();
for(i=size-1;i>=0;i--)
{
	for(j=size-1;j>i;j--)
		System.out.print("  ");
	for(j=0;j<=i;j++)
		System.out.print(c[size-i-1+j]+" ");
	System.out.println();
}
}
}