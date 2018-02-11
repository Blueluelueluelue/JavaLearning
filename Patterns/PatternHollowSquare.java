import java.lang.*;
import java.util.Scanner;
class PatternHollowSquare
{
public static void main(String args[])
{
int i,j,n;
Scanner sc=new Scanner(System.in);
System.out.println("enter the last line");
n=sc.nextInt();
for(i=1;i<=n;i++)
{
for(j=1;j<=n;j++)
{
if(i==1||i==n||j==1||j==n)
System.out.print("* ");
else
System.out.print("  ");
}
System.out.println();
}
}
}