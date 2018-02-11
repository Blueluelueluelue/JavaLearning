import java.lang.*;
import java.util.Scanner;
class PatternDiamond
{
public static void main(String args[])
{
int i,j,n;
System.out.println("enter no. of lines");
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
for(i=1;i<=n;i++)
{
for(j=1;j<=n-i;j++)
System.out.print(" ");
for(j=1;j<=i;j++)
System.out.print("* ");
System.out.println();
}
for(i=n-1;i>=1;i--)
{
for(j=n-i;j>=1;j--)
System.out.print(" ");
for(j=i;j>0;j--)
System.out.print("* ");
System.out.println();
}
}}