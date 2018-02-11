import java.lang.*;
import java.util.Scanner;
class Series2 /*1+1/2!+1/3!+1/4!+....1/n!*/
{
public static int fact(int n)
{
if(n==0 || n==1)
return 1;
return fact(n-1)*n;
}

public static void main(String args[])
{
int n,i;
float sum=0;
System.out.println("enter the no. of terms");
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
for(i=1;i<=n;i++)
sum+=1/(float)fact(i);
System.out.println("The sum is "+sum);
}
}
