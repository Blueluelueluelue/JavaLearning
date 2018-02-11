import java.lang.*;
import java.util.Scanner;
class Series1 /*1+1/2+1/3+1/4+....1/n*/
{
public static void main(String args[])
{
int n,i;
float sum=0;
System.out.println("enter the no. of terms");
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
for(i=1;i<=n;i++)
sum+=1/(float)i;
System.out.println("The sum is "+sum);
}
}
