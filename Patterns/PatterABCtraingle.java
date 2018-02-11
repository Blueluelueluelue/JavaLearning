import java.lang.*;
import java.util.Scanner;
class PatterABCtraingle
{
public static void main(String args[])
{
int n,i,j;
char ch;
System.out.println("enter no. of lines");
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
for(i=1;i<n;i++)
{
ch='A';
for(j=1;j<=n-i;j++)
System.out.print(" ");
for(j=1;j<=i;j++,ch++)
System.out.print(ch);
ch-=2;
for(j=1;j<i;j++,ch--)
System.out.print(ch);
System.out.println();
}
}
}