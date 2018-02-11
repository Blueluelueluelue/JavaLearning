import java.lang.*;
import java.util.Scanner;
class PyramidNumber
{
public static void main(String args[])
{
int n,i,j;
Scanner sc=new Scanner(System.in);
System.out.println("enter no. of lines");
n=sc.nextInt();
for(i=1;i<=n;i++)
{
for(j=1;j<=n-i;j++)
System.out.print(" ");
for(j=1;j<=i;j++)
System.out.print(j);
j-=2;
while(j>=1)
{
System.out.print(j);
j--;
}
System.out.println();
}
}
}