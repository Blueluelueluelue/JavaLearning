import java.lang.*;
import java.util.Scanner;
class Marks
{
public static void main(String args[])
{
int size,i,c;
String s;
System.out.println("enter the no. of students");
Scanner sc=new Scanner(System.in);
size=sc.nextInt();
int a[]=new int[size];
System.out.println("enter the marks of each student");
for(i=0;i<size;i++)
a[i]=sc.nextInt();
for(i=0;i<size;i++)
{
if(a[i]==100)
s=new String("Distinction");
else if(a[i]<0)
s=new String("Invalid marks");
else
switch (a[i]/10)
{
case 7:
case 8:
case 9:
s=new String("Distinction");
break;
case 6:
s=new String("First Class");
break;
case 5:
s=new String("Second Class");
break;
case 4:
s=new String("Pass");
break;
case 0:
case 1:
case 2:
case 3:
s=new String("Fail");
break;
default:
s=new String("Invalid marks");
break;
}
System.out.println("Student no. "+(i+1)+" - "+s);
}
}
}