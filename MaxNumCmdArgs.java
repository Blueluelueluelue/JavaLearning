import java.lang.*;
class MaxNumCmdArgs
{
public static void main(String args[])
{
int a,b,c;
a=Integer.parseInt(args[0]);
b=Integer.parseInt(args[1]);
c=Integer.parseInt(args[2]);
if(a>b && a>c)
System.out.print("Largest number is :"+a);
else if (b>a && b>c)
System.out.print("Largest number is :"+b);
else if(c>a && c>b)
System.out.print("Largest number is :"+c);
}
}