import java.lang.*;
import java.util.Scanner;
class PatternNumberSquare
{
public static void main(String args[])
{
int i,j,n,k;
Scanner sc=new Scanner(System.in);
System.out.println("enter the number of lines");
n=sc.nextInt();
for(i=1;i<=n;i++)
{
k=i;
for(j=1;j<=n;j++)
{
if(k<n)
{
System.out.print(k+" ");
k++;
}
else if(k>=n)
{
System.out.print(k+" ");
k-=n-1;
}
}
System.out.println();
}
}
}