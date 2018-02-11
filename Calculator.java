import java.lang.*; import java.util.Scanner;
class Calculator
{   public static void main(String args[])
{   int a,b,choice,c;
Scanner sc=new Scanner(System.in);
System.out.println("enter 2 numbers");
a=sc.nextInt();             b=sc.nextInt();
System.out.println("enter your choice\n
1.Add\n2.Subtract\n3.Multiply\n4.Divide
\n5.Modulus");
choice=sc.nextInt();
switch(choice)
{     case 1:
c=a+b; break;
case 2:
c=a-b; break;
case 3:
c=a*b; break;
case 4:
c=a/b; break;
case 5:
c=a%b; break;
default : c=0;
System.out.println("invalid choice"); break;               }
System.out.println("The answer is:"+c);    }}