import java.lang.*;
import java.util.Scanner;
class PatternHalfDiamond
{
public static void main(String args [])
{
int n,i,j;
Scanner sc=new Scanner (System.in);
System.out.println("enter the middle line");
n=sc.nextInt();
for(i=1;i<=n;i++)
{
for(j=1;j<=n-i;j++)
System.out.print(" ");
for(j=1;j<=i;j++)
System.out.print("*");
System.out.println();
}
for (i=n;i>1;i--)
{
for(j=n;j>=i;j--)
System.out.print(" ");
for (j=i;j>1;j--)
System.out.print("*");
System.out.println();
}
}}
