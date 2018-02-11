import java.lang.*;
import java.util.Scanner;
class Patternbinary
{
public static void main(String args[])
{
int i,j,n;
Scanner sc=new Scanner(System.in);
System.out.println("enter the no. of rows");
n=sc.nextInt();
for(i=1;i<=n;i++)
{
for(j=1;j<=i;j++)
System.out.print((i+j-1)%2+" ");
System.out.println();
}
}
}
